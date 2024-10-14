package io.pixelbin.sdk_kotlin.transformation
import io.pixelbin.sdk_kotlin.TransformationObj

class ImMask {
    /**
     * Detector options: face, text, number_plate
     */
    enum class Detector {
        FACE {
            override fun toString(): String = "face"
        },
        TEXT {
            override fun toString(): String = "text"
        },
        NUMBER_PLATE {
            override fun toString(): String = "number_plate"
        },
    }

    /**
     * Mask type options: fill_black, pixelate, blur
     */
    enum class Masktype {
        FILL_BLACK {
            override fun toString(): String = "fill_black"
        },
        PIXELATE {
            override fun toString(): String = "pixelate"
        },
        BLUR {
            override fun toString(): String = "blur"
        },
    }

    /**
     * Method for Intelligent Masking
     *
     * @param Replacement Image file (Default: )
     * @param Detector Detector? (Default: number_plate)
     * @param Mask Type Mask type? (Default: fill_black)
     * @return TransformationObj.
     */
    @JvmOverloads
    fun mask(
        replacementimage: String? = null,
        detector: Detector? = null,
        masktype: Masktype? = null,
    ): TransformationObj {
        // Create the values HashMap
        val values = HashMap<String, String>()
        if (!replacementimage.isNullOrEmpty()) {
            values["i"] = replacementimage.toString()
        }
        values["d"] = detector.toString()
        values["m"] = masktype.toString()
        return TransformationObj(
            plugin = "im",
            name = "mask",
            values = values,
        )
    }
}
