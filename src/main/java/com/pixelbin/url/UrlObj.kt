package com.pixelbin.url

import com.pixelbin.transformation.TransformationObj

data class UrlObj(
    val baseUrl: String,
    val version: String,
    val cloudName: String,
    var transformation: ArrayList<TransformationObj> = ArrayList(),
    val zone: String,
    val filePath: String,
    var options:HashMap<String,String>? = null
)
