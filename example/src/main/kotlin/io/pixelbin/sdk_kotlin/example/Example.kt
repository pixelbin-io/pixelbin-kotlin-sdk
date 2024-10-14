package io.pixelbin.sdk_kotlin.example

import io.pixelbin.sdk_kotlin.PixelBin
import io.pixelbin.sdk_kotlin.Transformation
import io.pixelbin.sdk_kotlin.transformation.EraseBg
import io.pixelbin.sdk_kotlin.upload.Result
import io.pixelbin.sdk_kotlin.upload.SignedDetails
import kotlinx.coroutines.runBlocking
import java.io.File
import java.io.InputStream
import java.nio.file.Files
import java.util.concurrent.CountDownLatch

fun main(): Unit =
    runBlocking {
        // Making Url object from String
        val url =
            PixelBin
                .getInstance()
                .url(imageUrl = "https://cdn.pixelbin.io/v2/dummy-cloudname/original/__playground/playground-default.jpeg")

        // Creating Transformations
        val eraseBgTransformation = Transformation.eraseBg(industrytype = EraseBg.Industrytype.HUMAN)
        val resizeTransformation = Transformation.tResize(width = 200)
        val vaiRemoveBgTransformation = Transformation.vertexaiRemovebg()
        val vaiGenerateBgTransformation = Transformation.vertexaiGeneratebg()

        // Applying transformation
        url.apply {
            addTransformation(eraseBgTransformation)
            addTransformation(vaiRemoveBgTransformation)
            addTransformation(vaiGenerateBgTransformation)
            addTransformation(resizeTransformation)
        }

        // Encoding Url Object to String
        val encodedUrl = url.getUrl()

        println("Encoded: $encodedUrl")

//    val file = ResourceLoader.loadFileFromResources("sample.jpg")
//    val uploadResult: Result<Any>? = file?.let { uploadFilePixelBin(it) }
//    when (uploadResult) {
//        is Result.Success -> {
//            val response: UploadResponse =
//                uploadResult.data as UploadResponse
//            println(
//                "Response: id:${response._id} - url: ${response.url} - meta: ${
//                    response.metadata?.get(
//                        "source"
//                    )
//                }"
//            )
//        }
//
//        is Result.Failure -> {
//            val response = uploadResult.response
//            println("Failure: $response")
//        }
//
//        is Result.Error -> {
//            val exception = uploadResult.exception
//            println("Error: ${exception.message.toString()}")
//        }
//
//        else -> {
//            println("result is null")
//        }
//    }
    }

suspend fun uploadFilePixelBin(file: File): Result<Any> {
    println(file.absolutePath)
    val fields =
        mapOf(
            "x-pixb-meta-assetdata" to
                "{\"orgId\":5814399,\"type\":\"file\",\"name\":\"filename.jpeg\",\"path\":\"path/to/containing/folder\",\"fileId\":\"path/to/containing/folder/filename.jpeg\",\"format\":\"jpeg\",\"s3Bucket\":\"erase-erase-erasebg-assets\",\"s3Key\":\"uploads/vijay-744d3d/original/d3ed0ab2-d273-4899-9531-df843befc91a.jpeg\",\"access\":\"public-read\",\"tags\":[\"tag1\",\"tag2\"],\"metadata\":{\"source\":\"signedUrl\",\"publicUploadId\":\"f27b2a67-199e-4f11-8938-04a2945469af\"},\"overwrite\":false,\"filenameOverride\":true}",
        )

    val signedDetails =
        SignedDetails(
            url = "https://api.pixelbin.io/service/public/assets/v1.0/signed-multipart?pbs=174b1c38c4f7423cdfc5c92ed42410db4b27b1c6d3239ee5e22eb96268346922&pbe=1725870809434&pbt=9310166e-34b1-43a7-93a8-e659c371230f&pbo=5814399&pbu=f27b2a67-199e-4f11-8938-04a2945469af",
            fields = fields,
        )
    val latch = CountDownLatch(1)
    var uploadResult: Result<Any> = Result.Error(Exception("Still loading"))

    PixelBin.getInstance().upload(file, signedDetails, {
        uploadResult = it
        latch.countDown()
    })
    latch.await()
    return uploadResult
}

object ResourceLoader {
    fun loadFileFromResources(fileName: String): File? {
        val inputStream: InputStream? = this::class.java.getResourceAsStream("/$fileName")
        return inputStream?.let {
            val tempFile = Files.createTempFile("temp", ".jpg").toFile()
            tempFile.outputStream().use { outputStream ->
                it.copyTo(outputStream)
            }
            tempFile
        }
    }
}
