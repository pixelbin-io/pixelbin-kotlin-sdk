package io.pixelbin.sdk_kotlin.url

import io.pixelbin.sdk_kotlin.transformation.TransformationObj

data class UrlObj @JvmOverloads constructor(
    @JvmField val baseUrl: String,
    @JvmField val version: String,
    @JvmField val cloudName: String,
    @JvmField var transformation: ArrayList<TransformationObj> = ArrayList(),
    @JvmField val zone: String,
    @JvmField val filePath: String,
    @JvmField var options: HashMap<String, String>? = null,
    @JvmField val worker: Boolean? = false,
    @JvmField val isCustomDomain: Boolean? = false,
    @JvmField val workerPath: String? = "",
)

