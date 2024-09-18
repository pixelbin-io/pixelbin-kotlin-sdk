package io.pixelbin.sdk_kotlin.transformation.type

import io.pixelbin.sdk_kotlin.transformation.TransformationObj


class ImcDetect {


    /**
     * Method for Image Centering Module
     *
     * @param Distance percentage Int (Default: 10)

     * @return TransformationObj.
     */
    @JvmOverloads
    fun detect(

        distancepercentage: Int? = null

    ): TransformationObj {
        // Create the values HashMap
        val values = HashMap<String, String>()



        values["dist_perc"] = distancepercentage.toString()




        return TransformationObj(
            plugin = "imc",
            name = "detect",
            values = values
        )
    }
}

