package io.pixelbin.sdk_kotlin.error

sealed class PDKException(message: String) : Exception(message)

class PDKInvalidUrlException(message: String) : PDKException(message)
class PDKIllegalArgumentException(message: String) : PDKException(message)
class PDKIllegalStateException(message: String) : PDKException(message)
class PDKIllegalQueryParameterException(message: String) : PDKException(message)
class PDKTransformationException(message: String) : PDKException(message)
class PDKTimeoutException(message: String) : PDKException(message)
