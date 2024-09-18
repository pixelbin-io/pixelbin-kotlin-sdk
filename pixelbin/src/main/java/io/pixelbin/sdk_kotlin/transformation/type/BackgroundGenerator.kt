package io.pixelbin.sdk_kotlin.transformation.type

import io.pixelbin.sdk_kotlin.transformation.TransformationObj


class GenerateBg {


    /**
     * Focus options: Product, Background
     */
    enum class Focus {

        PRODUCT {
            override fun toString(): String {
                return "Product"
            }
        },

        BACKGROUND {
            override fun toString(): String {
                return "Background"
            }
        },

    }


    /**
     * Method for AI Background Generator
     *
     * @param Background prompt custom (Default: YSBmb3Jlc3QgZnVsbCBvZiBvYWsgdHJlZXMsd2l0aCBicmlnaHQgbGlnaHRzLCBzdW4gYW5kIGEgbG90IG9mIG1hZ2ljLCB1bHRyYSByZWFsaXN0aWMsIDhr)

     * @param focus Focus? (Default: Product)

     * @param Negative prompt custom (Default: )

     * @param seed Int (Default: 123)

     * @return TransformationObj.
     */
    @JvmOverloads
    fun bg(

        backgroundprompt: String? = null,

        focus: Focus? = null,

        negativeprompt: String? = null,

        seed: Int? = null

    ): TransformationObj {
        // Create the values HashMap
        val values = HashMap<String, String>()




        if (!backgroundprompt.isNullOrEmpty()) {
            values["p"] = backgroundprompt.toString()
        }





        values["f"] = focus.toString()





        if (!negativeprompt.isNullOrEmpty()) {
            values["np"] = negativeprompt.toString()
        }






        values["s"] = seed.toString()




        return TransformationObj(
            plugin = "generate",
            name = "bg",
            values = values
        )
    }
}

