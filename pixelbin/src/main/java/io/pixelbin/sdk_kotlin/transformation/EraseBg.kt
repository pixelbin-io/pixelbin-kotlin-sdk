package io.pixelbin.sdk_kotlin.transformation
import io.pixelbin.sdk_kotlin.TransformationObj

class EraseBg {
    /**
     * Foreground Type options: general, ecommerce, car, human, object
     */
    enum class Industrytype {
        GENERAL {
            override fun toString(): String = "general"
        },
        ECOMMERCE {
            override fun toString(): String = "ecommerce"
        },
        CAR {
            override fun toString(): String = "car"
        },
        HUMAN {
            override fun toString(): String = "human"
        },
        OBJECT {
            override fun toString(): String = "object"
        },
    }

    /**
     * Method for EraseBG Background Removal Module
     *
     * @param Industry Type Industry type? (Default: general)
     * @param Add Shadow Boolean (Default: false)
     * @param Refine Boolean (Default: true)
     * @return TransformationObj.
     */
    @JvmOverloads
    fun bg(
        industrytype: Industrytype? = null,
        addshadow: Boolean? = null,
        refine: Boolean? = null,
    ): TransformationObj {
        // Create the values HashMap
        val values = HashMap<String, String>()
        values["i"] = industrytype.toString()
        values["shadow"] = addshadow.toString()
        values["r"] = refine.toString()
        return TransformationObj(
            plugin = "erase",
            name = "bg",
            values = values,
        )
    }
}
