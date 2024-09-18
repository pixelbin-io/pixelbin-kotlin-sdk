package io.pixelbin.sdk_kotlin.transformation.type

import io.pixelbin.sdk_kotlin.transformation.TransformationObj


class PrTag {


    /**
     * Method for AI Product Tagging
     *
     * @return TransformationObj.
     */
    @JvmOverloads
    fun tag(

    ): TransformationObj {
        // Create the values HashMap
        val values = HashMap<String, String>()


        return TransformationObj(
            plugin = "pr",
            name = "tag",
            values = values
        )
    }
}

