package io.pixelbin.sdk_kotlin.transformation.type

import io.pixelbin.sdk_kotlin.transformation.TransformationObj


class OcDetect {


    /**
     * Method for Classifies whether objects in the image are single or multiple
     *
     * @return TransformationObj.
     */
    @JvmOverloads
    fun detect(

    ): TransformationObj {
        // Create the values HashMap
        val values = HashMap<String, String>()


        return TransformationObj(
            plugin = "oc",
            name = "detect",
            values = values
        )
    }
}

