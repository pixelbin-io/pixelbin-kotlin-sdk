package io.pixelbin.sdk_kotlin.transformation
import io.pixelbin.sdk_kotlin.TransformationObj

class NumplateDetect {
    /**
     * Method for Number Plate Detection Plugin
     *
     * @return TransformationObj.
     */
    @JvmOverloads
    fun detect(): TransformationObj {
        // Create the values HashMap
        val values = HashMap<String, String>()
        return TransformationObj(
            plugin = "numPlate",
            name = "detect",
            values = values,
        )
    }
}
