package io.pixelbin.sdk_kotlin.transformation
import io.pixelbin.sdk_kotlin.TransformationObj

class PwrRemove {
    /**
     * Method for PDF Watermark Removal Plugin
     *
     * @return TransformationObj.
     */
    @JvmOverloads
    fun remove(): TransformationObj {
        // Create the values HashMap
        val values = HashMap<String, String>()
        return TransformationObj(
            plugin = "pwr",
            name = "remove",
            values = values,
        )
    }
}
