package com.pixelbin

import com.pixelbin.Utility.isImageUrlValid
import com.pixelbin.upload.SignedDetails
import com.pixelbin.upload.Upload
import com.pixelbin.url.Url
import com.pixelbin.url.UrlObj
import java.io.File

/**
 * pixelbin class to access url
 */
class PixelBin internal constructor(){
    private var url: Url? = null

    /**
     * method to create url object from image url
     *
     * @param imageUrl url of the image
     */
    fun url(imageUrl: String): Url {
        if(isImageUrlValid(imageUrl)){
            url = Url(imageUrl)
            return url as Url
        }else{
            throw IllegalArgumentException("invalid image url")
        }
    }

     /**
     * method to create url from urlObject
     *
     * @param urlObj urlObject of the image
     */
    fun url(urlObj: UrlObj): Url {
        if(urlObj.baseUrl.isNullOrEmpty()||urlObj.cloudName.isNullOrEmpty()||urlObj.filePath.isNullOrEmpty())
            throw IllegalArgumentException("invalid url object")   
        else{
            url = Url(urlObject = urlObj)  
        }
        return url as Url
    }

    /**
     * method to upload file to aws bucket
     *
     * @param file image file to upload
     *
     * signedDetails object containing signed url details
     */
    suspend fun upload(file:File,signedDetails: SignedDetails){
        Upload().upload(file,signedDetails)
    }

    companion object {
        @JvmStatic
        fun getInstance(): PixelBin {
            return PixelBin()
        }
    }
}