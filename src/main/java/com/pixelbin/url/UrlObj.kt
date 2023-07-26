package com.pixelbin.url

import com.pixelbin.transformation.TransformationObj

data class UrlObj @JvmOverloads constructor(
    @JvmField val baseUrl: String,
    @JvmField val version: String,
    @JvmField val cloudName: String,
    @JvmField var transformation: ArrayList<TransformationObj> = ArrayList(),
    @JvmField val zone: String,
    @JvmField val filePath: String,
    @JvmField var options:HashMap<String,String>? = null
)
