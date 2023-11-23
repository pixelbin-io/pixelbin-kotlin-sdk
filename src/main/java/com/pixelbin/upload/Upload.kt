package com.pixelbin.upload

import com.pixelbin.error.PDKTimeoutException
import kotlinx.coroutines.*
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import okio.buffer
import okio.source
import java.io.File
import java.io.FileInputStream
import java.io.IOException
import java.io.InputStream

/**
 * class for uploading file to aws bucket
 */
class Upload internal constructor(){

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
        callback: (Result<Any>) -> Unit
    ) {
        val url = signedDetails.url
        val fields = signedDetails.fields
        url?.let {
            if(it.contains("storage.googleapis.com")) uploadToGCS(it,fields, file,callback)
            else uploadToS3(it, fields, file,callback)
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
        builder.addFormDataPart("file", file.name, RequestBody.create(contentType, file))
        val form = builder.build()
        try {
            val client = NetworkUtil.createOkHttpClient()
            val request = Request.Builder()
                .url(url)
                .post(form)
                .build()

            client.newCall(request).enqueue(object :Callback{
                override fun onFailure(call: Call, e: IOException) {
                    callback(Result.Error(e))
                }

                override fun onResponse(call: Call, response: Response) {
                    if(response.code==200||response.code==204)
                        callback(Result.Success(response.message))
                    else if(response.code==408)
                        callback(Result.Error(PDKTimeoutException("Request timed out. Please check your internet connection and try again.")))
                    else
                        callback(Result.Failure(response))
                }
            })
        }
        catch (e:Exception){
            e.printStackTrace()
        }
    }

    fun uploadImageOn3gNetwork(
        file: File,
        signedDetails: SignedDetails,
        callback: (Result<Any>) -> Unit,
        chunkSizeInKb: Int = 3
    ) {
        var errorOccured = false;
        try {
            val CHUNK_SIZE = 1024 * chunkSizeInKb
            val fileSize = file.length()
            val startTime = System.currentTimeMillis()

            val client = NetworkUtil.createOkHttpClient()
            file.source().buffer().use { source ->
                var i = 0L
                while (i < fileSize && !errorOccured) {
                    val end = minOf(i + CHUNK_SIZE, fileSize)
                    val chunk = source.readByteArray(end - i)
                    val requestBody = MultipartBody.Builder()
                        .setType(MultipartBody.FORM)
                        .addFormDataPart("name", file.absolutePath)
                        .addFormDataPart("path", "multipart")
                        .addFormDataPart(
                            "x-pixb-meta-assetdata",
                            signedDetails.fields["x-pixb-meta-assetdata"] ?: ""
                        )
                        .addFormDataPart(
                            "file",
                            "chunk",
                            chunk.toRequestBody("application/octet-stream".toMediaType())
                        )
                        .build()

                    val request = Request.Builder()
                        .url(signedDetails.url ?: "")
                        .header("Content-Range", "bytes $i-$end/$fileSize")
                        .header("file-chunk-size", chunk.size.toString())
                        .post(requestBody)
                        .build()

                    try {
                        val response = client.newCall(request).execute()
                        if (response.code == 200) {
                            callback(Result.Success(response.message))
                        } else if (response.code == 408) {
                            errorOccured = true
                            callback(Result.Error(PDKTimeoutException("Request timed out. Please check your internet connection and try again.")))
                            return
                        } else {
                            errorOccured = true
                            callback(Result.Failure(response))
                            return
                        }


                    } catch (e: IOException) {
                        callback(Result.Error(e))
                    }
                    i = end
                }
                // Wait for all jobs to complete
            }
            val endTime = System.currentTimeMillis()
            println("Total time taken ${(endTime - startTime) / 1000}")
            if (!errorOccured) {
                val requestBody = MultipartBody.Builder()
                    .setType(MultipartBody.FORM)
                    .addFormDataPart("name", file.absolutePath)
                    .addFormDataPart("path", "multipart")
                    .addFormDataPart(
                        "x-pixb-meta-assetdata",
                        signedDetails.fields["x-pixb-meta-assetdata"] ?: ""
                    )
                    .build()
                var finalUrl = ""
                signedDetails.url?.split("?")?.let {
                    val base = it[0]
                    finalUrl = base + "/complete?" + it[1];
                }
                val request = Request.Builder()
                    .url(finalUrl)
                    .post(requestBody)
                    .build()

                try {
                    val response = client.newCall(request).execute()
                    if (response.code == 200) {
                        callback(Result.Success(response.message))
                    } else if (response.code == 408) {
                        errorOccured = true
                        callback(Result.Error(PDKTimeoutException("Request timed out. Please check your internet connection and try again.")))
                    } else {
                        errorOccured = true
                        callback(Result.Failure(response))
                    }

                } catch (e: IOException) {
                    callback(Result.Error(e))

                }
            }
        } catch (e: Exception) {
            callback.invoke(Result.Failure(e.message ?: ""))
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
    ){
        var count =0
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

        val client = NetworkUtil.createOkHttpClient()
        val response: Response = client.newCall(requestBuilder.build()).execute()
        if (!response.isSuccessful) {
            throw IOException("Failed to initiate session: $response")
        }

        val sessionUri = response.header("Location")
        val inputStream: InputStream =
            withContext(Dispatchers.IO) {
                FileInputStream(file)
            }
        val buffer = ByteArray(6000)
        var bytesRead: Int
        var totalBytesUploaded: Long = 0

        while (withContext(Dispatchers.IO) {
                inputStream.read(buffer)
            }.also { bytesRead = it } != -1) {
            val chunkBody: RequestBody = buffer.toRequestBody(
                "application/octet-stream".toMediaTypeOrNull(),
                0, bytesRead
            )
            val chunkRequestBuilder = Request.Builder()
                .url(sessionUri!!)
                .put(chunkBody)

            fields.forEach { (key, value) ->
                chunkRequestBuilder.addHeader(key, value)
            }

            val chunkResponse = client.newCall(chunkRequestBuilder.build()).execute()
            if (!chunkResponse.isSuccessful) {
                throw IOException("Failed to upload chunk: $chunkResponse")
            }
            totalBytesUploaded += bytesRead.toLong()
        }

        inputStream.close()
    }
}