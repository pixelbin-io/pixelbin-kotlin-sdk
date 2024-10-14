package io.pixelbin.sdk_kotlin.transformation
import io.pixelbin.sdk_kotlin.TransformationObj

class VsrUpscale {
    /**
     * Method for Video Upscaler Plugin
     *
     * @return TransformationObj.
     */
    @JvmOverloads
    fun upscale(): TransformationObj {
        // Create the values HashMap
        val values = HashMap<String, String>()
        return TransformationObj(
            plugin = "vsr",
            name = "upscale",
            values = values,
        )
    }
}
