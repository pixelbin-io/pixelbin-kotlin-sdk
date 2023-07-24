package com.pixelbin.transformation.type
import com.pixelbin.transformation.TransformationObj


 class DetectBackgroundType {
 
    

    /**
     * Method for Classifies the background of a product as plain, clean or busy
     * 
     * @return TransformationObj.
     */
     @JvmOverloads
    fun detect(
       
    ): TransformationObj {
        // Create the values HashMap
        val values = HashMap<String, String>()
        
        
        return TransformationObj(
            plugin = "dbt",
            name = "detect",
            values = values
        )
    }
}

