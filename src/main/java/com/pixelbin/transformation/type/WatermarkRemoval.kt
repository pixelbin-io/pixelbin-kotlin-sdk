package com.pixelbin.transformation.type
import com.pixelbin.transformation.TransformationObj


class WmRemove {
 
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    /**
     * Method for Watermark Removal Plugin
     * 
     * @param Remove Text Boolean (Default: false)
     
     * @param Remove Logo Boolean (Default: false)
     
     * @param Box 1 string (Default: 0_0_100_100)
     
     * @param Box 2 string (Default: 0_0_0_0)
     
     * @param Box 3 string (Default: 0_0_0_0)
     
     * @param Box 4 string (Default: 0_0_0_0)
     
     * @param Box 5 string (Default: 0_0_0_0)
     
     * @return TransformationObj.
     */
     @JvmOverloads
    fun remove(
       
        removetext: Boolean? = null,
        
        removelogo: Boolean? = null,
        
        box1: String? = null,
        
        box2: String? = null,
        
        box3: String? = null,
        
        box4: String? = null,
        
        box5: String? = null
        
    ): TransformationObj {
        // Create the values HashMap
        val values = HashMap<String, String>()
        
        
        
        values["rem_text"] = removetext.toString()
        
        
        
        
        
        values["rem_logo"] = removelogo.toString()
        
        
        
        
        
        
        if(!box1.isNullOrEmpty()){
            values["box1"] = box1.toString()
        }
        
        
        
        
        
        
        
        if(!box2.isNullOrEmpty()){
            values["box2"] = box2.toString()
        }
        
        
        
        
        
        
        
        if(!box3.isNullOrEmpty()){
            values["box3"] = box3.toString()
        }
        
        
        
        
        
        
        
        if(!box4.isNullOrEmpty()){
            values["box4"] = box4.toString()
        }
        
        
        
        
        
        
        
        if(!box5.isNullOrEmpty()){
            values["box5"] = box5.toString()
        }
        
        
        
        
        
        return TransformationObj(
            plugin = "wm",
            name = "remove",
            values = values
        )
    }
}

