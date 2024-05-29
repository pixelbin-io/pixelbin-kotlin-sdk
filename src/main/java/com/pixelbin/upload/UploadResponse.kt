package com.pixelbin.upload

data class UploadResponse(
    val _id: String?,
    val access: String?,
    val assetType: String?,
    val context: HashMap<String, Any>?,
    val fileId: String?,
    val format: String?,
    val height: Int?,
    val isOriginal: Boolean?,
    val metadata: HashMap<String, Any>?,
    val name: String?,
    val orgId: Long?,
    val path: String?,
    val size: Long?,
    val tags: List<String?>?,
    val type: String?,
    val url: String?,
    val width: Int?
)