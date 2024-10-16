package io.pixelbin.sdk_kotlin
import io.pixelbin.sdk_kotlin.transformation.AfRemove
import io.pixelbin.sdk_kotlin.transformation.AwsrekDetectlabels
import io.pixelbin.sdk_kotlin.transformation.AwsrekModeration
import io.pixelbin.sdk_kotlin.transformation.BgExtend
import io.pixelbin.sdk_kotlin.transformation.CosDetect
import io.pixelbin.sdk_kotlin.transformation.CpvDetect
import io.pixelbin.sdk_kotlin.transformation.DbtDetect
import io.pixelbin.sdk_kotlin.transformation.EraseBg
import io.pixelbin.sdk_kotlin.transformation.GenerateBg
import io.pixelbin.sdk_kotlin.transformation.GooglevisDetectlabels
import io.pixelbin.sdk_kotlin.transformation.IcCrop
import io.pixelbin.sdk_kotlin.transformation.ImMask
import io.pixelbin.sdk_kotlin.transformation.ImcDetect
import io.pixelbin.sdk_kotlin.transformation.NsfwDetect
import io.pixelbin.sdk_kotlin.transformation.NumplateDetect
import io.pixelbin.sdk_kotlin.transformation.OcDetect
import io.pixelbin.sdk_kotlin.transformation.OcrExtract
import io.pixelbin.sdk_kotlin.transformation.OdDetect
import io.pixelbin.sdk_kotlin.transformation.PrTag
import io.pixelbin.sdk_kotlin.transformation.PwrRemove
import io.pixelbin.sdk_kotlin.transformation.QrGenerate
import io.pixelbin.sdk_kotlin.transformation.QrScan
import io.pixelbin.sdk_kotlin.transformation.RemoveBg
import io.pixelbin.sdk_kotlin.transformation.ShadowGen
import io.pixelbin.sdk_kotlin.transformation.SrUpscale
import io.pixelbin.sdk_kotlin.transformation.TBlur
import io.pixelbin.sdk_kotlin.transformation.TCompress
import io.pixelbin.sdk_kotlin.transformation.TDensity
import io.pixelbin.sdk_kotlin.transformation.TExtend
import io.pixelbin.sdk_kotlin.transformation.TExtract
import io.pixelbin.sdk_kotlin.transformation.TFlatten
import io.pixelbin.sdk_kotlin.transformation.TFlip
import io.pixelbin.sdk_kotlin.transformation.TFlop
import io.pixelbin.sdk_kotlin.transformation.TGrey
import io.pixelbin.sdk_kotlin.transformation.TLinear
import io.pixelbin.sdk_kotlin.transformation.TMedian
import io.pixelbin.sdk_kotlin.transformation.TMerge
import io.pixelbin.sdk_kotlin.transformation.TModulate
import io.pixelbin.sdk_kotlin.transformation.TNegate
import io.pixelbin.sdk_kotlin.transformation.TNormalise
import io.pixelbin.sdk_kotlin.transformation.TResize
import io.pixelbin.sdk_kotlin.transformation.TRotate
import io.pixelbin.sdk_kotlin.transformation.TSharpen
import io.pixelbin.sdk_kotlin.transformation.TTint
import io.pixelbin.sdk_kotlin.transformation.TToformat
import io.pixelbin.sdk_kotlin.transformation.TTrim
import io.pixelbin.sdk_kotlin.transformation.VdDetect
import io.pixelbin.sdk_kotlin.transformation.VertexaiGeneratebg
import io.pixelbin.sdk_kotlin.transformation.VertexaiRemovebg
import io.pixelbin.sdk_kotlin.transformation.VertexaiUpscale
import io.pixelbin.sdk_kotlin.transformation.VgGenerate
import io.pixelbin.sdk_kotlin.transformation.VsrUpscale
import io.pixelbin.sdk_kotlin.transformation.WmRemove
import io.pixelbin.sdk_kotlin.transformation.WmcDetect
import io.pixelbin.sdk_kotlin.transformation.WmvRemove

object Transformation {
    // DetectBackgroundType
    /**
     * Classifies the background of a product as plain, clean or busy
     *
     * @return The generated TransformationObj.
     */
    @JvmOverloads
    fun dbtDetect(): TransformationObj {
        // Call the generated class method
        return DbtDetect().detect()
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
    fun tResize(
        height: Int? =
            0,
        width: Int? =
            0,
        fit: TResize.Fit? =
            TResize.Fit.COVER,
        background: String? =
            "000000",
        position: TResize.Position? =
            TResize.Position.CENTER,
        algorithm: TResize.Algorithm? =
            TResize.Algorithm.LANCZOS3,
        dpr: Number? =
            1,
    ): TransformationObj {
        // Call the generated class method
        return TResize().resize(
            height,
            width,
            fit,
            background,
            position,
            algorithm,
            dpr,
        )
    }

    /**
     * Basic Transformations
     *
     * @param quality Quality (Default: 80)
     * @return The generated TransformationObj.
     */
    @JvmOverloads
    fun tCompress(
        quality: Int? =
            80,
    ): TransformationObj {
        // Call the generated class method
        return TCompress().compress(
            quality,
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
    fun tExtend(
        top: Int? =
            10,
        left: Int? =
            10,
        bottom: Int? =
            10,
        right: Int? =
            10,
        background: String? =
            "000000",
        bordertype: TExtend.Bordertype? =
            TExtend.Bordertype.CONSTANT,
        dpr: Number? =
            1,
    ): TransformationObj {
        // Call the generated class method
        return TExtend().extend(
            top,
            left,
            bottom,
            right,
            background,
            bordertype,
            dpr,
        )
    }

    /**
     * Basic Transformations
     *
     * @param top Top (Default: 10)
     * @param left Left (Default: 10)
     * @param height Height (Default: 50)
     * @param width Width (Default: 20)
     * @param boundingbox Bounding box
     * @return The generated TransformationObj.
     */
    @JvmOverloads
    fun tExtract(
        top: Int? =
            10,
        left: Int? =
            10,
        height: Int? =
            50,
        width: Int? =
            20,
        boundingbox: String? =
            null,
    ): TransformationObj {
        // Call the generated class method
        return TExtract().extract(
            top,
            left,
            height,
            width,
            boundingbox,
        )
    }

    /**
     * Basic Transformations
     *
     * @param threshold Threshold (Default: 10)
     * @return The generated TransformationObj.
     */
    @JvmOverloads
    fun tTrim(
        threshold: Int? =
            10,
    ): TransformationObj {
        // Call the generated class method
        return TTrim().trim(
            threshold,
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
    fun tRotate(
        angle: Int? =
            0,
        background: String? =
            "000000",
    ): TransformationObj {
        // Call the generated class method
        return TRotate().rotate(
            angle,
            background,
        )
    }

    /**
     * Basic Transformations
     *
     * @return The generated TransformationObj.
     */
    @JvmOverloads
    fun tFlip(): TransformationObj {
        // Call the generated class method
        return TFlip().flip()
    }

    /**
     * Basic Transformations
     *
     * @return The generated TransformationObj.
     */
    @JvmOverloads
    fun tFlop(): TransformationObj {
        // Call the generated class method
        return TFlop().flop()
    }

    /**
     * Basic Transformations
     *
     * @param sigma Sigma (Default: 1.5)
     * @return The generated TransformationObj.
     */
    @JvmOverloads
    fun tSharpen(
        sigma: Number? =
            1.5,
    ): TransformationObj {
        // Call the generated class method
        return TSharpen().sharpen(
            sigma,
        )
    }

    /**
     * Basic Transformations
     *
     * @param size Size (Default: 3)
     * @return The generated TransformationObj.
     */
    @JvmOverloads
    fun tMedian(
        size: Int? =
            3,
    ): TransformationObj {
        // Call the generated class method
        return TMedian().median(
            size,
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
    fun tBlur(
        sigma: Number? =
            0.3,
        dpr: Number? =
            1,
    ): TransformationObj {
        // Call the generated class method
        return TBlur().blur(
            sigma,
            dpr,
        )
    }

    /**
     * Basic Transformations
     *
     * @param background Background (Default: 000000)
     * @return The generated TransformationObj.
     */
    @JvmOverloads
    fun tFlatten(
        background: String? =
            "000000",
    ): TransformationObj {
        // Call the generated class method
        return TFlatten().flatten(
            background,
        )
    }

    /**
     * Basic Transformations
     *
     * @return The generated TransformationObj.
     */
    @JvmOverloads
    fun tNegate(): TransformationObj {
        // Call the generated class method
        return TNegate().negate()
    }

    /**
     * Basic Transformations
     *
     * @return The generated TransformationObj.
     */
    @JvmOverloads
    fun tNormalise(): TransformationObj {
        // Call the generated class method
        return TNormalise().normalise()
    }

    /**
     * Basic Transformations
     *
     * @param a A (Default: 1)
     * @param b B (Default: 0)
     * @return The generated TransformationObj.
     */
    @JvmOverloads
    fun tLinear(
        a: Int? =
            1,
        b: Int? =
            0,
    ): TransformationObj {
        // Call the generated class method
        return TLinear().linear(
            a,
            b,
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
    fun tModulate(
        brightness: Number? =
            1,
        saturation: Number? =
            1,
        hue: Int? =
            90,
    ): TransformationObj {
        // Call the generated class method
        return TModulate().modulate(
            brightness,
            saturation,
            hue,
        )
    }

    /**
     * Basic Transformations
     *
     * @return The generated TransformationObj.
     */
    @JvmOverloads
    fun tGrey(): TransformationObj {
        // Call the generated class method
        return TGrey().grey()
    }

    /**
     * Basic Transformations
     *
     * @param color Color (Default: 000000)
     * @return The generated TransformationObj.
     */
    @JvmOverloads
    fun tTint(
        color: String? =
            "000000",
    ): TransformationObj {
        // Call the generated class method
        return TTint().tint(
            color,
        )
    }

    /**
     * Basic Transformations
     *
     * @param format Format (Default: jpeg)
     * @param quality Quality (Default: 75)
     * @return The generated TransformationObj.
     */
    @JvmOverloads
    fun tToformat(
        format: TToformat.Format? =
            TToformat.Format.JPEG,
        quality: TToformat.Quality? =
            TToformat.Quality._75,
    ): TransformationObj {
        // Call the generated class method
        return TToformat().toFormat(
            format,
            quality,
        )
    }

    /**
     * Basic Transformations
     *
     * @param density Density (Default: 300)
     * @return The generated TransformationObj.
     */
    @JvmOverloads
    fun tDensity(
        density: Int? =
            300,
    ): TransformationObj {
        // Call the generated class method
        return TDensity().density(
            density,
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
    fun tMerge(
        mode: TMerge.Mode? =
            TMerge.Mode.OVERLAY,
        image: String? =
            "",
        transformation: String? =
            "",
        background: String? =
            "00000000",
        height: Int? =
            0,
        width: Int? =
            0,
        top: Int? =
            0,
        left: Int? =
            0,
        gravity: TMerge.Gravity? =
            TMerge.Gravity.CENTER,
        blend: TMerge.Blend? =
            TMerge.Blend.OVER,
        tile: Boolean? =
            false,
        listofbboxes: String? =
            null,
        listofpolygons: String? =
            null,
    ): TransformationObj {
        // Call the generated class method
        return TMerge().merge(
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
            listofpolygons,
        )
    }
    // Artifact

    /**
     * Artifact Removal Plugin
     *
     * @return The generated TransformationObj.
     */
    @JvmOverloads
    fun afRemove(): TransformationObj {
        // Call the generated class method
        return AfRemove().remove()
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
    fun awsrekDetectlabels(
        maximumlabels: Int? =
            5,
        minimumconfidence: Int? =
            55,
    ): TransformationObj {
        // Call the generated class method
        return AwsrekDetectlabels().detectLabels(
            maximumlabels,
            minimumconfidence,
        )
    }

    /**
     * Detect objects and text in images
     *
     * @param minimumconfidence Minimum confidence (Default: 55)
     * @return The generated TransformationObj.
     */
    @JvmOverloads
    fun awsrekModeration(
        minimumconfidence: Int? =
            55,
    ): TransformationObj {
        // Call the generated class method
        return AwsrekModeration().moderation(
            minimumconfidence,
        )
    }
    // BackgroundGenerator

    /**
     * AI Background Generator
     *
     * @param backgroundprompt Background prompt (Default: YSBmb3Jlc3QgZnVsbCBvZiBvYWsgdHJlZXMsd2l0aCBicmlnaHQgbGlnaHRzLCBzdW4gYW5kIGEgbG90IG9mIG1hZ2ljLCB1bHRyYSByZWFsaXN0aWMsIDhr)
     * @param focus Focus (Default: Product)
     * @param negativeprompt Negative prompt (Default: )
     * @param seed Seed (Default: 123)
     * @return The generated TransformationObj.
     */
    @JvmOverloads
    fun generateBg(
        backgroundprompt: String? =
            "YSBmb3Jlc3QgZnVsbCBvZiBvYWsgdHJlZXMsd2l0aCBicmlnaHQgbGlnaHRzLCBzdW4gYW5kIGEgbG90IG9mIG1hZ2ljLCB1bHRyYSByZWFsaXN0aWMsIDhr",
        focus: GenerateBg.Focus? =
            GenerateBg.Focus.PRODUCT,
        negativeprompt: String? =
            "",
        seed: Int? =
            123,
    ): TransformationObj {
        // Call the generated class method
        return GenerateBg().bg(
            backgroundprompt,
            focus,
            negativeprompt,
            seed,
        )
    }
    // ImageExtender

    /**
     * AI Image Extender
     *
     * @param boundingbox Bounding Box
     * @param prompt Prompt (Default: )
     * @param negativeprompt Negative Prompt (Default: )
     * @param strength Strength (Default: 0.999)
     * @param guidancescale Guidance Scale (Default: 8)
     * @param numberofinferencesteps Number of inference steps (Default: 10)
     * @param coloradjust Color Adjust (Default: false)
     * @param seed Seed (Default: 123)
     * @return The generated TransformationObj.
     */
    @JvmOverloads
    fun bgExtend(
        boundingbox: String? =
            null,
        prompt: String? =
            "",
        negativeprompt: String? =
            "",
        strength: Number? =
            0.999,
        guidancescale: Int? =
            8,
        numberofinferencesteps: Int? =
            10,
        coloradjust: Boolean? =
            false,
        seed: Int? =
            123,
    ): TransformationObj {
        // Call the generated class method
        return BgExtend().extend(
            boundingbox,
            prompt,
            negativeprompt,
            strength,
            guidancescale,
            numberofinferencesteps,
            coloradjust,
            seed,
        )
    }
    // VariationGenerator

    /**
     * AI Variation Generator
     *
     * @param generatevariationprompt Generate variation prompt (Default: )
     * @param noofvariations No. of variations (Default: 1)
     * @param seed Seed (Default: 0)
     * @param autoscale Autoscale input if it exceeds maximum resolution (Default: true)
     * @return The generated TransformationObj.
     */
    @JvmOverloads
    fun vgGenerate(
        generatevariationprompt: String? =
            "",
        noofvariations: Int? =
            1,
        seed: Int? =
            0,
        autoscale: Boolean? =
            true,
    ): TransformationObj {
        // Call the generated class method
        return VgGenerate().generate(
            generatevariationprompt,
            noofvariations,
            seed,
            autoscale,
        )
    }
    // EraseBG

    /**
     * EraseBG Background Removal Module
     *
     * @param industrytype Foreground Type (Default: general)
     * @param addshadow Add Shadow (cars only) (Default: false)
     * @param refine Refine Output (Default: true)
     * @return The generated TransformationObj.
     */
    @JvmOverloads
    fun eraseBg(
        industrytype: EraseBg.Industrytype? =
            EraseBg.Industrytype.GENERAL,
        addshadow: Boolean? =
            false,
        refine: Boolean? =
            true,
    ): TransformationObj {
        // Call the generated class method
        return EraseBg().bg(
            industrytype,
            addshadow,
            refine,
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
    fun googlevisDetectlabels(
        maximumlabels: Int? =
            5,
    ): TransformationObj {
        // Call the generated class method
        return GooglevisDetectlabels().detectLabels(
            maximumlabels,
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
    fun imcDetect(
        distancepercentage: Int? =
            10,
    ): TransformationObj {
        // Call the generated class method
        return ImcDetect().detect(
            distancepercentage,
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
    fun icCrop(
        requiredwidth: Int? =
            0,
        requiredheight: Int? =
            0,
        paddingpercentage: Int? =
            0,
        maintainoriginalaspect: Boolean? =
            false,
        aspectratio: String? =
            "",
        gravitytowards: IcCrop.Gravitytowards? =
            IcCrop.Gravitytowards.NONE,
        preferreddirection: IcCrop.Preferreddirection? =
            IcCrop.Preferreddirection.CENTER,
        objecttype: IcCrop.Objecttype? =
            IcCrop.Objecttype.PERSON,
    ): TransformationObj {
        // Call the generated class method
        return IcCrop().crop(
            requiredwidth,
            requiredheight,
            paddingpercentage,
            maintainoriginalaspect,
            aspectratio,
            gravitytowards,
            preferreddirection,
            objecttype,
        )
    }
    // IntelligentMasking

    /**
     * Intelligent Masking
     *
     * @param replacementimage Replacement image (Default: )
     * @param detector Detector (Default: number_plate)
     * @param masktype Mask type (Default: fill_black)
     * @return The generated TransformationObj.
     */
    @JvmOverloads
    fun imMask(
        replacementimage: String? =
            "",
        detector: ImMask.Detector? =
            ImMask.Detector.NUMBER_PLATE,
        masktype: ImMask.Masktype? =
            ImMask.Masktype.FILL_BLACK,
    ): TransformationObj {
        // Call the generated class method
        return ImMask().mask(
            replacementimage,
            detector,
            masktype,
        )
    }
    // ObjectCounter

    /**
     * Classifies whether objects in the image are single or multiple
     *
     * @return The generated TransformationObj.
     */
    @JvmOverloads
    fun ocDetect(): TransformationObj {
        // Call the generated class method
        return OcDetect().detect()
    }
    // NSFWDetection

    /**
     * Detect NSFW content in images
     *
     * @param minimumconfidence Minimum confidence (Default: 0.5)
     * @return The generated TransformationObj.
     */
    @JvmOverloads
    fun nsfwDetect(
        minimumconfidence: Number? =
            0.5,
    ): TransformationObj {
        // Call the generated class method
        return NsfwDetect().detect(
            minimumconfidence,
        )
    }
    // NumberPlateDetection

    /**
     * Number Plate Detection Plugin
     *
     * @return The generated TransformationObj.
     */
    @JvmOverloads
    fun numplateDetect(): TransformationObj {
        // Call the generated class method
        return NumplateDetect().detect()
    }
    // ObjectDetection

    /**
     * Detect bounding boxes of objects in the image
     *
     * @return The generated TransformationObj.
     */
    @JvmOverloads
    fun odDetect(): TransformationObj {
        // Call the generated class method
        return OdDetect().detect()
    }
    // CheckObjectSize

    /**
     * Calculates the percentage of the main object area relative to image dimensions.
     *
     * @param objectthresholdpercent Object threshold percent (Default: 50)
     * @return The generated TransformationObj.
     */
    @JvmOverloads
    fun cosDetect(
        objectthresholdpercent: Int? =
            50,
    ): TransformationObj {
        // Call the generated class method
        return CosDetect().detect(
            objectthresholdpercent,
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
    fun ocrExtract(
        detectonly: Boolean? =
            false,
    ): TransformationObj {
        // Call the generated class method
        return OcrExtract().extract(
            detectonly,
        )
    }
    // PdfWatermarkRemoval

    /**
     * PDF Watermark Removal Plugin
     *
     * @return The generated TransformationObj.
     */
    @JvmOverloads
    fun pwrRemove(): TransformationObj {
        // Call the generated class method
        return PwrRemove().remove()
    }
    // ProductTagging

    /**
     * AI Product Tagging
     *
     * @return The generated TransformationObj.
     */
    @JvmOverloads
    fun prTag(): TransformationObj {
        // Call the generated class method
        return PrTag().tag()
    }
    // CheckProductVisibility

    /**
     * Classifies whether the product in the image is completely visible or not
     *
     * @return The generated TransformationObj.
     */
    @JvmOverloads
    fun cpvDetect(): TransformationObj {
        // Call the generated class method
        return CpvDetect().detect()
    }
    // QRCode

    /**
     * QRCode Plugin
     *
     * @param width Width (Default: 300)
     * @param height Height (Default: 300)
     * @param image Logo URL (Default: )
     * @param margin Margin around QR (Default: 0)
     * @param qrtypenumber QR Type Number (Default: 0)
     * @param qrerrorcorrectionlevel QR Error Correction Level (Default: Q)
     * @param imagesize Logo Size (Default: 0.4)
     * @param imagemargin Margin around Logo (Default: 0)
     * @param dotscolor Dots Color (Default: 000000)
     * @param dotstype Dots Type (Default: square)
     * @param dotsbgcolor Dots Background Color (Default: ffffff)
     * @param cornersquarecolor Corner Square Color (Default: 000000)
     * @param cornersquaretype Corner Square Type (Default: square)
     * @param cornerdotscolor Corner Dots Color (Default: 000000)
     * @param cornerdotstype Corner Dots Type (Default: dot)
     * @return The generated TransformationObj.
     */
    @JvmOverloads
    fun qrGenerate(
        width: Int? =
            300,
        height: Int? =
            300,
        image: String? =
            "",
        margin: Int? =
            0,
        qrtypenumber: Int? =
            0,
        qrerrorcorrectionlevel: QrGenerate.Qrerrorcorrectionlevel? =
            QrGenerate.Qrerrorcorrectionlevel.Q,
        imagesize: Number? =
            0.4,
        imagemargin: Int? =
            0,
        dotscolor: String? =
            "000000",
        dotstype: QrGenerate.Dotstype? =
            QrGenerate.Dotstype.SQUARE,
        dotsbgcolor: String? =
            "ffffff",
        cornersquarecolor: String? =
            "000000",
        cornersquaretype: QrGenerate.Cornersquaretype? =
            QrGenerate.Cornersquaretype.SQUARE,
        cornerdotscolor: String? =
            "000000",
        cornerdotstype: QrGenerate.Cornerdotstype? =
            QrGenerate.Cornerdotstype.DOT,
    ): TransformationObj {
        // Call the generated class method
        return QrGenerate().generate(
            width,
            height,
            image,
            margin,
            qrtypenumber,
            qrerrorcorrectionlevel,
            imagesize,
            imagemargin,
            dotscolor,
            dotstype,
            dotsbgcolor,
            cornersquarecolor,
            cornersquaretype,
            cornerdotscolor,
            cornerdotstype,
        )
    }

    /**
     * QRCode Plugin
     *
     * @return The generated TransformationObj.
     */
    @JvmOverloads
    fun qrScan(): TransformationObj {
        // Call the generated class method
        return QrScan().scan()
    }
    // RemoveBG

    /**
     * Remove background from any image
     *
     * @return The generated TransformationObj.
     */
    @JvmOverloads
    fun removeBg(): TransformationObj {
        // Call the generated class method
        return RemoveBg().bg()
    }
    // SoftShadowGenerator

    /**
     * AI Soft Shadow Generator
     *
     * @param backgroundimage Background image
     * @param backgroundcolor Background color (Default: ffffff)
     * @param shadowangle Shadow angle (Default: 120)
     * @param shadowintensity Shadow intensity (Default: 0.5)
     * @return The generated TransformationObj.
     */
    @JvmOverloads
    fun shadowGen(
        backgroundimage: String? =
            null,
        backgroundcolor: String? =
            "ffffff",
        shadowangle: Number? =
            120,
        shadowintensity: Number? =
            0.5,
    ): TransformationObj {
        // Call the generated class method
        return ShadowGen().gen(
            backgroundimage,
            backgroundcolor,
            shadowangle,
            shadowintensity,
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
    fun srUpscale(
        type: SrUpscale.Type? =
            SrUpscale.Type._2X,
        enhanceface: Boolean? =
            false,
        model: SrUpscale.Model? =
            SrUpscale.Model.PICASSO,
        enhancequality: Boolean? =
            false,
    ): TransformationObj {
        // Call the generated class method
        return SrUpscale().upscale(
            type,
            enhanceface,
            model,
            enhancequality,
        )
    }
    // VertexAI

    /**
     * Vertex AI based transformations
     *
     * @param backgroundprompt Background prompt (Default: YSBmb3Jlc3QgZnVsbCBvZiBvYWsgdHJlZXMsd2l0aCBicmlnaHQgbGlnaHRzLCBzdW4gYW5kIGEgbG90IG9mIG1hZ2ljLCB1bHRyYSByZWFsaXN0aWMsIDhr)
     * @param negativeprompt Negative prompt (Default: )
     * @param seed Seed (Default: 22)
     * @param guidancescale Guidance Scale (controls how much the model adheres to the text prompt) (Default: 60)
     * @return The generated TransformationObj.
     */
    @JvmOverloads
    fun vertexaiGeneratebg(
        backgroundprompt: String? =
            "YSBmb3Jlc3QgZnVsbCBvZiBvYWsgdHJlZXMsd2l0aCBicmlnaHQgbGlnaHRzLCBzdW4gYW5kIGEgbG90IG9mIG1hZ2ljLCB1bHRyYSByZWFsaXN0aWMsIDhr",
        negativeprompt: String? =
            "",
        seed: Int? =
            22,
        guidancescale: Int? =
            60,
    ): TransformationObj {
        // Call the generated class method
        return VertexaiGeneratebg().generateBG(
            backgroundprompt,
            negativeprompt,
            seed,
            guidancescale,
        )
    }

    /**
     * Vertex AI based transformations
     *
     * @return The generated TransformationObj.
     */
    @JvmOverloads
    fun vertexaiRemovebg(): TransformationObj {
        // Call the generated class method
        return VertexaiRemovebg().removeBG()
    }

    /**
     * Vertex AI based transformations
     *
     * @param type Type (Default: x2)
     * @return The generated TransformationObj.
     */
    @JvmOverloads
    fun vertexaiUpscale(
        type: VertexaiUpscale.Type? =
            VertexaiUpscale.Type.X2,
    ): TransformationObj {
        // Call the generated class method
        return VertexaiUpscale().upscale(
            type,
        )
    }
    // VideoWatermarkRemoval

    /**
     * Video Watermark Removal Plugin
     *
     * @return The generated TransformationObj.
     */
    @JvmOverloads
    fun wmvRemove(): TransformationObj {
        // Call the generated class method
        return WmvRemove().remove()
    }
    // VideoUpscalerPlugin

    /**
     * Video Upscaler Plugin
     *
     * @return The generated TransformationObj.
     */
    @JvmOverloads
    fun vsrUpscale(): TransformationObj {
        // Call the generated class method
        return VsrUpscale().upscale()
    }
    // ViewDetection

    /**
     * Classifies wear type and view type of products in the image
     *
     * @return The generated TransformationObj.
     */
    @JvmOverloads
    fun vdDetect(): TransformationObj {
        // Call the generated class method
        return VdDetect().detect()
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
    fun wmRemove(
        removetext: Boolean? =
            false,
        removelogo: Boolean? =
            false,
        box1: String? =
            "0_0_100_100",
        box2: String? =
            "0_0_0_0",
        box3: String? =
            "0_0_0_0",
        box4: String? =
            "0_0_0_0",
        box5: String? =
            "0_0_0_0",
    ): TransformationObj {
        // Call the generated class method
        return WmRemove().remove(
            removetext,
            removelogo,
            box1,
            box2,
            box3,
            box4,
            box5,
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
    fun wmcDetect(
        detecttext: Boolean? =
            false,
    ): TransformationObj {
        // Call the generated class method
        return WmcDetect().detect(
            detecttext,
        )
    }
}
