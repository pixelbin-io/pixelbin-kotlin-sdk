package com.pixelbin.transformation.type
import com.pixelbin.transformation.TransformationObj


class ImcDetect {
 
    
    
    

    /**
     * Method for Image Centering Module
     * 
     * @param Distance percentage Int (Default: 10)
     
     * @return TransformationObj.
     */
     @JvmOverloads
    fun detect(
       
        distancepercentage: Int? = null
        
    ): TransformationObj {
        // Create the values HashMap
        val values = HashMap<String, String>()
        
        
        
        values["dist_perc"] = distancepercentage.toString()
        
        
        
        
        return TransformationObj(
            plugin = "imc",
            name = "detect",
            values = values
        )
    }
}

