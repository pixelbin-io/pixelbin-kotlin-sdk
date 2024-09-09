package com.pixelbin.transformation.type
import com.pixelbin.transformation.TransformationObj


class WmvRemove {
 
    

    /**
     * Method for Video Watermark Removal Plugin
     * 
     * @return TransformationObj.
     */
     @JvmOverloads
    fun remove(
       
    ): TransformationObj {
        // Create the values HashMap
        val values = HashMap<String, String>()
        
        
        return TransformationObj(
            plugin = "wmv",
            name = "remove",
            values = values
        )
    }
}

