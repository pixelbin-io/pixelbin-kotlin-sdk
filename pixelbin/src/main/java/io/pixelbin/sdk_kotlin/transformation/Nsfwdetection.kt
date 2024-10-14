package io.pixelbin.sdk_kotlin.transformation
import io.pixelbin.sdk_kotlin.TransformationObj

class NsfwDetect {
    /**
     * Method for Detect NSFW content in images
     *
     * @param Minimum Confidence Number (Default: 0.5)
     * @return TransformationObj.
     */
    @JvmOverloads
    fun detect(minimumconfidence: Number? = null): TransformationObj {
        // Create the values HashMap
        val values = HashMap<String, String>()
        values["m"] = minimumconfidence.toString()
        return TransformationObj(
            plugin = "nsfw",
            name = "detect",
            values = values,
        )
    }
}
