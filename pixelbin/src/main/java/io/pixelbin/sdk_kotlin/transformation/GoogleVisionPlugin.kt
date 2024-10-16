package io.pixelbin.sdk_kotlin.transformation
import io.pixelbin.sdk_kotlin.TransformationObj

class GooglevisDetectlabels {
    /**
     * Method for Detect content and text in images
     *
     * @param Maximum Labels Int (Default: 5)
     * @return TransformationObj.
     */
    @JvmOverloads
    fun detectLabels(maximumlabels: Int? = null): TransformationObj {
        // Create the values HashMap
        val values = HashMap<String, String>()
        values["l"] = maximumlabels.toString()
        return TransformationObj(
            plugin = "googleVis",
            name = "detectLabels",
            values = values,
        )
    }
}
