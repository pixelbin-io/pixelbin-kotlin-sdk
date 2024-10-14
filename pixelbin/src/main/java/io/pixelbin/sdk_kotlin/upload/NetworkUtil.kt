package io.pixelbin.sdk_kotlin.upload

import okhttp3.*
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.ResponseBody.Companion.toResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import java.io.IOException
import java.util.concurrent.TimeUnit

object NetworkUtil {
    fun createOkHttpClient(): OkHttpClient {
        val loggingInterceptor =
            HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY // Choose the desired log level
            }

        return OkHttpClient
            .Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(RetryInterceptor())
            .connectTimeout(45, TimeUnit.SECONDS)
            .readTimeout(45, TimeUnit.SECONDS)
            .writeTimeout(45, TimeUnit.SECONDS)
            .build()
    }
}

class RetryInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        lateinit var response: Response
        var retryCount = 0
        val maxRetries = 3
        var errorMsg: String
        do {
            try {
                response = chain.proceed(request)
                if (!response.isSuccessful && retryCount < maxRetries) {
                    val exception = response.body?.string()
                    if (exception != null && exception.contains("timeout")) {
                        // It's a timeout, so we'll retry.
                        retryCount++
                    } else {
                        break
                    }
                } else {
                    break
                }
            } catch (e: IOException) {
                if (e.message?.contains("timeout") == true) {
                    retryCount++
                    errorMsg = "timeout"
                    if (retryCount == 3) {
                        response =
                            Response
                                .Builder()
                                .request(chain.request())
                                .protocol(Protocol.HTTP_1_1)
                                .code(408) // Some appropriate default status code
                                .message(errorMsg)
                                .body("".toResponseBody("application/json".toMediaType()))
                                .build()
                    }
                } else {
                    errorMsg = e.message.toString()
                    Response
                        .Builder()
                        .request(chain.request())
                        .protocol(Protocol.HTTP_1_1)
                        .message(errorMsg)
                        .build()
                    break
                }
            }
        } while (retryCount < maxRetries)
        return response
    }
}
