package io.pixelbin.sdk_kotlin.transformation
import io.pixelbin.sdk_kotlin.TransformationObj

class RemoveBg {
    /**
     * Method for Remove background from any image
     *
     * @return TransformationObj.
     */
    @JvmOverloads
    fun bg(): TransformationObj {
        // Create the values HashMap
        val values = HashMap<String, String>()
        return TransformationObj(
            plugin = "remove",
            name = "bg",
            values = values,
        )
    }
}
