package com.pixelbin.transformation.type
import com.pixelbin.transformation.TransformationObj


 class WatermarkDetection {
 
    
    
    

    /**
     * Method for Watermark Detection Plugin
     * 
     * @param Detect Text Boolean (Default: false)
     
     * @return TransformationObj.
     */
     @JvmOverloads
    fun detect(
       
        detecttext: Boolean? = null
        
    ): TransformationObj {
        // Create the values HashMap
        val values = HashMap<String, String>()
        
        
        
        values["detect_text"] = detecttext.toString()
        
        
        
        
        return TransformationObj(
            plugin = "wmc",
            name = "detect",
            values = values
        )
    }
}

