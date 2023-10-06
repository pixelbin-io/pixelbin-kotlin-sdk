package com.pixelbin.url

import com.pixelbin.Utility
import com.pixelbin.error.PDKIllegalStateException
import com.pixelbin.error.PDKInvalidUrlException
import com.pixelbin.error.PDKTransformationException
import com.pixelbin.transformation.TransformationObj
import com.pixelbin.transformation.TransformationMap.hashMap

/**
 * class for maintaining image url
 */
class Url @JvmOverloads internal constructor(
    imgUrl: String?=null,
    urlObject: UrlObj?=null,
    isCustomDomain: Boolean?=false
) {
    private var imageUrl: String = ""
    private var originalUrl = ""
    var urlObj: UrlObj? = null
    private val originalPath = "original/"

    /**
     * method to set url components and make url object
     *
     * @param imageUrl url of the image
     */
    private fun setUrlComponents(imageUrl: String, isCustomDomain: Boolean?) {
        try {
            val baseUrlEndIndex = imageUrl.indexOf("/", imageUrl.indexOf("//") + 2)
            val baseUrl = imageUrl.substring(0, baseUrlEndIndex )
            val remainingUrl = imageUrl.substring(baseUrlEndIndex + 1)
            val parts = remainingUrl.split("/").toMutableList()

            val transformationList: ArrayList<TransformationObj> = ArrayList()
            var cloudName = ""
            var version = ""
            var zone = ""
            var imagePath = ""
            var worker = false;
            var workerPath = ""
            var remainingPath = ""
            if(imageUrl.contains("wrkr")){
                if (parts.size >= 2 && parts[0].startsWith("v")) {
                    version = parts[0]
                    parts.removeAt(0)
                    cloudName = parts[0]
                    parts.removeAt(0)
                    if (parts[1] == "wrkr") {
                        zone = parts[0]
                        parts.removeAt(0)
                    }
                    worker = true
                    remainingPath = parts.joinToString("/")
                    workerPath = if(remainingPath.contains("?")) remainingPath.substringBefore("?") else remainingPath
                    parts.clear()
                }
            }else{
                if (parts.size >= 2 && parts[0].startsWith("v")) {
                    version = parts[0]
                    parts.removeAt(0)
                    cloudName = parts[0]
                    parts.removeAt(0)
                    if (parts[1] == "original" || parts[1].contains("(")) {
                        zone = parts[0]
                        parts.removeAt(0)
                    }
                    if (parts.size >= 1 && parts[0] != "original") {
                        parts[0].split("~").forEach { transformation ->

                            val transformationName = transformation.split("(")[0]
                            if(hashMap.contains(transformationName)){
                                val map: HashMap<String, String> = HashMap()
                                if (transformation.contains(":")) {
                                    addValuesToHashMap(
                                        transformation.substring(1, transformation.length - 1),
                                        map
                                    )
                                }
                                addTransformation(transformationName, transformationList, map)
                            }else{
                                throw PDKInvalidUrlException("invalid image url")
                            }

                        }
                    }
                    parts.removeAt(0)
                    remainingPath = parts.joinToString("/")
                    imagePath = if(remainingPath.contains("?")) remainingPath.substringBefore("?") else remainingPath
                    parts.clear()
                }
            }

            urlObj = UrlObj(
                baseUrl = baseUrl,
                version = version,
                cloudName = cloudName,
                transformation = transformationList,
                zone = zone,
                filePath = imagePath,
                options = extractUrlParams(remainingPath),
                isCustomDomain = isCustomDomain,
                worker = worker,
                workerPath = workerPath
            )
        } catch (e: Exception) {
           throw PDKInvalidUrlException("invalid image url")
        }
    }

     /**
     * method to extract urlParams
     */
    private fun extractUrlParams(urlString: String): HashMap<String, String> {
        val queryStartIndex = urlString.indexOf('?')
        if (queryStartIndex == -1) {
            return HashMap()
        }

        val query = urlString.substring(queryStartIndex + 1)
        val params: HashMap<String, String> = HashMap()
        val pairs = query.split("&")
        for (pair in pairs) {
            val keyValue = pair.split("=")
            if (keyValue.size == 2) {
                val key = keyValue[0]
                val value = keyValue[1]
                params[key] = value
            }
        }

        return params
    }

    /**
     * method to break transformation string and add its key value pairs to map
     *
     * @param input transformation string
     * @param map where key value pairs of transformation variables stored
     */
    private fun addValuesToHashMap(input: String, map: HashMap<String, String>) {
        val regex = Regex("(\\w+):(.+)")
        val matches = regex.findAll(input)
        for (match in matches) {
            val (key, value) = match.destructured
            val numericValue = value.toDoubleOrNull()
            val floatValue = value.toFloatOrNull()
            map[key] = when {
                numericValue != null -> numericValue.toString()
                floatValue != null -> floatValue.toString()
                else -> value
            }
        }
    }

    /**
     * method to get transformationObj from name and add to transformation list
     *
     * @param transformationName name of the transformation in url
     * @param map map containing key value pairs of transformation variable
     * @param transformationList list of all transformations in the url
     */
    private fun addTransformation(
        transformationName: String,
        transformationList: ArrayList<TransformationObj>,
        map: HashMap<String, String>
    ) {
        val transformationObj = getTransformationObj(transformationName, map)
        transformationList.add(transformationObj)
    }

    /**
     * method to get transformation object from transformationMap
     *
     * @param transformationName name of the transformation in url
     * @param map map containing key value pairs of transformation variable
     */
    private fun getTransformationObj(
        transformationName: String,
        map: HashMap<String, String>
    ): TransformationObj {
        val transformationObj = hashMap[transformationName]
        if (transformationObj != null) {
            // If the transformation object is found in the map, add it to the transformation set
            return transformationObj.copy(values = map)
        } else
            throw PDKTransformationException("transformation not found in transformationMap")
    }

    init {
        if (imgUrl != null) {
            imageUrl = imgUrl
            setUrlComponents(imageUrl,isCustomDomain)
            originalUrl = imageUrl
        }
        if(urlObject!=null){
            urlObj = urlObject
        }
    }

    /**
     * method to add list of transformation
     *
     * @param list list of transformations to be added in url
     */
    fun addTransformation(list: ArrayList<TransformationObj>): Url {
        if(urlObj==null){
            throw PDKIllegalStateException("url object is null.")
        }
        if(urlObj?.worker==false){
            urlObj?.transformation?.addAll(list)
        }
        return this
    }

    /**
     * method to add single transformation
     *
     * @param transformation single transformation to be added to url
     */
    fun addTransformation(transformation: TransformationObj): Url {
        if(urlObj==null){
            throw PDKIllegalStateException("url is empty .")
        }
        if(urlObj?.worker==false){
            urlObj?.transformation?.add(transformation)
        }

        return this
    }

      /**
     * method to create url with transformation and
     */
    private fun create(): String {
        val transformedUrl = urlObj?.run {
            val transformationString =
                urlObj?.transformation?.let { Utility.getTransformationString(it) }
            val zoneValue = if (zone.isNullOrEmpty()) "" else "${zone}/"
            val transValue = if (urlObj?.transformation?.isEmpty() == true)
                originalPath
            else "${transformationString}/"
            val optionValue = if (options.isNullOrEmpty()) "" else getOptionParamString(options!!)
            val workerFinalPath = if(zoneValue.isNullOrEmpty())workerPath else "/${zoneValue}${workerPath}"
            if(urlObj?.worker==true)
                "${baseUrl}/${version}/${cloudName}${workerFinalPath}"
                else
            "${baseUrl}/${version}/${cloudName}/${zoneValue}${transValue}${filePath}${optionValue}"
        } ?: ""
        return transformedUrl
    }

    /**
     * method to get options string
     */
    private fun getOptionParamString(map: HashMap<String, String>): String {
        val dpr = map["dpr"]
        val fAuto = map["f_auto"]
        return "?dpr=${dpr}&f_auto=${fAuto}"
    }

    /**
     * method to return url object from url
     */
    fun getUrlObject():UrlObj?{
        if(urlObj==null)
            throw PDKIllegalStateException("UrlObj is null.")
        else
            return urlObj
    }

    /**
     * method to get current url
     */
    fun getUrl():String{
        return create()
    }
}