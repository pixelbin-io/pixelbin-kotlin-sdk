package io.pixelbin.sdk_kotlin.upload

import com.google.gson.Gson
import io.pixelbin.sdk_kotlin.error.PDKInvalidUrlException
import io.pixelbin.sdk_kotlin.error.PDKTimeoutException
import kotlinx.coroutines.*
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import okio.buffer
import okio.source
import java.io.File
import java.io.IOException


/**
 * class for uploading file to aws bucket
 */
class Upload internal constructor() {

    /**
     * method to upload file to aws bucket
     *
     * @param file image file to upload
     *
     * signedDetails object containing signed url details
     */
    suspend fun upload(
        file: File,
        signedDetails: SignedDetails,
        callback: (Result<Any>) -> Unit,
        chunkSize: Int,
        concurrency: Int = 1
    ) {
        val url = signedDetails.url
        val fields = signedDetails.fields
        url?.let {
            if (it.contains("storage.googleapis.com")) uploadToGCS(it, fields, file, callback)
            else if (it.contains("api.pixelbin")) multipartFileUpload(
                file,
                signedDetails,
                callback,
                chunkSize,
                concurrency
            )
            else uploadToS3(it, fields, file, callback)
        }
    }

    /**
     * method to make post request call
     *
     * @param url post api endpoint
     * @param fields signed url fields
     * @param file image file to upload
     */
    private suspend fun uploadToS3(
        url: String,
        fields: Map<String, String>,
        file: File,
        callback: (Result<Any>) -> Unit
    ) {
        if (url.isNullOrEmpty() || fields.isNullOrEmpty()) {
            throw Error("Please provide the correct object. Refer upload api docs for details.")
        }

        val builder = MultipartBody.Builder()
            .setType(MultipartBody.FORM)

        fields.forEach { (key, value) ->
            builder.addFormDataPart(key, value)
        }
        val contentType = "application/octet-stream".toMediaTypeOrNull()!!
        builder.addFormDataPart("file", file.name, file.asRequestBody(contentType))
        val form = builder.build()
        try {
            val client = NetworkUtil.createOkHttpClient()
            val request = Request.Builder()
                .url(url)
                .post(form)
                .build()

            client.newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    callback(Result.Error(e))
                }

                override fun onResponse(call: Call, response: Response) {
                    if (response.code == 200 || response.code == 204)
                        callback(Result.Success(response.message))
                    else if (response.code == 408)
                        callback(Result.Error(PDKTimeoutException("Request timed out. Please check your internet connection and try again.")))
                    else
                        callback(Result.Failure(response))
                }
            })
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun multipartFileUpload(
        file: File,
        signedDetails: SignedDetails,
        callback: (Result<Any>) -> Unit,
        chunkSize: Int,
        concurrency: Int = 1
    ) {
        var errorOccurred = false
        try {
            val CHUNK_SIZE = 1024 * chunkSize
            val fileSize = file.length()
            val startTime = System.currentTimeMillis()
            var partNo = 0
            val client = NetworkUtil.createOkHttpClient()
            CoroutineScope(Dispatchers.Default).launch {
                file.source().buffer().use { source ->
                    var i = 0L
                    while (i < fileSize && !errorOccurred) {
                        val batchDeferredList = mutableListOf<Deferred<Unit>>()

                        for (j in 0 until concurrency) {
                            if (i >= fileSize || errorOccurred) return@use

                            partNo++
                            val end = minOf(i + CHUNK_SIZE, fileSize)
                            val chunk = source.readByteArray(end - i)
                            val requestBody = MultipartBody.Builder()
                                .setType(MultipartBody.FORM)
                                .addFormDataPart(
                                    "file",
                                    "chunk",
                                    chunk.toRequestBody("application/octet-stream".toMediaType())
                                )
                            signedDetails.fields.forEach { (key, value) ->
                                requestBody.addFormDataPart(key, value)
                            }

                            val finalUrl = (signedDetails.url ?: "") + "&partNumber=${partNo}"
                            val request = Request.Builder()
                                .url(finalUrl)
                                .header("Content-Range", "bytes $i-$end/$fileSize")
                                .header("file-chunk-size", chunk.size.toString())
                                .put(requestBody.build())
                                .build()
                            withContext(Dispatchers.IO) {
                                val deferred = async {
                                    val response = client.newCall(request).execute()
                                    when (response.code) {
                                        200, 204 -> {
                                            val responseBody = response.body
                                            if (responseBody != null) {
                                                val json = responseBody.string()
                                                if (json.isNotEmpty()) {
                                                    val uploadResponse = Gson().fromJson(
                                                        json,
                                                        UploadResponse::class.java
                                                    )
                                                    val successResult = Result.Success(uploadResponse)
                                                    callback(successResult)
                                                }
                                            } else {
                                                errorOccurred = true
                                                callback(Result.Failure(response))
                                                cancel()
                                            }
                                        }

                                        408 -> {
                                            errorOccurred = true
                                            callback(Result.Error(PDKTimeoutException("Request timed out. Please check your internet connection and try again.")))
                                            cancel()
                                        }

                                        else -> {
                                            errorOccurred = true
                                            callback(Result.Failure(response))
                                            cancel()
                                        }
                                    }
                                }
                                if (deferred.isCancelled) {
                                    errorOccurred = true
                                    return@withContext
                                }
                                batchDeferredList.add(deferred)
                                i = end
                            }
                        }
                        batchDeferredList.awaitAll()
                    }
                }
                val endTime = System.currentTimeMillis()
                println("Total time taken ${(endTime - startTime) / 1000}")
                if (!errorOccurred) {
                    val partList = arrayListOf<Int>()
                    for (i in 1..partNo) {
                        partList.add(i)
                    }
                    val gson = Gson()
                    val map = HashMap<String, Any>()
                    signedDetails.fields.forEach { (key, value) ->
                        map[key] = value
                    }
                    map["parts"] = partList
                    map["uploadId"] = extractPbuValue(signedDetails.url)
                    val jsonBody = gson.toJson(map)
                    val requestBody =
                        jsonBody.toRequestBody("application/json".toMediaTypeOrNull())

                    val request = Request.Builder()
                        .url(signedDetails.url ?: "")
                        .post(requestBody)
                        .addHeader("Content-Type", "application/json")
                        .build()
                    val response = client.newCall(request).execute()
                    when (response.code) {
                        200 -> {
                            val responseBody = response.body
                            if (responseBody != null) {
                                val json = responseBody.string()
                                if (json.isNotEmpty()) {
                                    val uploadResponse = Gson().fromJson(
                                        json,
                                        UploadResponse::class.java
                                    )
                                    val successResult = Result.Success(uploadResponse)
                                    callback(successResult)
                                }
                            } else {
                                errorOccurred = true
                                callback(Result.Failure(response))
                                cancel()
                            }
                        }

                        408 -> {
                            errorOccurred = true
                            callback(Result.Error(PDKTimeoutException("Request timed out. Please check your internet connection and try again.")))
                        }

                        else -> {
                            errorOccurred = true
                            callback(Result.Failure(response))
                        }
                    }
                }
            }
        } catch (e: Exception) {
            callback.invoke(Result.Failure(e.message ?: ""))
        }
    }

    private fun extractPbuValue(url: String?): String {
        return try {
            val regex = Regex("[?&]pbu=([^&]+)")
            val matchResult = url?.let { regex.find(it) }
            matchResult?.groups?.get(1)?.value ?: ""
        } catch (e: Exception) {
            throw PDKInvalidUrlException("Invalid image url")
        }
    }

    /**
     * method to make post request call
     *
     * @param url post api endpoint
     * @param fields signed url fields
     * @param file image file to upload
     */
    private suspend fun uploadToGCS(
        url: String,
        fields: Map<String, String>,
        file: File,
        callback: (Result<Any>) -> Unit
    ) {
        if (url.isNullOrEmpty() || fields.isNullOrEmpty()) {
            throw Error("Please provide the correct object. Refer upload api docs for details.")
        }
        val requestBuilder = Request.Builder()
            .url(url)

        fields.forEach { (key, value) ->
            requestBuilder.addHeader(key, value)
        }
        val requestBody = file.asRequestBody("application/octet-stream".toMediaTypeOrNull())
        requestBuilder.method("PUT", requestBody)

        // Build the request
        val request = requestBuilder.build()
        try {
            val client = NetworkUtil.createOkHttpClient()
            client.newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    callback(Result.Error(e))
                }

                override fun onResponse(call: Call, response: Response) {
                    if (response.code == 200)
                        callback(Result.Success(response.message))
                    else if (response.code == 408)
                        callback(Result.Error(PDKTimeoutException("Request timed out. Please check your internet connection and try again.")))
                    else
                        callback(Result.Failure(response))
                }
            })
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
