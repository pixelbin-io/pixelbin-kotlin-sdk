package io.pixelbin.android_example.ui.main

import android.arch.lifecycle.ViewModel
import android.util.Log
import io.pixelbin.sdk_kotlin.PixelBin
import io.pixelbin.sdk_kotlin.Transformation
import io.pixelbin.sdk_kotlin.transformation.EraseBg

class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    init {
        // Making Url object from String
        val url =
            PixelBin
                .getInstance()
                .url(imageUrl = "https://cdn.pixelbin.io/v2/dummy-cloudname/original/__playground/playground-default.jpeg")

        // Creating Transformations
        val eraseBgTransformation = Transformation.eraseBg(industrytype = EraseBg.Industrytype.HUMAN)
        val resizeTransformation = Transformation.tResize(width = 200)
        val vaiRemoveBgTransformation = Transformation.vertexaiRemovebg()
        val vaiGenerateBgTransformation = Transformation.vertexaiGeneratebg()

        // Applying transformation
        url.apply {
            addTransformation(eraseBgTransformation)
            addTransformation(vaiRemoveBgTransformation)
            addTransformation(vaiGenerateBgTransformation)
            addTransformation(resizeTransformation)
        }

        // Encoding Url Object to String
        val encodedUrl = url.getUrl()

        println("Encoded: $encodedUrl")
        Log.e("MainViewModel", "Encoded: $encodedUrl")
    }
}
