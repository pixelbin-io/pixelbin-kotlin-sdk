package com.pixelbin.transformation.type
import com.pixelbin.transformation.TransformationObj


class PrTag {
 
    

    /**
     * Method for AI Product Tagging
     * 
     * @return TransformationObj.
     */
     @JvmOverloads
    fun tag(
       
    ): TransformationObj {
        // Create the values HashMap
        val values = HashMap<String, String>()
        
        
        return TransformationObj(
            plugin = "pr",
            name = "tag",
            values = values
        )
    }
}

