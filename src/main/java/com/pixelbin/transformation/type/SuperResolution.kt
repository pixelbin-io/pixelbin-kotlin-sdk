package com.pixelbin.transformation.type
import com.pixelbin.transformation.TransformationObj


 class SuperResolution {
 
    
    
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
        
    }

    /**
     * Type options: 2x, 4x
     */
    
    
    
    

    /**
     * Method for Super Resolution Module
     * 
     * @param type Type? (Default: 2x)
     
     * @param Enhance Face Boolean (Default: false)
     
     * @return TransformationObj.
     */
     @JvmOverloads
    fun upscale(
       
        type: Type? = null,
        
        enhanceface: Boolean? = null
        
    ): TransformationObj {
        // Create the values HashMap
        val values = HashMap<String, String>()
        
        
        values["t"] = type.toString()
        
        
        
        
        values["enhance_face"] = enhanceface.toString()
        
        
        
        
        return TransformationObj(
            plugin = "sr",
            name = "upscale",
            values = values
        )
    }
}

