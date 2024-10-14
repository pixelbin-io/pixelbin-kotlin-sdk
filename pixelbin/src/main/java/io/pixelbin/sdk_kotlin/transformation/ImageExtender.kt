package io.pixelbin.sdk_kotlin.transformation
import io.pixelbin.sdk_kotlin.TransformationObj

class BgExtend {
    /**
     * Method for AI Image Extender
     *
     * @param Bounding Box bbox
     * @param Prompt custom (Default: )
     * @param Negative Prompt custom (Default: )
     * @param Strength Number (Default: 0.999)
     * @param Guidance Scale Int (Default: 8)
     * @param Number of inference steps Int (Default: 10)
     * @param Color Adjust Boolean (Default: false)
     * @param seed Int (Default: 123)
     * @return TransformationObj.
     */
    @JvmOverloads
    fun extend(
        boundingbox: String? = null,
        prompt: String? = null,
        negativeprompt: String? = null,
        strength: Number? = null,
        guidancescale: Int? = null,
        numberofinferencesteps: Int? = null,
        coloradjust: Boolean? = null,
        seed: Int? = null,
    ): TransformationObj {
        // Create the values HashMap
        val values = HashMap<String, String>()
        if (!boundingbox.isNullOrEmpty()) {
            values["bbox"] = boundingbox.toString()
        }
        if (!prompt.isNullOrEmpty()) {
            values["p"] = prompt.toString()
        }
        if (!negativeprompt.isNullOrEmpty()) {
            values["np"] = negativeprompt.toString()
        }
        values["s"] = strength.toString()
        values["gs"] = guidancescale.toString()
        values["nis"] = numberofinferencesteps.toString()
        values["ca"] = coloradjust.toString()
        values["sd"] = seed.toString()
        return TransformationObj(
            plugin = "bg",
            name = "extend",
            values = values,
        )
    }
}
