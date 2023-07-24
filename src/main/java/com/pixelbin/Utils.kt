package com.pixelbin

import com.pixelbin.url.Url
import com.pixelbin.url.UrlObj

object Utils {
    fun objToUrl(urlObj: UrlObj):String{
        return Url(urlObject = urlObj).getUrl()
    }
    
    fun urlToUrlObj(url: String): UrlObj? {
        return Url(url).getUrlObject()
    }
}