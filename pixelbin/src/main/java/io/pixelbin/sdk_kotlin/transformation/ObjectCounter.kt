package io.pixelbin.sdk_kotlin.transformation
import io.pixelbin.sdk_kotlin.TransformationObj

class OcDetect {
    /**
     * Method for Classifies whether objects in the image are single or multiple
     *
     * @return TransformationObj.
     */
    @JvmOverloads
    fun detect(): TransformationObj {
        // Create the values HashMap
        val values = HashMap<String, String>()
        return TransformationObj(
            plugin = "oc",
            name = "detect",
            values = values,
        )
    }
}
