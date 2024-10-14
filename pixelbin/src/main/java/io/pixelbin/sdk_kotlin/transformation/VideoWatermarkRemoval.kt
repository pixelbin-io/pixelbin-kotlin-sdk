package io.pixelbin.sdk_kotlin.transformation
import io.pixelbin.sdk_kotlin.TransformationObj

class WmvRemove {
    /**
     * Method for Video Watermark Removal Plugin
     *
     * @return TransformationObj.
     */
    @JvmOverloads
    fun remove(): TransformationObj {
        // Create the values HashMap
        val values = HashMap<String, String>()
        return TransformationObj(
            plugin = "wmv",
            name = "remove",
            values = values,
        )
    }
}
