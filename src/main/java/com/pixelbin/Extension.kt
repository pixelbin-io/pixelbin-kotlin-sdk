package com.pixelbin

fun Int?.isNullOrZero(): Boolean {
    return this == null || this == 0
}

fun Int.validateParam(paramName: String, maxValue: Int, minValue: Int = 0) {
    if (this > maxValue)
        throw IllegalArgumentException("$paramName value cannot be greater than $maxValue")
    else if (this < minValue)
        throw IllegalArgumentException("$paramName value cannot be less than $minValue")
}

fun Number.validateParam(paramName: String, maxValue: Int) {
    if (this.toDouble() > maxValue.toDouble())
        throw IllegalArgumentException("$paramName value cannot be greater than $maxValue")
}

fun String.addParenthesis():String = this.plus("()")