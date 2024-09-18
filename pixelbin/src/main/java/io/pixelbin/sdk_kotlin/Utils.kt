package io.pixelbin.sdk_kotlin

import io.pixelbin.sdk_kotlin.url.Url
import io.pixelbin.sdk_kotlin.url.UrlObj

object Utils {
    fun objToUrl(urlObj: UrlObj): String {
        return Url(urlObject = urlObj).getUrl()
    }

    fun urlToUrlObj(url: String, isCustomDomain: Boolean? = false): UrlObj? {
        return Url(imgUrl = url, isCustomDomain = isCustomDomain).getUrlObject()
    }
}
