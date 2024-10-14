package io.pixelbin.sdk_kotlin.transformation
import io.pixelbin.sdk_kotlin.TransformationObj

class SrUpscale {
    /**
     * Type options: 2x, 4x, 8x
     */
    enum class Type {
        _2X {
            override fun toString(): String = "2x"
        },
        _4X {
            override fun toString(): String = "4x"
        },
        _8X {
            override fun toString(): String = "8x"
        },
    }

    /**
     * Model options: Picasso, Flash
     */
    enum class Model {
        PICASSO {
            override fun toString(): String = "Picasso"
        },
        FLASH {
            override fun toString(): String = "Flash"
        },
    }

    /**
     * Method for Super Resolution Module
     *
     * @param Type Type? (Default: 2x)
     * @param Enhance Face Boolean (Default: false)
     * @param Model Model? (Default: Picasso)
     * @param Enhance Quality Boolean (Default: false)
     * @return TransformationObj.
     */
    @JvmOverloads
    fun upscale(
        type: Type? = null,
        enhanceface: Boolean? = null,
        model: Model? = null,
        enhancequality: Boolean? = null,
    ): TransformationObj {
        // Create the values HashMap
        val values = HashMap<String, String>()
        values["t"] = type.toString()
        values["enhance_face"] = enhanceface.toString()
        values["model"] = model.toString()
        values["enhance_quality"] = enhancequality.toString()
        return TransformationObj(
            plugin = "sr",
            name = "upscale",
            values = values,
        )
    }
}
