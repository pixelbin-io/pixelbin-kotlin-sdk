package com.pixelbin.transformation

import com.pixelbin.transformation.TransformationObj

internal object TransformationMap{
    val hashMap:HashMap<String,TransformationObj> = hashMapOf(
        
        
        "dbt.detect" to Transformation.dbtDetect(),
        
        
        
        "af.remove" to Transformation.afRemove(),
        
        
        
        "awsRek.detectLabels" to Transformation.awsrekDetectlabels(),
        
        "awsRek.moderation" to Transformation.awsrekModeration(),
        
        
        
        "generate.bg" to Transformation.generateBg(),
        
        
        
        "vg.generate" to Transformation.vgGenerate(),
        
        
        
        "erase.bg" to Transformation.eraseBg(),
        
        
        
        "googleVis.detectLabels" to Transformation.googlevisDetectlabels(),
        
        
        
        "imc.detect" to Transformation.imcDetect(),
        
        
        
        "ic.crop" to Transformation.icCrop(),
        
        
        
        "oc.detect" to Transformation.ocDetect(),
        
        
        
        "nsfw.detect" to Transformation.nsfwDetect(),
        
        
        
        "numPlate.detect" to Transformation.numplateDetect(),
        
        
        
        "od.detect" to Transformation.odDetect(),
        
        
        
        "cos.detect" to Transformation.cosDetect(),
        
        
        
        "ocr.extract" to Transformation.ocrExtract(),
        
        
        
        "pwr.remove" to Transformation.pwrRemove(),
        
        
        
        "pr.tag" to Transformation.prTag(),
        
        
        
        "cpv.detect" to Transformation.cpvDetect(),
        
        
        
        "qr.generate" to Transformation.qrGenerate(),
        
        "qr.scan" to Transformation.qrScan(),
        
        
        
        "remove.bg" to Transformation.removeBg(),
        
        
        
        "t.resize" to Transformation.tResize(),
        
        "t.compress" to Transformation.tCompress(),
        
        "t.extend" to Transformation.tExtend(),
        
        "t.extract" to Transformation.tExtract(),
        
        "t.trim" to Transformation.tTrim(),
        
        "t.rotate" to Transformation.tRotate(),
        
        "t.flip" to Transformation.tFlip(),
        
        "t.flop" to Transformation.tFlop(),
        
        "t.sharpen" to Transformation.tSharpen(),
        
        "t.median" to Transformation.tMedian(),
        
        "t.blur" to Transformation.tBlur(),
        
        "t.flatten" to Transformation.tFlatten(),
        
        "t.negate" to Transformation.tNegate(),
        
        "t.normalise" to Transformation.tNormalise(),
        
        "t.linear" to Transformation.tLinear(),
        
        "t.modulate" to Transformation.tModulate(),
        
        "t.grey" to Transformation.tGrey(),
        
        "t.tint" to Transformation.tTint(),
        
        "t.toFormat" to Transformation.tToformat(),
        
        "t.density" to Transformation.tDensity(),
        
        "t.merge" to Transformation.tMerge(),
        
        
        
        "shadow.gen" to Transformation.shadowGen(),
        
        
        
        "sr.upscale" to Transformation.srUpscale(),
        
        
        
        "vertexAi.generateBG" to Transformation.vertexaiGeneratebg(),
        
        "vertexAi.removeBG" to Transformation.vertexaiRemovebg(),
        
        "vertexAi.upscale" to Transformation.vertexaiUpscale(),
        
        
        
        "wmv.remove" to Transformation.wmvRemove(),
        
        
        
        "vd.detect" to Transformation.vdDetect(),
        
        
        
        "wm.remove" to Transformation.wmRemove(),
        
        
        
        "wmc.detect" to Transformation.wmcDetect(),
        
        
    )
}