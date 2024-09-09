package com.pixelbin.transformation.type
import com.pixelbin.transformation.TransformationObj


class SrUpscale {
 
    
    
      /**
     * Type options: 2x, 4x, 8x
     */
      enum class Type {
        
        _2X
        {
            override fun toString(): String {
                return "2x"
            }
        },
        
        _4X
        {
            override fun toString(): String {
                return "4x"
            }
        },
        
        _8X
        {
            override fun toString(): String {
                return "8x"
            }
        },
        
    }
    
    
    
    
    
      /**
     * Model options: Picasso, Flash
     */
      enum class Model {
        
        PICASSO
        {
            override fun toString(): String {
                return "Picasso"
            }
        },
        
        FLASH
        {
            override fun toString(): String {
                return "Flash"
            }
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
        
        enhancequality: Boolean? = null
        
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
            values = values
        )
    }
}

