package io.pixelbin.sdk_kotlin

import io.pixelbin.sdk_kotlin.transformation.TransformationObj

internal object Utility {

    /**
     * method to get string containing all transformations
     */
    fun getTransformationString(transformation: ArrayList<TransformationObj>): String {
        var finalString = ""
        for ((index, item) in transformation.withIndex()) {
            finalString = if (transformation.size == 1 || index == 0) {
                getTransformationValue(item)
            } else {
                finalString + "~" + getTransformationValue(item)
            }
        }
        return finalString
    }

    /**
     * method to get transformation string value from transformation object
     */
    private fun getTransformationValue(transformation: TransformationObj): String {
        val parametersString = transformation.values?.entries?.joinToString(",") { "${it.key}:${it.value}" }
        return if (parametersString?.isNotEmpty() == true) "${transformation.plugin}.${transformation.name}($parametersString)" else "${transformation.plugin}.${transformation.name}()"
    }

    /**
     * method to check if given color is hex color
     */
    fun isHexColor(color: String): Boolean {
        val hexColorRegex = Regex("^#?([0-9A-Fa-f]{3}|[0-9A-Fa-f]{6})$")
        return hexColorRegex.matches(color)
    }

    /**
     * method to check if url is valid
     */
    fun isImageUrlValid(url: String): Boolean {
        val pattern = Regex(".*\\.(jpg|jpeg|png|gif)(\\?.*)?$", RegexOption.IGNORE_CASE)
        return pattern.matches(url)
    }
}
