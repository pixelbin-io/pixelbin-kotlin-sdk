package com.pixelbin.transformation

import com.pixelbin.transformation.TransformationObj

internal object TransformationMap{
    val hashMap:HashMap<String,TransformationObj> = hashMapOf(
        
        
        "dbt.detect" to Transformation.detectbackgroundtype(),
        
        
        
        "af.remove" to Transformation.artifact(),
        
        
        
        "awsRek.detectLabels" to Transformation.detectlabels(),
        
        "awsRek.moderation" to Transformation.moderation(),
        
        
        
        "generate.bg" to Transformation.backgroundgenerator(),
        
        
        
        "erase.bg" to Transformation.erasebg(),
        
        
        
        "googleVis.detectLabels" to Transformation.googlevisionplugin(),
        
        
        
        "imc.detect" to Transformation.imagecentering(),
        
        
        
        "ic.crop" to Transformation.intelligentcrop(),
        
        
        
        "oc.detect" to Transformation.objectcounter(),
        
        
        
        "numPlate.detect" to Transformation.numberplatedetection(),
        
        
        
        "cos.detect" to Transformation.checkobjectsize(),
        
        
        
        "ocr.extract" to Transformation.textdetectionandrecognition(),
        
        
        
        "pwr.remove" to Transformation.pdfwatermarkremoval(),
        
        
        
        "pr.tag" to Transformation.producttagging(),
        
        
        
        "cpv.detect" to Transformation.checkproductvisibility(),
        
        
        
        "remove.bg" to Transformation.removebg(),
        
        
        
        "t.resize" to Transformation.resize(),
        
        "t.compress" to Transformation.compress(),
        
        "t.extend" to Transformation.extend(),
        
        "t.extract" to Transformation.extract(),
        
        "t.trim" to Transformation.trim(),
        
        "t.rotate" to Transformation.rotate(),
        
        "t.flip" to Transformation.flip(),
        
        "t.flop" to Transformation.flop(),
        
        "t.sharpen" to Transformation.sharpen(),
        
        "t.median" to Transformation.median(),
        
        "t.blur" to Transformation.blur(),
        
        "t.flatten" to Transformation.flatten(),
        
        "t.negate" to Transformation.negate(),
        
        "t.normalise" to Transformation.normalise(),
        
        "t.linear" to Transformation.linear(),
        
        "t.modulate" to Transformation.modulate(),
        
        "t.grey" to Transformation.grey(),
        
        "t.tint" to Transformation.tint(),
        
        "t.toFormat" to Transformation.toformat(),
        
        "t.density" to Transformation.density(),
        
        "t.merge" to Transformation.merge(),
        
        
        
        "sr.upscale" to Transformation.superresolution(),
        
        
        
        "wm.remove" to Transformation.watermarkremoval(),
        
        
        
        "wmc.detect" to Transformation.watermarkdetection(),
        
        
    )
}