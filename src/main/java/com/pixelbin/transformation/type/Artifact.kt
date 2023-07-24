package com.pixelbin.transformation.type
import com.pixelbin.transformation.TransformationObj


 class Artifact {
 
    

    /**
     * Method for Artifact Removal Plugin
     * 
     * @return TransformationObj.
     */
     @JvmOverloads
    fun remove(
       
    ): TransformationObj {
        // Create the values HashMap
        val values = HashMap<String, String>()
        
        
        return TransformationObj(
            plugin = "af",
            name = "remove",
            values = values
        )
    }
}

