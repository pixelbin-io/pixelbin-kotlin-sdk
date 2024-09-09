package com.pixelbin.transformation.type
import com.pixelbin.transformation.TransformationObj


class OcrExtract {
 
    
    
    

    /**
     * Method for OCR Module
     * 
     * @param Detect Only Boolean (Default: false)
     
     * @return TransformationObj.
     */
     @JvmOverloads
    fun extract(
       
        detectonly: Boolean? = null
        
    ): TransformationObj {
        // Create the values HashMap
        val values = HashMap<String, String>()
        
        
        
        values["detect_only"] = detectonly.toString()
        
        
        
        
        return TransformationObj(
            plugin = "ocr",
            name = "extract",
            values = values
        )
    }
}

