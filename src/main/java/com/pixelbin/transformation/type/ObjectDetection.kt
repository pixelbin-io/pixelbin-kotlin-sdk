package com.pixelbin.transformation.type
import com.pixelbin.transformation.TransformationObj


 class ObjectDetection {
 
    

    /**
     * Method for Detect bounding boxes of objects in the image
     * 
     * @return TransformationObj.
     */
     @JvmOverloads
    fun detect(
       
    ): TransformationObj {
        // Create the values HashMap
        val values = HashMap<String, String>()
        
        
        return TransformationObj(
            plugin = "od",
            name = "detect",
            values = values
        )
    }
}

