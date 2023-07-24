package com.pixelbin.transformation.type
import com.pixelbin.transformation.TransformationObj


 class EraseBG {
 
    
    
    enum class Industrytype {
        
        GENERAL
        {
            override fun toString(): String {
                return "general"
            }
        },
        
        ECOMMERCE
        {
            override fun toString(): String {
                return "ecommerce"
            }
        },
        
        CAR
        {
            override fun toString(): String {
                return "car"
            }
        },
        
    }

    /**
     * Industry type options: general, ecommerce, car
     */
    
    
    
    

    /**
     * Method for EraseBG Background Removal Module
     * 
     * @param Industry Type Industry type? (Default: general)
     
     * @param Add Shadow Boolean (Default: false)
     
     * @return TransformationObj.
     */
     @JvmOverloads
    fun bg(
       
        industrytype: Industrytype? = null,
        
        addshadow: Boolean? = null
        
    ): TransformationObj {
        // Create the values HashMap
        val values = HashMap<String, String>()
        
        
        values["i"] = industrytype.toString()
        
        
        
        
        values["shadow"] = addshadow.toString()
        
        
        
        
        return TransformationObj(
            plugin = "erase",
            name = "bg",
            values = values
        )
    }
}

