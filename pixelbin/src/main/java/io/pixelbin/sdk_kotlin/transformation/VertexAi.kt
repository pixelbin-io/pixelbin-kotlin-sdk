package io.pixelbin.sdk_kotlin.transformation
import io.pixelbin.sdk_kotlin.TransformationObj

class VertexaiGeneratebg {
    /**
     * Method for Vertex AI based transformations
     *
     * @param Background prompt custom (Default: YSBmb3Jlc3QgZnVsbCBvZiBvYWsgdHJlZXMsd2l0aCBicmlnaHQgbGlnaHRzLCBzdW4gYW5kIGEgbG90IG9mIG1hZ2ljLCB1bHRyYSByZWFsaXN0aWMsIDhr)
     * @param Negative prompt custom (Default: )
     * @param seed Int (Default: 22)
     * @param Guidance Scale Int (Default: 60)
     * @return TransformationObj.
     */
    @JvmOverloads
    fun generateBG(
        backgroundprompt: String? = null,
        negativeprompt: String? = null,
        seed: Int? = null,
        guidancescale: Int? = null,
    ): TransformationObj {
        // Create the values HashMap
        val values = HashMap<String, String>()
        if (!backgroundprompt.isNullOrEmpty()) {
            values["p"] = backgroundprompt.toString()
        }
        if (!negativeprompt.isNullOrEmpty()) {
            values["np"] = negativeprompt.toString()
        }
        values["s"] = seed.toString()
        values["gs"] = guidancescale.toString()
        return TransformationObj(
            plugin = "vertexAi",
            name = "generateBG",
            values = values,
        )
    }
}

class VertexaiRemovebg {
    /**
     * Method for Vertex AI based transformations
     *
     * @return TransformationObj.
     */
    @JvmOverloads
    fun removeBG(): TransformationObj {
        // Create the values HashMap
        val values = HashMap<String, String>()
        return TransformationObj(
            plugin = "vertexAi",
            name = "removeBG",
            values = values,
        )
    }
}

class VertexaiUpscale {
    /**
     * Type options: x2, x4
     */
    enum class Type {
        X2 {
            override fun toString(): String = "x2"
        },
        X4 {
            override fun toString(): String = "x4"
        },
    }

    /**
     * Method for Vertex AI based transformations
     *
     * @param Type Type? (Default: x2)
     * @return TransformationObj.
     */
    @JvmOverloads
    fun upscale(type: Type? = null): TransformationObj {
        // Create the values HashMap
        val values = HashMap<String, String>()
        values["t"] = type.toString()
        return TransformationObj(
            plugin = "vertexAi",
            name = "upscale",
            values = values,
        )
    }
}
