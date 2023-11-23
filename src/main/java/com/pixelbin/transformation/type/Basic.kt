package com.pixelbin.transformation.type
import com.pixelbin.transformation.TransformationObj


class Resize {
 
    
    
    
    
    
    
      /**
     * Fit options: cover, contain, fill, inside, outside
     */
      enum class Fit {
        
        COVER
        {
            override fun toString(): String {
                return "cover"
            }
        },
        
        CONTAIN
        {
            override fun toString(): String {
                return "contain"
            }
        },
        
        FILL
        {
            override fun toString(): String {
                return "fill"
            }
        },
        
        INSIDE
        {
            override fun toString(): String {
                return "inside"
            }
        },
        
        OUTSIDE
        {
            override fun toString(): String {
                return "outside"
            }
        },
        
    }
    
    
    
    
    
      /**
     * Position options: top, bottom, left, right, right_top, right_bottom, left_top, left_bottom, center
     */
      enum class Position {
        
        TOP
        {
            override fun toString(): String {
                return "top"
            }
        },
        
        BOTTOM
        {
            override fun toString(): String {
                return "bottom"
            }
        },
        
        LEFT
        {
            override fun toString(): String {
                return "left"
            }
        },
        
        RIGHT
        {
            override fun toString(): String {
                return "right"
            }
        },
        
        RIGHT_TOP
        {
            override fun toString(): String {
                return "right_top"
            }
        },
        
        RIGHT_BOTTOM
        {
            override fun toString(): String {
                return "right_bottom"
            }
        },
        
        LEFT_TOP
        {
            override fun toString(): String {
                return "left_top"
            }
        },
        
        LEFT_BOTTOM
        {
            override fun toString(): String {
                return "left_bottom"
            }
        },
        
        CENTER
        {
            override fun toString(): String {
                return "center"
            }
        },
        
    }
    
    
    
      /**
     * Algorithm options: nearest, cubic, mitchell, lanczos2, lanczos3
     */
      enum class Algorithm {
        
        NEAREST
        {
            override fun toString(): String {
                return "nearest"
            }
        },
        
        CUBIC
        {
            override fun toString(): String {
                return "cubic"
            }
        },
        
        MITCHELL
        {
            override fun toString(): String {
                return "mitchell"
            }
        },
        
        LANCZOS2
        {
            override fun toString(): String {
                return "lanczos2"
            }
        },
        
        LANCZOS3
        {
            override fun toString(): String {
                return "lanczos3"
            }
        },
        
    }
    
    
    
    

    /**
     * Method for Basic Transformations
     * 
     * @param height Int (Default: 0)
     
     * @param width Int (Default: 0)
     
     * @param fit Fit? (Default: cover)
     
     * @param background String (Default: "000000")
     
     * @param position Position? (Default: center)
     
     * @param algorithm Algorithm? (Default: lanczos3)
     
     * @param DPR Number (Default: 1)
     
     * @return TransformationObj.
     */
     @JvmOverloads
    fun resize(
       
        height: Int? = null,
        
        width: Int? = null,
        
        fit: Fit? = null,
        
        background: String? = null,
        
        position: Position? = null,
        
        algorithm: Algorithm? = null,
        
        dpr: Number? = null
        
    ): TransformationObj {
        // Create the values HashMap
        val values = HashMap<String, String>()
        
        
        
        values["h"] = height.toString()
        
        
        
        
        
        values["w"] = width.toString()
        
        
        
        
        values["f"] = fit.toString()
        
        
        
        
        
        if(!background.isNullOrEmpty()){
            values["b"] = background.toString()
        }
        
        
        
        
        
        values["p"] = position.toString()
        
        
        
        values["k"] = algorithm.toString()
        
        
        
        
        values["dpr"] = dpr.toString()
        
        
        
        
        return TransformationObj(
            plugin = "t",
            name = "resize",
            values = values
        )
    }
}


class Compress {
 
    
    
    

    /**
     * Method for Basic Transformations
     * 
     * @param quality Int (Default: 80)
     
     * @return TransformationObj.
     */
     @JvmOverloads
    fun compress(
       
        quality: Int? = null
        
    ): TransformationObj {
        // Create the values HashMap
        val values = HashMap<String, String>()
        
        
        
        values["q"] = quality.toString()
        
        
        
        
        return TransformationObj(
            plugin = "t",
            name = "compress",
            values = values
        )
    }
}


class Extend {
 
    
    
    
    
    
    
    
    
    
    
    
    
      /**
     * Border type options: constant, replicate, reflect, wrap
     */
      enum class Bordertype {
        
        CONSTANT
        {
            override fun toString(): String {
                return "constant"
            }
        },
        
        REPLICATE
        {
            override fun toString(): String {
                return "replicate"
            }
        },
        
        REFLECT
        {
            override fun toString(): String {
                return "reflect"
            }
        },
        
        WRAP
        {
            override fun toString(): String {
                return "wrap"
            }
        },
        
    }
    
    
    
    

    /**
     * Method for Basic Transformations
     * 
     * @param top Int (Default: 10)
     
     * @param left Int (Default: 10)
     
     * @param bottom Int (Default: 10)
     
     * @param right Int (Default: 10)
     
     * @param background String (Default: "000000")
     
     * @param Border Type Border type? (Default: constant)
     
     * @param DPR Number (Default: 1)
     
     * @return TransformationObj.
     */
     @JvmOverloads
    fun extend(
       
        top: Int? = null,
        
        left: Int? = null,
        
        bottom: Int? = null,
        
        right: Int? = null,
        
        background: String? = null,
        
        bordertype: Bordertype? = null,
        
        dpr: Number? = null
        
    ): TransformationObj {
        // Create the values HashMap
        val values = HashMap<String, String>()
        
        
        
        values["t"] = top.toString()
        
        
        
        
        
        values["l"] = left.toString()
        
        
        
        
        
        values["b"] = bottom.toString()
        
        
        
        
        
        values["r"] = right.toString()
        
        
        
        
        
        
        if(!background.isNullOrEmpty()){
            values["bc"] = background.toString()
        }
        
        
        
        
        
        values["bt"] = bordertype.toString()
        
        
        
        
        values["dpr"] = dpr.toString()
        
        
        
        
        return TransformationObj(
            plugin = "t",
            name = "extend",
            values = values
        )
    }
}


class Extract {
 
    
    
    
    
    
    
    
    
    

    /**
     * Method for Basic Transformations
     * 
     * @param top Int (Default: 10)
     
     * @param left Int (Default: 10)
     
     * @param height Int (Default: 50)
     
     * @param width Int (Default: 20)
     
     * @return TransformationObj.
     */
     @JvmOverloads
    fun extract(
       
        top: Int? = null,
        
        left: Int? = null,
        
        height: Int? = null,
        
        width: Int? = null
        
    ): TransformationObj {
        // Create the values HashMap
        val values = HashMap<String, String>()
        
        
        
        values["t"] = top.toString()
        
        
        
        
        
        values["l"] = left.toString()
        
        
        
        
        
        values["h"] = height.toString()
        
        
        
        
        
        values["w"] = width.toString()
        
        
        
        
        return TransformationObj(
            plugin = "t",
            name = "extract",
            values = values
        )
    }
}


class Trim {
 
    
    
    

    /**
     * Method for Basic Transformations
     * 
     * @param threshold Int (Default: 10)
     
     * @return TransformationObj.
     */
     @JvmOverloads
    fun trim(
       
        threshold: Int? = null
        
    ): TransformationObj {
        // Create the values HashMap
        val values = HashMap<String, String>()
        
        
        
        values["t"] = threshold.toString()
        
        
        
        
        return TransformationObj(
            plugin = "t",
            name = "trim",
            values = values
        )
    }
}


class Rotate {
 
    
    
    
    
    

    /**
     * Method for Basic Transformations
     * 
     * @param angle Int (Default: 0)
     
     * @param background String (Default: "000000")
     
     * @return TransformationObj.
     */
     @JvmOverloads
    fun rotate(
       
        angle: Int? = null,
        
        background: String? = null
        
    ): TransformationObj {
        // Create the values HashMap
        val values = HashMap<String, String>()
        
        
        
        values["a"] = angle.toString()
        
        
        
        
        
        
        if(!background.isNullOrEmpty()){
            values["b"] = background.toString()
        }
        
        
        
        
        
        return TransformationObj(
            plugin = "t",
            name = "rotate",
            values = values
        )
    }
}


class Flip {
 
    

    /**
     * Method for Basic Transformations
     * 
     * @return TransformationObj.
     */
     @JvmOverloads
    fun flip(
       
    ): TransformationObj {
        // Create the values HashMap
        val values = HashMap<String, String>()
        
        
        return TransformationObj(
            plugin = "t",
            name = "flip",
            values = values
        )
    }
}


class Flop {
 
    

    /**
     * Method for Basic Transformations
     * 
     * @return TransformationObj.
     */
     @JvmOverloads
    fun flop(
       
    ): TransformationObj {
        // Create the values HashMap
        val values = HashMap<String, String>()
        
        
        return TransformationObj(
            plugin = "t",
            name = "flop",
            values = values
        )
    }
}


class Sharpen {
 
    
    
    

    /**
     * Method for Basic Transformations
     * 
     * @param sigma Number (Default: 1.5)
     
     * @return TransformationObj.
     */
     @JvmOverloads
    fun sharpen(
       
        sigma: Number? = null
        
    ): TransformationObj {
        // Create the values HashMap
        val values = HashMap<String, String>()
        
        
        
        values["s"] = sigma.toString()
        
        
        
        
        return TransformationObj(
            plugin = "t",
            name = "sharpen",
            values = values
        )
    }
}


class Median {
 
    
    
    

    /**
     * Method for Basic Transformations
     * 
     * @param size Int (Default: 3)
     
     * @return TransformationObj.
     */
     @JvmOverloads
    fun median(
       
        size: Int? = null
        
    ): TransformationObj {
        // Create the values HashMap
        val values = HashMap<String, String>()
        
        
        
        values["s"] = size.toString()
        
        
        
        
        return TransformationObj(
            plugin = "t",
            name = "median",
            values = values
        )
    }
}


class Blur {
 
    
    
    
    
    

    /**
     * Method for Basic Transformations
     * 
     * @param sigma Number (Default: 0.3)
     
     * @param DPR Number (Default: 1)
     
     * @return TransformationObj.
     */
     @JvmOverloads
    fun blur(
       
        sigma: Number? = null,
        
        dpr: Number? = null
        
    ): TransformationObj {
        // Create the values HashMap
        val values = HashMap<String, String>()
        
        
        
        values["s"] = sigma.toString()
        
        
        
        
        
        values["dpr"] = dpr.toString()
        
        
        
        
        return TransformationObj(
            plugin = "t",
            name = "blur",
            values = values
        )
    }
}


class Flatten {
 
    
    
    

    /**
     * Method for Basic Transformations
     * 
     * @param background String (Default: "000000")
     
     * @return TransformationObj.
     */
     @JvmOverloads
    fun flatten(
       
        background: String? = null
        
    ): TransformationObj {
        // Create the values HashMap
        val values = HashMap<String, String>()
        
        
        
        
        if(!background.isNullOrEmpty()){
            values["b"] = background.toString()
        }
        
        
        
        
        
        return TransformationObj(
            plugin = "t",
            name = "flatten",
            values = values
        )
    }
}


class Negate {
 
    

    /**
     * Method for Basic Transformations
     * 
     * @return TransformationObj.
     */
     @JvmOverloads
    fun negate(
       
    ): TransformationObj {
        // Create the values HashMap
        val values = HashMap<String, String>()
        
        
        return TransformationObj(
            plugin = "t",
            name = "negate",
            values = values
        )
    }
}


class Normalise {
 
    

    /**
     * Method for Basic Transformations
     * 
     * @return TransformationObj.
     */
     @JvmOverloads
    fun normalise(
       
    ): TransformationObj {
        // Create the values HashMap
        val values = HashMap<String, String>()
        
        
        return TransformationObj(
            plugin = "t",
            name = "normalise",
            values = values
        )
    }
}


class Linear {
 
    
    
    
    
    

    /**
     * Method for Basic Transformations
     * 
     * @param a Int (Default: 1)
     
     * @param b Int (Default: 0)
     
     * @return TransformationObj.
     */
     @JvmOverloads
    fun linear(
       
        a: Int? = null,
        
        b: Int? = null
        
    ): TransformationObj {
        // Create the values HashMap
        val values = HashMap<String, String>()
        
        
        
        values["a"] = a.toString()
        
        
        
        
        
        values["b"] = b.toString()
        
        
        
        
        return TransformationObj(
            plugin = "t",
            name = "linear",
            values = values
        )
    }
}


class Modulate {
 
    
    
    
    
    
    
    

    /**
     * Method for Basic Transformations
     * 
     * @param brightness Number (Default: 1)
     
     * @param saturation Number (Default: 1)
     
     * @param hue Int (Default: 90)
     
     * @return TransformationObj.
     */
     @JvmOverloads
    fun modulate(
       
        brightness: Number? = null,
        
        saturation: Number? = null,
        
        hue: Int? = null
        
    ): TransformationObj {
        // Create the values HashMap
        val values = HashMap<String, String>()
        
        
        
        values["b"] = brightness.toString()
        
        
        
        
        
        values["s"] = saturation.toString()
        
        
        
        
        
        values["h"] = hue.toString()
        
        
        
        
        return TransformationObj(
            plugin = "t",
            name = "modulate",
            values = values
        )
    }
}


class Grey {
 
    

    /**
     * Method for Basic Transformations
     * 
     * @return TransformationObj.
     */
     @JvmOverloads
    fun grey(
       
    ): TransformationObj {
        // Create the values HashMap
        val values = HashMap<String, String>()
        
        
        return TransformationObj(
            plugin = "t",
            name = "grey",
            values = values
        )
    }
}


class Tint {
 
    
    
    

    /**
     * Method for Basic Transformations
     * 
     * @param color String (Default: "000000")
     
     * @return TransformationObj.
     */
     @JvmOverloads
    fun tint(
       
        color: String? = null
        
    ): TransformationObj {
        // Create the values HashMap
        val values = HashMap<String, String>()
        
        
        
        
        if(!color.isNullOrEmpty()){
            values["c"] = color.toString()
        }
        
        
        
        
        
        return TransformationObj(
            plugin = "t",
            name = "tint",
            values = values
        )
    }
}


class Toformat {
 
    
    
      /**
     * Format options: jpeg, png, webp, tiff, avif, bmp
     */
      enum class Format {
        
        JPEG
        {
            override fun toString(): String {
                return "jpeg"
            }
        },
        
        PNG
        {
            override fun toString(): String {
                return "png"
            }
        },
        
        WEBP
        {
            override fun toString(): String {
                return "webp"
            }
        },
        
        TIFF
        {
            override fun toString(): String {
                return "tiff"
            }
        },
        
        AVIF
        {
            override fun toString(): String {
                return "avif"
            }
        },
        
        BMP
        {
            override fun toString(): String {
                return "bmp"
            }
        },
        
    }
    
    

    /**
     * Method for Basic Transformations
     * 
     * @param format Format? (Default: jpeg)
     
     * @return TransformationObj.
     */
     @JvmOverloads
    fun toFormat(
       
        format: Format? = null
        
    ): TransformationObj {
        // Create the values HashMap
        val values = HashMap<String, String>()
        
        
        values["f"] = format.toString()
        
        
        
        return TransformationObj(
            plugin = "t",
            name = "toFormat",
            values = values
        )
    }
}


class Density {
 
    
    
    

    /**
     * Method for Basic Transformations
     * 
     * @param density Int (Default: 300)
     
     * @return TransformationObj.
     */
     @JvmOverloads
    fun density(
       
        density: Int? = null
        
    ): TransformationObj {
        // Create the values HashMap
        val values = HashMap<String, String>()
        
        
        
        values["d"] = density.toString()
        
        
        
        
        return TransformationObj(
            plugin = "t",
            name = "density",
            values = values
        )
    }
}


class Merge {
 
    
    
      /**
     * Mode options: overlay, underlay, wrap
     */
      enum class Mode {
        
        OVERLAY
        {
            override fun toString(): String {
                return "overlay"
            }
        },
        
        UNDERLAY
        {
            override fun toString(): String {
                return "underlay"
            }
        },
        
        WRAP
        {
            override fun toString(): String {
                return "wrap"
            }
        },
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
      /**
     * Gravity options: northwest, north, northeast, east, center, west, southwest, south, southeast, custom
     */
      enum class Gravity {
        
        NORTHWEST
        {
            override fun toString(): String {
                return "northwest"
            }
        },
        
        NORTH
        {
            override fun toString(): String {
                return "north"
            }
        },
        
        NORTHEAST
        {
            override fun toString(): String {
                return "northeast"
            }
        },
        
        EAST
        {
            override fun toString(): String {
                return "east"
            }
        },
        
        CENTER
        {
            override fun toString(): String {
                return "center"
            }
        },
        
        WEST
        {
            override fun toString(): String {
                return "west"
            }
        },
        
        SOUTHWEST
        {
            override fun toString(): String {
                return "southwest"
            }
        },
        
        SOUTH
        {
            override fun toString(): String {
                return "south"
            }
        },
        
        SOUTHEAST
        {
            override fun toString(): String {
                return "southeast"
            }
        },
        
        CUSTOM
        {
            override fun toString(): String {
                return "custom"
            }
        },
        
    }
    
    
    
      /**
     * Blend options: over, in, out, atop, dest, dest-over, dest-in, dest-out, dest-atop, xor, add, saturate, multiply, screen, overlay, darken, lighten, colour-dodge, color-dodge, colour-burn, color-burn, hard-light, soft-light, difference, exclusion
     */
      enum class Blend {
        
        OVER
        {
            override fun toString(): String {
                return "over"
            }
        },
        
        IN
        {
            override fun toString(): String {
                return "in"
            }
        },
        
        OUT
        {
            override fun toString(): String {
                return "out"
            }
        },
        
        ATOP
        {
            override fun toString(): String {
                return "atop"
            }
        },
        
        DEST
        {
            override fun toString(): String {
                return "dest"
            }
        },
        
        DEST_OVER
        {
            override fun toString(): String {
                return "dest-over"
            }
        },
        
        DEST_IN
        {
            override fun toString(): String {
                return "dest-in"
            }
        },
        
        DEST_OUT
        {
            override fun toString(): String {
                return "dest-out"
            }
        },
        
        DEST_ATOP
        {
            override fun toString(): String {
                return "dest-atop"
            }
        },
        
        XOR
        {
            override fun toString(): String {
                return "xor"
            }
        },
        
        ADD
        {
            override fun toString(): String {
                return "add"
            }
        },
        
        SATURATE
        {
            override fun toString(): String {
                return "saturate"
            }
        },
        
        MULTIPLY
        {
            override fun toString(): String {
                return "multiply"
            }
        },
        
        SCREEN
        {
            override fun toString(): String {
                return "screen"
            }
        },
        
        OVERLAY
        {
            override fun toString(): String {
                return "overlay"
            }
        },
        
        DARKEN
        {
            override fun toString(): String {
                return "darken"
            }
        },
        
        LIGHTEN
        {
            override fun toString(): String {
                return "lighten"
            }
        },
        
        COLOUR_DODGE
        {
            override fun toString(): String {
                return "colour-dodge"
            }
        },
        
        COLOR_DODGE
        {
            override fun toString(): String {
                return "color-dodge"
            }
        },
        
        COLOUR_BURN
        {
            override fun toString(): String {
                return "colour-burn"
            }
        },
        
        COLOR_BURN
        {
            override fun toString(): String {
                return "color-burn"
            }
        },
        
        HARD_LIGHT
        {
            override fun toString(): String {
                return "hard-light"
            }
        },
        
        SOFT_LIGHT
        {
            override fun toString(): String {
                return "soft-light"
            }
        },
        
        DIFFERENCE
        {
            override fun toString(): String {
                return "difference"
            }
        },
        
        EXCLUSION
        {
            override fun toString(): String {
                return "exclusion"
            }
        },
        
    }
    
    
    
    
    
    
    
    

    /**
     * Method for Basic Transformations
     * 
     * @param mode Mode? (Default: overlay)
     
     * @param image file (Default: )
     
     * @param transformation custom (Default: )
     
     * @param background String (Default: "00000000")
     
     * @param height Int (Default: 0)
     
     * @param width Int (Default: 0)
     
     * @param top Int (Default: 0)
     
     * @param left Int (Default: 0)
     
     * @param gravity Gravity? (Default: center)
     
     * @param blend Blend? (Default: over)
     
     * @param tile Boolean (Default: false)
     
     * @param List of bboxes bboxList
     
     * @param List of Polygons polygonList
     
     * @return TransformationObj.
     */
     @JvmOverloads
    fun merge(
       
        mode: Mode? = null,
        
        image: String? = null,
        
        transformation: String? = null,
        
        background: String? = null,
        
        height: Int? = null,
        
        width: Int? = null,
        
        top: Int? = null,
        
        left: Int? = null,
        
        gravity: Gravity? = null,
        
        blend: Blend? = null,
        
        tile: Boolean? = null,
        
        listofbboxes: String? = null,
        
        listofpolygons: String? = null
        
    ): TransformationObj {
        // Create the values HashMap
        val values = HashMap<String, String>()
        
        
        values["m"] = mode.toString()
        
        
        
        
        
        if(!image.isNullOrEmpty()){
            values["i"] = image.toString()
        }
        
        
        
        
        
        
        
        if(!transformation.isNullOrEmpty()){
            values["tr"] = transformation.toString()
        }
        
        
        
        
        
        
        
        if(!background.isNullOrEmpty()){
            values["bg"] = background.toString()
        }
        
        
        
        
        
        
        values["h"] = height.toString()
        
        
        
        
        
        values["w"] = width.toString()
        
        
        
        
        
        values["t"] = top.toString()
        
        
        
        
        
        values["l"] = left.toString()
        
        
        
        
        values["g"] = gravity.toString()
        
        
        
        values["b"] = blend.toString()
        
        
        
        
        values["r"] = tile.toString()
        
        
        
        
        
        
        if(!listofbboxes.isNullOrEmpty()){
            values["bboxes"] = listofbboxes.toString()
        }
        
        
        
        
        
        
        
        if(!listofpolygons.isNullOrEmpty()){
            values["polys"] = listofpolygons.toString()
        }
        
        
        
        
        
        return TransformationObj(
            plugin = "t",
            name = "merge",
            values = values
        )
    }
}

