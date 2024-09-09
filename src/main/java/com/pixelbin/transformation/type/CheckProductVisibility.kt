package com.pixelbin.transformation.type
import com.pixelbin.transformation.TransformationObj


class CpvDetect {
 
    

    /**
     * Method for Classifies whether the product in the image is completely visible or not
     * 
     * @return TransformationObj.
     */
     @JvmOverloads
    fun detect(
       
    ): TransformationObj {
        // Create the values HashMap
        val values = HashMap<String, String>()
        
        
        return TransformationObj(
            plugin = "cpv",
            name = "detect",
            values = values
        )
    }
}

