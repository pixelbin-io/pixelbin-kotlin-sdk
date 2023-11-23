package com.pixelbin.transformation.type
import com.pixelbin.transformation.TransformationObj


 class BackgroundGenerator {
 
    
    
    
    
    
    
      /**
     * Focus options: Product, Background
     */
      enum class Focus {
        
        PRODUCT
        {
            override fun toString(): String {
                return "Product"
            }
        },
        
        BACKGROUND
        {
            override fun toString(): String {
                return "Background"
            }
        },
        
    }
    
    
    
    
    
    

    /**
     * Method for AI Background Generator
     * 
     * @param Background prompt custom (Default: cmVhbGlzdGljIGdyZWVuIGdyYXNzLCBsYXduIGZpZWxkIG9mIGdyYXNzLCBibHVlIHNreSB3aXRoIHdoaXRlIGNsb3Vkcw)
     
     * @param Background image for shadow file (Default: )
     
     * @param focus Focus? (Default: Product)
     
     * @param Negative prompt custom (Default: )
     
     * @param seed Int (Default: 123)
     
     * @return TransformationObj.
     */
     @JvmOverloads
    fun bg(
       
        backgroundprompt: String? = null,
        
        backgroundimageforshadow: String? = null,
        
        focus: Focus? = null,
        
        negativeprompt: String? = null,
        
        seed: Int? = null
        
    ): TransformationObj {
        // Create the values HashMap
        val values = HashMap<String, String>()
        
        
        
        
        if(!backgroundprompt.isNullOrEmpty()){
            values["p"] = backgroundprompt.toString()
        }
        
        
        
        
        
        
        
        if(!backgroundimageforshadow.isNullOrEmpty()){
            values["i"] = backgroundimageforshadow.toString()
        }
        
        
        
        
        
        values["f"] = focus.toString()
        
        
        
        
        
        if(!negativeprompt.isNullOrEmpty()){
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

