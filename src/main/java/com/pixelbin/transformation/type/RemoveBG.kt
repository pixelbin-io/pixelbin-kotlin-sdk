package com.pixelbin.transformation.type
import com.pixelbin.transformation.TransformationObj


 class RemoveBG {
 
    

    /**
     * Method for Remove background from any image
     * 
     * @return TransformationObj.
     */
     @JvmOverloads
    fun bg(
       
    ): TransformationObj {
        // Create the values HashMap
        val values = HashMap<String, String>()
        
        
        return TransformationObj(
            plugin = "remove",
            name = "bg",
            values = values
        )
    }
}

