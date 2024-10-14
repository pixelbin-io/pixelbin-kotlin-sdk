package io.pixelbin.sdk_kotlin.transformation
import io.pixelbin.sdk_kotlin.TransformationObj

class VdDetect {
    /**
     * Method for Classifies wear type and view type of products in the image
     *
     * @return TransformationObj.
     */
    @JvmOverloads
    fun detect(): TransformationObj {
        // Create the values HashMap
        val values = HashMap<String, String>()
        return TransformationObj(
            plugin = "vd",
            name = "detect",
            values = values,
        )
    }
}
