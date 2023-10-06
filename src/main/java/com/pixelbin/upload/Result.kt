package com.pixelbin.upload

sealed class Result<out T> {
    data class Success<T>(val data: T) : Result<T>()
    data class Failure<T>(val response: T) : Result<T>()
    data class Error(val exception: Exception) : Result<Nothing>()
}