package io.pixelbin.sdk_kotlin.transformation
import io.pixelbin.sdk_kotlin.TransformationObj

class CosDetect {
    /**
     * Method for Calculates the percentage of the main object area relative to image dimensions.
     *
     * @param Object Threshold Percent Int (Default: 50)
     * @return TransformationObj.
     */
    @JvmOverloads
    fun detect(objectthresholdpercent: Int? = null): TransformationObj {
        // Create the values HashMap
        val values = HashMap<String, String>()
        values["obj_threshold_perc"] = objectthresholdpercent.toString()
        return TransformationObj(
            plugin = "cos",
            name = "detect",
            values = values,
        )
    }
}
