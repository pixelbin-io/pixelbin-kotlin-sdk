package com.pixelbin.transformation

import com.pixelbin.transformation.TransformationObj


import com.pixelbin.transformation.type.DetectBackgroundType



import com.pixelbin.transformation.type.Artifact



import com.pixelbin.transformation.type.Detectlabels

import com.pixelbin.transformation.type.Moderation



import com.pixelbin.transformation.type.BackgroundGenerator



import com.pixelbin.transformation.type.EraseBG



import com.pixelbin.transformation.type.GoogleVisionPlugin



import com.pixelbin.transformation.type.ImageCentering



import com.pixelbin.transformation.type.IntelligentCrop



import com.pixelbin.transformation.type.ObjectCounter



import com.pixelbin.transformation.type.NSFWDetection



import com.pixelbin.transformation.type.NumberPlateDetection



import com.pixelbin.transformation.type.ObjectDetection



import com.pixelbin.transformation.type.CheckObjectSize



import com.pixelbin.transformation.type.TextDetectionandRecognition



import com.pixelbin.transformation.type.PdfWatermarkRemoval



import com.pixelbin.transformation.type.ProductTagging



import com.pixelbin.transformation.type.CheckProductVisibility



import com.pixelbin.transformation.type.RemoveBG



import com.pixelbin.transformation.type.Resize

import com.pixelbin.transformation.type.Compress

import com.pixelbin.transformation.type.Extend

import com.pixelbin.transformation.type.Extract

import com.pixelbin.transformation.type.Trim

import com.pixelbin.transformation.type.Rotate

import com.pixelbin.transformation.type.Flip

import com.pixelbin.transformation.type.Flop

import com.pixelbin.transformation.type.Sharpen

import com.pixelbin.transformation.type.Median

import com.pixelbin.transformation.type.Blur

import com.pixelbin.transformation.type.Flatten

import com.pixelbin.transformation.type.Negate

import com.pixelbin.transformation.type.Normalise

import com.pixelbin.transformation.type.Linear

import com.pixelbin.transformation.type.Modulate

import com.pixelbin.transformation.type.Grey

import com.pixelbin.transformation.type.Tint

import com.pixelbin.transformation.type.Toformat

import com.pixelbin.transformation.type.Density

import com.pixelbin.transformation.type.Merge



import com.pixelbin.transformation.type.SuperResolution



import com.pixelbin.transformation.type.ViewDetection



import com.pixelbin.transformation.type.WatermarkRemoval



import com.pixelbin.transformation.type.WatermarkDetection



object Transformation {
    
    // DetectBackgroundType
    
    /**
     * Classifies the background of a product as plain, clean or busy
     * 
     * @return The generated TransformationObj.
     */
     @JvmOverloads
    fun detectbackgroundtype(
   
    ): TransformationObj {
        // Call the generated class method
        return DetectBackgroundType().detect(
            
        )
    }
    
    
    // Artifact
    
    /**
     * Artifact Removal Plugin
     * 
     * @return The generated TransformationObj.
     */
     @JvmOverloads
    fun artifact(
   
    ): TransformationObj {
        // Call the generated class method
        return Artifact().remove(
            
        )
    }
    
    
    // AWSRekognitionPlugin
    
    /**
     * Detect objects and text in images
     * 
     * @param maximumlabels Maximum labels (Default: 5)
     
     * @param minimumconfidence Minimum confidence (Default: 55)
     
     * @return The generated TransformationObj.
     */
     @JvmOverloads
    fun  detectlabels(
   
    maximumlabels: Int?
     = 5,

    minimumconfidence: Int?
     = 55

    ): TransformationObj {
        // Call the generated class method
        return  Detectlabels().detectLabels(
            
            maximumlabels, 
            
            minimumconfidence
            
        )
    }
    
    /**
     * Detect objects and text in images
     * 
     * @param minimumconfidence Minimum confidence (Default: 55)
     
     * @return The generated TransformationObj.
     */
     @JvmOverloads
    fun  moderation(
   
    minimumconfidence: Int?
     = 55

    ): TransformationObj {
        // Call the generated class method
        return  Moderation().moderation(
            
            minimumconfidence
            
        )
    }
    
    
    // BackgroundGenerator
    
    /**
     * AI Background Generator
     * 
     * @param backgroundprompt Background prompt (Default: cmVhbGlzdGljIGdyZWVuIGdyYXNzLCBsYXduIGZpZWxkIG9mIGdyYXNzLCBibHVlIHNreSB3aXRoIHdoaXRlIGNsb3Vkcw)
     
     * @param backgroundimageforshadow Background image for shadow (Default: )
     
     * @param focus Focus (Default: Product)
     
     * @param negativeprompt Negative prompt (Default: )
     
     * @param seed Seed (Default: 123)
     
     * @return The generated TransformationObj.
     */
     @JvmOverloads
    fun backgroundgenerator(
   
    backgroundprompt: String?
     = "cmVhbGlzdGljIGdyZWVuIGdyYXNzLCBsYXduIGZpZWxkIG9mIGdyYXNzLCBibHVlIHNreSB3aXRoIHdoaXRlIGNsb3Vkcw",

    backgroundimageforshadow: String?
     = "",

    focus: BackgroundGenerator.Focus?
     = BackgroundGenerator.Focus.PRODUCT,

    negativeprompt: String?
     = "",

    seed: Int?
     = 123

    ): TransformationObj {
        // Call the generated class method
        return BackgroundGenerator().bg(
            
            backgroundprompt, 
            
            backgroundimageforshadow, 
            
            focus, 
            
            negativeprompt, 
            
            seed
            
        )
    }
    
    
    // EraseBG
    
    /**
     * EraseBG Background Removal Module
     * 
     * @param industrytype Industry type (Default: general)
     
     * @param addshadow Add Shadow (cars only) (Default: false)
     
     * @return The generated TransformationObj.
     */
     @JvmOverloads
    fun erasebg(
   
    industrytype: EraseBG.Industrytype?
     = EraseBG.Industrytype.GENERAL,

    addshadow: Boolean?
     = false

    ): TransformationObj {
        // Call the generated class method
        return EraseBG().bg(
            
            industrytype, 
            
            addshadow
            
        )
    }
    
    
    // GoogleVisionPlugin
    
    /**
     * Detect content and text in images
     * 
     * @param maximumlabels Maximum labels (Default: 5)
     
     * @return The generated TransformationObj.
     */
     @JvmOverloads
    fun googlevisionplugin(
   
    maximumlabels: Int?
     = 5

    ): TransformationObj {
        // Call the generated class method
        return GoogleVisionPlugin().detectLabels(
            
            maximumlabels
            
        )
    }
    
    
    // ImageCentering
    
    /**
     * Image Centering Module
     * 
     * @param distancepercentage Distance percentage (Default: 10)
     
     * @return The generated TransformationObj.
     */
     @JvmOverloads
    fun imagecentering(
   
    distancepercentage: Int?
     = 10

    ): TransformationObj {
        // Call the generated class method
        return ImageCentering().detect(
            
            distancepercentage
            
        )
    }
    
    
    // IntelligentCrop
    
    /**
     * Intelligent Crop Plugin
     * 
     * @param requiredwidth Required width (Default: 0)
     
     * @param requiredheight Required height (Default: 0)
     
     * @param paddingpercentage Padding percentage (Default: 0)
     
     * @param maintainoriginalaspect Maintain original aspect (Default: false)
     
     * @param aspectratio Aspect Ratio (16_9 or 2 or 0.25) (Default: )
     
     * @param gravitytowards Gravity towards (Default: none)
     
     * @param preferreddirection Preferred direction (Default: center)
     
     * @param objecttype Object Type (if Gravity is object) (Default: person)
     
     * @return The generated TransformationObj.
     */
     @JvmOverloads
    fun intelligentcrop(
   
    requiredwidth: Int?
     = 0,

    requiredheight: Int?
     = 0,

    paddingpercentage: Int?
     = 0,

    maintainoriginalaspect: Boolean?
     = false,

    aspectratio: String?
     = "",

    gravitytowards: IntelligentCrop.Gravitytowards?
     = IntelligentCrop.Gravitytowards.NONE,

    preferreddirection: IntelligentCrop.Preferreddirection?
     = IntelligentCrop.Preferreddirection.CENTER,

    objecttype: IntelligentCrop.Objecttype?
     = IntelligentCrop.Objecttype.PERSON

    ): TransformationObj {
        // Call the generated class method
        return IntelligentCrop().crop(
            
            requiredwidth, 
            
            requiredheight, 
            
            paddingpercentage, 
            
            maintainoriginalaspect, 
            
            aspectratio, 
            
            gravitytowards, 
            
            preferreddirection, 
            
            objecttype
            
        )
    }
    
    
    // ObjectCounter
    
    /**
     * Classifies whether objects in the image are single or multiple
     * 
     * @return The generated TransformationObj.
     */
     @JvmOverloads
    fun objectcounter(
   
    ): TransformationObj {
        // Call the generated class method
        return ObjectCounter().detect(
            
        )
    }
    
    
    // NSFWDetection
    
    /**
     * Detect NSFW content in images
     * 
     * @param minimumconfidence Minimum confidence (Default: 0.5)
     
     * @return The generated TransformationObj.
     */
     @JvmOverloads
    fun nsfwdetection(
   
    minimumconfidence: Number?
     = 0.5

    ): TransformationObj {
        // Call the generated class method
        return NSFWDetection().detect(
            
            minimumconfidence
            
        )
    }
    
    
    // NumberPlateDetection
    
    /**
     * Number Plate Detection Plugin
     * 
     * @return The generated TransformationObj.
     */
     @JvmOverloads
    fun numberplatedetection(
   
    ): TransformationObj {
        // Call the generated class method
        return NumberPlateDetection().detect(
            
        )
    }
    
    
    // ObjectDetection
    
    /**
     * Detect bounding boxes of objects in the image
     * 
     * @return The generated TransformationObj.
     */
     @JvmOverloads
    fun objectdetection(
   
    ): TransformationObj {
        // Call the generated class method
        return ObjectDetection().detect(
            
        )
    }
    
    
    // CheckObjectSize
    
    /**
     * Calculates the percentage of the main object area relative to image dimensions.
     * 
     * @param objectthresholdpercent Object threshold percent (Default: 50)
     
     * @return The generated TransformationObj.
     */
     @JvmOverloads
    fun checkobjectsize(
   
    objectthresholdpercent: Int?
     = 50

    ): TransformationObj {
        // Call the generated class method
        return CheckObjectSize().detect(
            
            objectthresholdpercent
            
        )
    }
    
    
    // TextDetectionandRecognition
    
    /**
     * OCR Module
     * 
     * @param detectonly Detect only (Default: false)
     
     * @return The generated TransformationObj.
     */
     @JvmOverloads
    fun textdetectionandrecognition(
   
    detectonly: Boolean?
     = false

    ): TransformationObj {
        // Call the generated class method
        return TextDetectionandRecognition().extract(
            
            detectonly
            
        )
    }
    
    
    // PdfWatermarkRemoval
    
    /**
     * PDF Watermark Removal Plugin
     * 
     * @return The generated TransformationObj.
     */
     @JvmOverloads
    fun pdfwatermarkremoval(
   
    ): TransformationObj {
        // Call the generated class method
        return PdfWatermarkRemoval().remove(
            
        )
    }
    
    
    // ProductTagging
    
    /**
     * AI Product Tagging
     * 
     * @return The generated TransformationObj.
     */
     @JvmOverloads
    fun producttagging(
   
    ): TransformationObj {
        // Call the generated class method
        return ProductTagging().tag(
            
        )
    }
    
    
    // CheckProductVisibility
    
    /**
     * Classifies whether the product in the image is completely visible or not
     * 
     * @return The generated TransformationObj.
     */
     @JvmOverloads
    fun checkproductvisibility(
   
    ): TransformationObj {
        // Call the generated class method
        return CheckProductVisibility().detect(
            
        )
    }
    
    
    // RemoveBG
    
    /**
     * Remove background from any image
     * 
     * @return The generated TransformationObj.
     */
     @JvmOverloads
    fun removebg(
   
    ): TransformationObj {
        // Call the generated class method
        return RemoveBG().bg(
            
        )
    }
    
    
    // Basic
    
    /**
     * Basic Transformations
     * 
     * @param height Height (Default: 0)
     
     * @param width Width (Default: 0)
     
     * @param fit Fit (Default: cover)
     
     * @param background Background (Default: 000000)
     
     * @param position Position (Default: center)
     
     * @param algorithm Algorithm (Default: lanczos3)
     
     * @param dpr Dpr (Default: 1)
     
     * @return The generated TransformationObj.
     */
     @JvmOverloads
    fun  resize(
   
    height: Int?
     = 0,

    width: Int?
     = 0,

    fit:  Resize.Fit?
     =  Resize.Fit.COVER,

    background: String?
     = "000000",

    position:  Resize.Position?
     =  Resize.Position.CENTER,

    algorithm:  Resize.Algorithm?
     =  Resize.Algorithm.LANCZOS3,

    dpr: Number?
     = 1

    ): TransformationObj {
        // Call the generated class method
        return  Resize().resize(
            
            height, 
            
            width, 
            
            fit, 
            
            background, 
            
            position, 
            
            algorithm, 
            
            dpr
            
        )
    }
    
    /**
     * Basic Transformations
     * 
     * @param quality Quality (Default: 80)
     
     * @return The generated TransformationObj.
     */
     @JvmOverloads
    fun  compress(
   
    quality: Int?
     = 80

    ): TransformationObj {
        // Call the generated class method
        return  Compress().compress(
            
            quality
            
        )
    }
    
    /**
     * Basic Transformations
     * 
     * @param top Top (Default: 10)
     
     * @param left Left (Default: 10)
     
     * @param bottom Bottom (Default: 10)
     
     * @param right Right (Default: 10)
     
     * @param background Background (Default: 000000)
     
     * @param bordertype Border type (Default: constant)
     
     * @param dpr Dpr (Default: 1)
     
     * @return The generated TransformationObj.
     */
     @JvmOverloads
    fun  extend(
   
    top: Int?
     = 10,

    left: Int?
     = 10,

    bottom: Int?
     = 10,

    right: Int?
     = 10,

    background: String?
     = "000000",

    bordertype:  Extend.Bordertype?
     =  Extend.Bordertype.CONSTANT,

    dpr: Number?
     = 1

    ): TransformationObj {
        // Call the generated class method
        return  Extend().extend(
            
            top, 
            
            left, 
            
            bottom, 
            
            right, 
            
            background, 
            
            bordertype, 
            
            dpr
            
        )
    }
    
    /**
     * Basic Transformations
     * 
     * @param top Top (Default: 10)
     
     * @param left Left (Default: 10)
     
     * @param height Height (Default: 50)
     
     * @param width Width (Default: 20)
     
     * @return The generated TransformationObj.
     */
     @JvmOverloads
    fun  extract(
   
    top: Int?
     = 10,

    left: Int?
     = 10,

    height: Int?
     = 50,

    width: Int?
     = 20

    ): TransformationObj {
        // Call the generated class method
        return  Extract().extract(
            
            top, 
            
            left, 
            
            height, 
            
            width
            
        )
    }
    
    /**
     * Basic Transformations
     * 
     * @param threshold Threshold (Default: 10)
     
     * @return The generated TransformationObj.
     */
     @JvmOverloads
    fun  trim(
   
    threshold: Int?
     = 10

    ): TransformationObj {
        // Call the generated class method
        return  Trim().trim(
            
            threshold
            
        )
    }
    
    /**
     * Basic Transformations
     * 
     * @param angle Angle (Default: 0)
     
     * @param background Background (Default: 000000)
     
     * @return The generated TransformationObj.
     */
     @JvmOverloads
    fun  rotate(
   
    angle: Int?
     = 0,

    background: String?
     = "000000"

    ): TransformationObj {
        // Call the generated class method
        return  Rotate().rotate(
            
            angle, 
            
            background
            
        )
    }
    
    /**
     * Basic Transformations
     * 
     * @return The generated TransformationObj.
     */
     @JvmOverloads
    fun  flip(
   
    ): TransformationObj {
        // Call the generated class method
        return  Flip().flip(
            
        )
    }
    
    /**
     * Basic Transformations
     * 
     * @return The generated TransformationObj.
     */
     @JvmOverloads
    fun  flop(
   
    ): TransformationObj {
        // Call the generated class method
        return  Flop().flop(
            
        )
    }
    
    /**
     * Basic Transformations
     * 
     * @param sigma Sigma (Default: 1.5)
     
     * @return The generated TransformationObj.
     */
     @JvmOverloads
    fun  sharpen(
   
    sigma: Number?
     = 1.5

    ): TransformationObj {
        // Call the generated class method
        return  Sharpen().sharpen(
            
            sigma
            
        )
    }
    
    /**
     * Basic Transformations
     * 
     * @param size Size (Default: 3)
     
     * @return The generated TransformationObj.
     */
     @JvmOverloads
    fun  median(
   
    size: Int?
     = 3

    ): TransformationObj {
        // Call the generated class method
        return  Median().median(
            
            size
            
        )
    }
    
    /**
     * Basic Transformations
     * 
     * @param sigma Sigma (Default: 0.3)
     
     * @param dpr Dpr (Default: 1)
     
     * @return The generated TransformationObj.
     */
     @JvmOverloads
    fun  blur(
   
    sigma: Number?
     = 0.3,

    dpr: Number?
     = 1

    ): TransformationObj {
        // Call the generated class method
        return  Blur().blur(
            
            sigma, 
            
            dpr
            
        )
    }
    
    /**
     * Basic Transformations
     * 
     * @param background Background (Default: 000000)
     
     * @return The generated TransformationObj.
     */
     @JvmOverloads
    fun  flatten(
   
    background: String?
     = "000000"

    ): TransformationObj {
        // Call the generated class method
        return  Flatten().flatten(
            
            background
            
        )
    }
    
    /**
     * Basic Transformations
     * 
     * @return The generated TransformationObj.
     */
     @JvmOverloads
    fun  negate(
   
    ): TransformationObj {
        // Call the generated class method
        return  Negate().negate(
            
        )
    }
    
    /**
     * Basic Transformations
     * 
     * @return The generated TransformationObj.
     */
     @JvmOverloads
    fun  normalise(
   
    ): TransformationObj {
        // Call the generated class method
        return  Normalise().normalise(
            
        )
    }
    
    /**
     * Basic Transformations
     * 
     * @param a A (Default: 1)
     
     * @param b B (Default: 0)
     
     * @return The generated TransformationObj.
     */
     @JvmOverloads
    fun  linear(
   
    a: Int?
     = 1,

    b: Int?
     = 0

    ): TransformationObj {
        // Call the generated class method
        return  Linear().linear(
            
            a, 
            
            b
            
        )
    }
    
    /**
     * Basic Transformations
     * 
     * @param brightness Brightness (Default: 1)
     
     * @param saturation Saturation (Default: 1)
     
     * @param hue Hue (Default: 90)
     
     * @return The generated TransformationObj.
     */
     @JvmOverloads
    fun  modulate(
   
    brightness: Number?
     = 1,

    saturation: Number?
     = 1,

    hue: Int?
     = 90

    ): TransformationObj {
        // Call the generated class method
        return  Modulate().modulate(
            
            brightness, 
            
            saturation, 
            
            hue
            
        )
    }
    
    /**
     * Basic Transformations
     * 
     * @return The generated TransformationObj.
     */
     @JvmOverloads
    fun  grey(
   
    ): TransformationObj {
        // Call the generated class method
        return  Grey().grey(
            
        )
    }
    
    /**
     * Basic Transformations
     * 
     * @param color Color (Default: 000000)
     
     * @return The generated TransformationObj.
     */
     @JvmOverloads
    fun  tint(
   
    color: String?
     = "000000"

    ): TransformationObj {
        // Call the generated class method
        return  Tint().tint(
            
            color
            
        )
    }
    
    /**
     * Basic Transformations
     * 
     * @param format Format (Default: jpeg)
     
     * @return The generated TransformationObj.
     */
     @JvmOverloads
    fun  toformat(
   
    format:  Toformat.Format?
     =  Toformat.Format.JPEG

    ): TransformationObj {
        // Call the generated class method
        return  Toformat().toFormat(
            
            format
            
        )
    }
    
    /**
     * Basic Transformations
     * 
     * @param density Density (Default: 300)
     
     * @return The generated TransformationObj.
     */
     @JvmOverloads
    fun  density(
   
    density: Int?
     = 300

    ): TransformationObj {
        // Call the generated class method
        return  Density().density(
            
            density
            
        )
    }
    
    /**
     * Basic Transformations
     * 
     * @param mode Mode (Default: overlay)
     
     * @param image Image (Default: )
     
     * @param transformation Transformation (Default: )
     
     * @param background Background (Default: 00000000)
     
     * @param height Height (Default: 0)
     
     * @param width Width (Default: 0)
     
     * @param top Top (Default: 0)
     
     * @param left Left (Default: 0)
     
     * @param gravity Gravity (Default: center)
     
     * @param blend Blend (Default: over)
     
     * @param tile Tile (Default: false)
     
     * @param listofbboxes List of bboxes
     
     * @param listofpolygons List of polygons
     
     * @return The generated TransformationObj.
     */
     @JvmOverloads
    fun  merge(
   
    mode:  Merge.Mode?
     =  Merge.Mode.OVERLAY,

    image: String?
     = "",

    transformation: String?
     = "",

    background: String?
     = "00000000",

    height: Int?
     = 0,

    width: Int?
     = 0,

    top: Int?
     = 0,

    left: Int?
     = 0,

    gravity:  Merge.Gravity?
     =  Merge.Gravity.CENTER,

    blend:  Merge.Blend?
     =  Merge.Blend.OVER,

    tile: Boolean?
     = false,

    listofbboxes: String?
    ="",

    listofpolygons: String?
    =""

    ): TransformationObj {
        // Call the generated class method
        return  Merge().merge(
            
            mode, 
            
            image, 
            
            transformation, 
            
            background, 
            
            height, 
            
            width, 
            
            top, 
            
            left, 
            
            gravity, 
            
            blend, 
            
            tile, 
            
            listofbboxes, 
            
            listofpolygons
            
        )
    }
    
    
    // SuperResolution
    
    /**
     * Super Resolution Module
     * 
     * @param type Type (Default: 2x)
     
     * @param enhanceface Enhance face (Default: false)
     
     * @param model Model (Default: Picasso)
     
     * @param enhancequality Enhance quality (Default: false)
     
     * @return The generated TransformationObj.
     */
     @JvmOverloads
    fun superresolution(
   
    type: SuperResolution.Type?
     = SuperResolution.Type._2X,

    enhanceface: Boolean?
     = false,

    model: SuperResolution.Model?
     = SuperResolution.Model.PICASSO,

    enhancequality: Boolean?
     = false

    ): TransformationObj {
        // Call the generated class method
        return SuperResolution().upscale(
            
            type, 
            
            enhanceface, 
            
            model, 
            
            enhancequality
            
        )
    }
    
    
    // ViewDetection
    
    /**
     * Classifies wear type and view type of products in the image
     * 
     * @return The generated TransformationObj.
     */
     @JvmOverloads
    fun viewdetection(
   
    ): TransformationObj {
        // Call the generated class method
        return ViewDetection().detect(
            
        )
    }
    
    
    // WatermarkRemoval
    
    /**
     * Watermark Removal Plugin
     * 
     * @param removetext Remove text (Default: false)
     
     * @param removelogo Remove logo (Default: false)
     
     * @param box1 Box 1 (Default: 0_0_100_100)
     
     * @param box2 Box 2 (Default: 0_0_0_0)
     
     * @param box3 Box 3 (Default: 0_0_0_0)
     
     * @param box4 Box 4 (Default: 0_0_0_0)
     
     * @param box5 Box 5 (Default: 0_0_0_0)
     
     * @return The generated TransformationObj.
     */
     @JvmOverloads
    fun watermarkremoval(
   
    removetext: Boolean?
     = false,

    removelogo: Boolean?
     = false,

    box1: String?
     = "0_0_100_100",

    box2: String?
     = "0_0_0_0",

    box3: String?
     = "0_0_0_0",

    box4: String?
     = "0_0_0_0",

    box5: String?
     = "0_0_0_0"

    ): TransformationObj {
        // Call the generated class method
        return WatermarkRemoval().remove(
            
            removetext, 
            
            removelogo, 
            
            box1, 
            
            box2, 
            
            box3, 
            
            box4, 
            
            box5
            
        )
    }
    
    
    // WatermarkDetection
    
    /**
     * Watermark Detection Plugin
     * 
     * @param detecttext Detect text (Default: false)
     
     * @return The generated TransformationObj.
     */
     @JvmOverloads
    fun watermarkdetection(
   
    detecttext: Boolean?
     = false

    ): TransformationObj {
        // Call the generated class method
        return WatermarkDetection().detect(
            
            detecttext
            
        )
    }
    
    
}
