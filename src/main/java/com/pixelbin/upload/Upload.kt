package com.pixelbin.upload
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File
import java.io.IOException

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
    suspend fun upload(file: File, signedDetails: SignedDetails,callback: (Result<Any>)-> Unit) {
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
    private suspend fun uploadToS3(url:String, fields:Map<String,String>, file:File, callback: (Result<Any>)-> Unit){
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
            val client = OkHttpClient()
            val request = Request.Builder()
                .url(url)
                .post(form)
                .build()

            client.newCall(request).enqueue(object :Callback{
                override fun onFailure(call: Call, e: IOException) {
                    callback(Result.Error(e))
                }

                override fun onResponse(call: Call, response: Response) {
                    if(response.code==200)
                        callback(Result.Success(response.message))
                    else
                        callback(Result.Failure(response))
                }
            })
        }
        catch (e:Exception){
            e.printStackTrace()
        }
    }
    /**
     * method to make post request call
     *
     * @param url post api endpoint
     * @param fields signed url fields
     * @param file image file to upload
     */
    private suspend fun uploadToGCS(url:String, fields:Map<String,String>, file:File, callback: (Result<Any>)-> Unit){
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
            val client = OkHttpClient()
            client.newCall(request).enqueue(object :Callback{
                override fun onFailure(call: Call, e: IOException) {
                    callback(Result.Error(e))
                }

                override fun onResponse(call: Call, response: Response) {
                    if(response.code==200)
                        callback(Result.Success(response.message))
                    else
                        callback(Result.Failure(response))
                }
            })
        }
        catch (e:Exception){
            e.printStackTrace()
        }
    }
}