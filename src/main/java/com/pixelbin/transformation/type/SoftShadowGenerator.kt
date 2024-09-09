package com.pixelbin.transformation.type
import com.pixelbin.transformation.TransformationObj


class ShadowGen {
 
    
    
    
    
    
    
    
    
    

    /**
     * Method for AI Soft Shadow Generator
     * 
     * @param Background Image file
     
     * @param Background Color String (Default: "ffffff")
     
     * @param Shadow Angle Number (Default: 120)
     
     * @param Shadow Intensity Number (Default: 0.5)
     
     * @return TransformationObj.
     */
     @JvmOverloads
    fun gen(
       
        backgroundimage: String? = null,
        
        backgroundcolor: String? = null,
        
        shadowangle: Number? = null,
        
        shadowintensity: Number? = null
        
    ): TransformationObj {
        // Create the values HashMap
        val values = HashMap<String, String>()
        
        
        
        
        if(!backgroundimage.isNullOrEmpty()){
            values["bgi"] = backgroundimage.toString()
        }
        
        
        
        
        
        
        
        if(!backgroundcolor.isNullOrEmpty()){
            values["bgc"] = backgroundcolor.toString()
        }
        
        
        
        
        
        
        values["a"] = shadowangle.toString()
        
        
        
        
        
        values["i"] = shadowintensity.toString()
        
        
        
        
        return TransformationObj(
            plugin = "shadow",
            name = "gen",
            values = values
        )
    }
}

