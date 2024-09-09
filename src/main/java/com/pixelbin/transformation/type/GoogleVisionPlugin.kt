package com.pixelbin.transformation.type
import com.pixelbin.transformation.TransformationObj


class GooglevisDetectlabels {
 
    
    
    

    /**
     * Method for Detect content and text in images
     * 
     * @param Maximum Labels Int (Default: 5)
     
     * @return TransformationObj.
     */
     @JvmOverloads
    fun detectLabels(
       
        maximumlabels: Int? = null
        
    ): TransformationObj {
        // Create the values HashMap
        val values = HashMap<String, String>()
        
        
        
        values["l"] = maximumlabels.toString()
        
        
        
        
        return TransformationObj(
            plugin = "googleVis",
            name = "detectLabels",
            values = values
        )
    }
}

