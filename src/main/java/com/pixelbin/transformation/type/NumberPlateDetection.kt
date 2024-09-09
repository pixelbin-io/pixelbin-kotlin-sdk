package com.pixelbin.transformation.type
import com.pixelbin.transformation.TransformationObj


class NumplateDetect {
 
    

    /**
     * Method for Number Plate Detection Plugin
     * 
     * @return TransformationObj.
     */
     @JvmOverloads
    fun detect(
       
    ): TransformationObj {
        // Create the values HashMap
        val values = HashMap<String, String>()
        
        
        return TransformationObj(
            plugin = "numPlate",
            name = "detect",
            values = values
        )
    }
}

