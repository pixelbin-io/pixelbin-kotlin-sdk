package io.pixelbin.sdk_kotlin.transformation.type

import io.pixelbin.sdk_kotlin.transformation.TransformationObj


class PwrRemove {


    /**
     * Method for PDF Watermark Removal Plugin
     *
     * @return TransformationObj.
     */
    @JvmOverloads
    fun remove(

    ): TransformationObj {
        // Create the values HashMap
        val values = HashMap<String, String>()


        return TransformationObj(
            plugin = "pwr",
            name = "remove",
            values = values
        )
    }
}

