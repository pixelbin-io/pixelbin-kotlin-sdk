package com.pixelbin

import com.pixelbin.Utility.isImageUrlValid
import com.pixelbin.error.PDKIllegalArgumentException
import com.pixelbin.error.PDKInvalidUrlException
import com.pixelbin.upload.Result
import com.pixelbin.upload.SignedDetails
import com.pixelbin.upload.Upload
import com.pixelbin.url.Url
import com.pixelbin.url.UrlObj
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
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
     * @param isCustomDomain domain of the image url
     */
    @JvmOverloads
    fun url(imageUrl: String, isCustomDomain:Boolean?=false): Url {
        if(isImageUrlValid(imageUrl)){
            url = Url(imageUrl, isCustomDomain = isCustomDomain)
            return url as Url
        }else{
            throw PDKInvalidUrlException("invalid image url")
        }
    }

     /**
      * method to create url from urlObject
      * @param urlObj urlObject of the image
      * @param isCustomDomain domain of the image url
      */
     @JvmOverloads
    fun url(urlObj: UrlObj, isCustomDomain:Boolean?=false): Url {
        if(urlObj.baseUrl.isNullOrEmpty()||urlObj.cloudName.isNullOrEmpty()||urlObj.filePath.isNullOrEmpty())
            throw PDKIllegalArgumentException("invalid url object")
        else{
            url = Url(urlObject = urlObj,isCustomDomain=isCustomDomain)
        }
        return url as Url
    }

    /**
     * method to upload file to aws bucket
     *
     * @param file image file to upload
     * @param signedDetails signed details object containing url and headers
     *
     * signedDetails object containing signed url details
     */
     fun upload(file:File,signedDetails: SignedDetails,callback: (Result<Any>)-> Unit){
        CoroutineScope(Dispatchers.IO).launch{
            Upload().upload(file,signedDetails,callback)
        }
    }

    /**
     * method to upload file to aws bucket
     *
     * @param file image file to upload
     * @param signedDetails signed details object containing url and headers
     * @param chunkSizeInKb size of chunks in which file is break into and uploaded
     *
     * signedDetails object containing signed url details
     */
     @JvmOverloads
     fun uploadOn3gNetwork(file:File,signedDetails: SignedDetails,callback: (Result<Any>)-> Unit,chunkSizeInKb: Int = 3){
        CoroutineScope(Dispatchers.IO).launch{
            Upload().uploadImageOn3gNetwork(file,signedDetails,callback,chunkSizeInKb)
        }
    }

    companion object {
        @JvmStatic
        fun getInstance(): PixelBin {
            return PixelBin()
        }
    }
}