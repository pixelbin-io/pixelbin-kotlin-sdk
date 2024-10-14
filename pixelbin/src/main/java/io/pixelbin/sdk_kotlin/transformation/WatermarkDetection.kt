package io.pixelbin.sdk_kotlin.transformation
import io.pixelbin.sdk_kotlin.TransformationObj

class WmcDetect {
    /**
     * Method for Watermark Detection Plugin
     *
     * @param Detect Text Boolean (Default: false)
     * @return TransformationObj.
     */
    @JvmOverloads
    fun detect(detecttext: Boolean? = null): TransformationObj {
        // Create the values HashMap
        val values = HashMap<String, String>()
        values["detect_text"] = detecttext.toString()
        return TransformationObj(
            plugin = "wmc",
            name = "detect",
            values = values,
        )
    }
}
