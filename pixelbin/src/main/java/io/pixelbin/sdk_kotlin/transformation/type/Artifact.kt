package io.pixelbin.sdk_kotlin.transformation.type

import io.pixelbin.sdk_kotlin.transformation.TransformationObj


class AfRemove {


    /**
     * Method for Artifact Removal Plugin
     *
     * @return TransformationObj.
     */
    @JvmOverloads
    fun remove(

    ): TransformationObj {
        // Create the values HashMap
        val values = HashMap<String, String>()


        return TransformationObj(
            plugin = "af",
            name = "remove",
            values = values
        )
    }
}

