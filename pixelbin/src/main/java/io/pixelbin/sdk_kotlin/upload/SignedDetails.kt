package io.pixelbin.sdk_kotlin.upload

data class SignedDetails(
    @JvmField val url: String?,
    @JvmField val fields: Map<String, String>,
)
