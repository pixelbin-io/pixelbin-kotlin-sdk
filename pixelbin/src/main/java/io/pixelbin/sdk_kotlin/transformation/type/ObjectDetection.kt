package io.pixelbin.sdk_kotlin.transformation.type

import io.pixelbin.sdk_kotlin.transformation.TransformationObj


class OdDetect {


    /**
     * Method for Detect bounding boxes of objects in the image
     *
     * @return TransformationObj.
     */
    @JvmOverloads
    fun detect(

    ): TransformationObj {
        // Create the values HashMap
        val values = HashMap<String, String>()


        return TransformationObj(
            plugin = "od",
            name = "detect",
            values = values
        )
    }
}

