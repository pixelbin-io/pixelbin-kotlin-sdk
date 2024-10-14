package io.pixelbin.sdk_kotlin

import io.pixelbin.sdk_kotlin.Utility.isImageUrlValid
import io.pixelbin.sdk_kotlin.error.PDKIllegalArgumentException
import io.pixelbin.sdk_kotlin.error.PDKInvalidUrlException
import io.pixelbin.sdk_kotlin.upload.Result
import io.pixelbin.sdk_kotlin.upload.SignedDetails
import io.pixelbin.sdk_kotlin.upload.Upload
import io.pixelbin.sdk_kotlin.url.Url
import io.pixelbin.sdk_kotlin.url.UrlObj
import java.io.File

/**
 * pixelbin class to access url
 */
class PixelBin internal constructor() {
    private var url: Url? = null

    /**
     * method to create url object from image url
     *
     * @param imageUrl url of the image
     * @param isCustomDomain domain of the image url
     */
    @JvmOverloads
    fun url(
        imageUrl: String,
        isCustomDomain: Boolean? = false,
    ): Url {
        if (isImageUrlValid(imageUrl)) {
            url = Url(imageUrl, isCustomDomain = isCustomDomain)
            return url as Url
        } else {
            throw PDKInvalidUrlException("invalid image url")
        }
    }

    /**
     * method to create url from urlObject
     * @param urlObj urlObject of the image
     * @param isCustomDomain domain of the image url
     */
    @JvmOverloads
    fun url(
        urlObj: UrlObj,
        isCustomDomain: Boolean? = false,
    ): Url {
        if (urlObj.baseUrl.isEmpty() || urlObj.cloudName.isEmpty() || urlObj.filePath.isEmpty()) {
            throw PDKIllegalArgumentException("invalid url object")
        } else {
            url = Url(urlObject = urlObj, isCustomDomain = isCustomDomain)
        }
        return url as Url
    }

    /**
     * method to upload file to aws bucket
     *
     * @param file image file to upload
     * @param signedDetails signed details object containing url and headers
     * @param chunkSize size of chunks in which file is break into and uploaded. Default value 1024
     * @param concurrency number of parallel uploads
     * @param callback callback for api response
     *
     * signedDetails object containing signed url details
     */
    @JvmOverloads
    suspend fun upload(
        file: File,
        signedDetails: SignedDetails,
        callback: (Result<Any>) -> Unit,
        chunkSize: Int = 1024,
        concurrency: Int = 1,
    ) {
        Upload().upload(file, signedDetails, callback, chunkSize, concurrency)
    }

    companion object {
        @JvmStatic
        fun getInstance(): PixelBin = PixelBin()
    }
}
