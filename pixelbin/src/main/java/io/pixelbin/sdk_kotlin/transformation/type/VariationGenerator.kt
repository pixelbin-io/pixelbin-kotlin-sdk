package io.pixelbin.sdk_kotlin.transformation.type

import io.pixelbin.sdk_kotlin.transformation.TransformationObj


class VgGenerate {


    /**
     * Method for AI Variation Generator
     *
     * @param Generate variation prompt custom (Default: )

     * @param No of Variations Int (Default: 1)

     * @param Seed Int (Default: 0)

     * @param Autoscale Boolean (Default: true)

     * @return TransformationObj.
     */
    @JvmOverloads
    fun generate(

        generatevariationprompt: String? = null,

        noofvariations: Int? = null,

        seed: Int? = null,

        autoscale: Boolean? = null

    ): TransformationObj {
        // Create the values HashMap
        val values = HashMap<String, String>()




        if (!generatevariationprompt.isNullOrEmpty()) {
            values["p"] = generatevariationprompt.toString()
        }






        values["v"] = noofvariations.toString()





        values["s"] = seed.toString()





        values["auto"] = autoscale.toString()




        return TransformationObj(
            plugin = "vg",
            name = "generate",
            values = values
        )
    }
}

