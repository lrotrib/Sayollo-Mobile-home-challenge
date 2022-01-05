package com.sayollo.networking

import com.sayollo.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

internal open class NetworkModule {

    protected val httpClient: OkHttpClient by lazy {
        buildClient()
    }

    private fun buildClient(): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
            .readTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(30, TimeUnit.SECONDS)

            .addInterceptor { chain ->
                val original = chain.request()
                val url = original.url.newBuilder().build()

                val requestBuilder = original.newBuilder()
                    .addHeader("Content-Type", "application/json")
                    .url(url)
                    .build()
                chain.proceed(requestBuilder)
            }

        if (BuildConfig.DEBUG) {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            httpClient.addInterceptor(logging)
        }
        return httpClient.build()
    }
}