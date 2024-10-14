package io.pixelbin.sdk_kotlin.transformation
import io.pixelbin.sdk_kotlin.TransformationObj

class PrTag {
    /**
     * Method for AI Product Tagging
     *
     * @return TransformationObj.
     */
    @JvmOverloads
    fun tag(): TransformationObj {
        // Create the values HashMap
        val values = HashMap<String, String>()
        return TransformationObj(
            plugin = "pr",
            name = "tag",
            values = values,
        )
    }
}
