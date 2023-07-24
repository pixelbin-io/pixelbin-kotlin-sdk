package com.pixelbin.upload
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import java.io.File

/**
 * class for uploading file to aws bucket
 */
class Upload internal constructor(){

    /**
     * method to make post request call
     *
     * @param url post api endpoint
     * @param form form data for post request
     */
    private fun signedUpload(url: String, form: MultipartBody) {
        try {
            val client = OkHttpClient()
            val request = Request.Builder()
                .url(url)
                .post(form)
                .build()

            client.newCall(request).execute()
        }
     catch (e:Exception){
         e.printStackTrace()
     }
    }

    /**
     * method to upload file to aws bucket
     *
     * @param file image file to upload
     *
     * signedDetails object containing signed url details
     */
    suspend fun upload(file: File, signedDetails: SignedDetails) {
        val url = signedDetails.url
        val fields = signedDetails.fields

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
         signedUpload(url, form)
    }
}