package io.pixelbin.sdk_kotlin.transformation.type

import io.pixelbin.sdk_kotlin.transformation.TransformationObj


class QrGenerate {


    /**
     * QR Error Correction Level options: L, M, Q, H
     */
    enum class Qrerrorcorrectionlevel {

        L {
            override fun toString(): String {
                return "L"
            }
        },

        M {
            override fun toString(): String {
                return "M"
            }
        },

        Q {
            override fun toString(): String {
                return "Q"
            }
        },

        H {
            override fun toString(): String {
                return "H"
            }
        },

    }


    /**
     * Dots Type options: rounded, dots, classy, classy-rounded, square, extra-rounded
     */
    enum class Dotstype {

        ROUNDED {
            override fun toString(): String {
                return "rounded"
            }
        },

        DOTS {
            override fun toString(): String {
                return "dots"
            }
        },

        CLASSY {
            override fun toString(): String {
                return "classy"
            }
        },

        CLASSY_ROUNDED {
            override fun toString(): String {
                return "classy-rounded"
            }
        },

        SQUARE {
            override fun toString(): String {
                return "square"
            }
        },

        EXTRA_ROUNDED {
            override fun toString(): String {
                return "extra-rounded"
            }
        },

    }


    /**
     * Corner Square Type options: dot, square, extra-rounded
     */
    enum class Cornersquaretype {

        DOT {
            override fun toString(): String {
                return "dot"
            }
        },

        SQUARE {
            override fun toString(): String {
                return "square"
            }
        },

        EXTRA_ROUNDED {
            override fun toString(): String {
                return "extra-rounded"
            }
        },

    }


    /**
     * Corner Dots Type options: dot, square
     */
    enum class Cornerdotstype {

        DOT {
            override fun toString(): String {
                return "dot"
            }
        },

        SQUARE {
            override fun toString(): String {
                return "square"
            }
        },

    }


    /**
     * Method for QRCode Plugin
     *
     * @param width Int (Default: 300)

     * @param height Int (Default: 300)

     * @param image custom (Default: )

     * @param margin Int (Default: 0)

     * @param qRTypeNumber Int (Default: 0)

     * @param qrErrorCorrectionLevel Qrerrorcorrectionlevel? (Default: Q)

     * @param imageSize Number (Default: 0.4)

     * @param imageMargin Int (Default: 0)

     * @param dotsColor String (Default: "000000")

     * @param dotsType Dotstype? (Default: square)

     * @param dotsBgColor String (Default: "ffffff")

     * @param cornerSquareColor String (Default: "000000")

     * @param cornerSquareType Cornersquaretype? (Default: square)

     * @param cornerDotsColor String (Default: "000000")

     * @param cornerDotsType Cornerdotstype? (Default: dot)

     * @return TransformationObj.
     */
    @JvmOverloads
    fun generate(

        width: Int? = null,

        height: Int? = null,

        image: String? = null,

        margin: Int? = null,

        qrtypenumber: Int? = null,

        qrerrorcorrectionlevel: Qrerrorcorrectionlevel? = null,

        imagesize: Number? = null,

        imagemargin: Int? = null,

        dotscolor: String? = null,

        dotstype: Dotstype? = null,

        dotsbgcolor: String? = null,

        cornersquarecolor: String? = null,

        cornersquaretype: Cornersquaretype? = null,

        cornerdotscolor: String? = null,

        cornerdotstype: Cornerdotstype? = null

    ): TransformationObj {
        // Create the values HashMap
        val values = HashMap<String, String>()



        values["w"] = width.toString()





        values["h"] = height.toString()






        if (!image.isNullOrEmpty()) {
            values["i"] = image.toString()
        }






        values["m"] = margin.toString()





        values["qt"] = qrtypenumber.toString()




        values["qe"] = qrerrorcorrectionlevel.toString()




        values["is"] = imagesize.toString()





        values["im"] = imagemargin.toString()






        if (!dotscolor.isNullOrEmpty()) {
            values["ds"] = dotscolor.toString()
        }





        values["dt"] = dotstype.toString()





        if (!dotsbgcolor.isNullOrEmpty()) {
            values["bg"] = dotsbgcolor.toString()
        }







        if (!cornersquarecolor.isNullOrEmpty()) {
            values["csc"] = cornersquarecolor.toString()
        }





        values["cst"] = cornersquaretype.toString()





        if (!cornerdotscolor.isNullOrEmpty()) {
            values["cdc"] = cornerdotscolor.toString()
        }





        values["cdt"] = cornerdotstype.toString()



        return TransformationObj(
            plugin = "qr",
            name = "generate",
            values = values
        )
    }
}


class QrScan {


    /**
     * Method for QRCode Plugin
     *
     * @return TransformationObj.
     */
    @JvmOverloads
    fun scan(

    ): TransformationObj {
        // Create the values HashMap
        val values = HashMap<String, String>()


        return TransformationObj(
            plugin = "qr",
            name = "scan",
            values = values
        )
    }
}

