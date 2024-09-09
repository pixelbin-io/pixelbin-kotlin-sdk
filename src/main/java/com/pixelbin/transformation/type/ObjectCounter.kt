package com.pixelbin.transformation.type
import com.pixelbin.transformation.TransformationObj


class OcDetect {
 
    

    /**
     * Method for Classifies whether objects in the image are single or multiple
     * 
     * @return TransformationObj.
     */
     @JvmOverloads
    fun detect(
       
    ): TransformationObj {
        // Create the values HashMap
        val values = HashMap<String, String>()
        
        
        return TransformationObj(
            plugin = "oc",
            name = "detect",
            values = values
        )
    }
}

