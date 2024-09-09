package com.pixelbin.transformation.type
import com.pixelbin.transformation.TransformationObj


class AwsrekDetectlabels {
 
    
    
    
    
    

    /**
     * Method for Detect objects and text in images
     * 
     * @param Maximum Labels Int (Default: 5)
     
     * @param Minimum Confidence Int (Default: 55)
     
     * @return TransformationObj.
     */
     @JvmOverloads
    fun detectLabels(
       
        maximumlabels: Int? = null,
        
        minimumconfidence: Int? = null
        
    ): TransformationObj {
        // Create the values HashMap
        val values = HashMap<String, String>()
        
        
        
        values["l"] = maximumlabels.toString()
        
        
        
        
        
        values["c"] = minimumconfidence.toString()
        
        
        
        
        return TransformationObj(
            plugin = "awsRek",
            name = "detectLabels",
            values = values
        )
    }
}


class AwsrekModeration {
 
    
    
    

    /**
     * Method for Detect objects and text in images
     * 
     * @param Minimum Confidence Int (Default: 55)
     
     * @return TransformationObj.
     */
     @JvmOverloads
    fun moderation(
       
        minimumconfidence: Int? = null
        
    ): TransformationObj {
        // Create the values HashMap
        val values = HashMap<String, String>()
        
        
        
        values["c"] = minimumconfidence.toString()
        
        
        
        
        return TransformationObj(
            plugin = "awsRek",
            name = "moderation",
            values = values
        )
    }
}

