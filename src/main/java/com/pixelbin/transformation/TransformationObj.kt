package com.pixelbin.transformation

data class TransformationObj(
    @JvmField var plugin: String,
    @JvmField var name: String,
    @JvmField var values: HashMap<String, String>? = HashMap(),
)