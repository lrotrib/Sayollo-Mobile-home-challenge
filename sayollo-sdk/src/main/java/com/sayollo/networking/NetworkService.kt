package com.sayollo.networking

import android.os.Build
import com.sayollo.BuildConfig
import okhttp3.*
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.IOException
import okhttp3.HttpUrl.Companion.toHttpUrl


internal object NetworkService: NetworkModule() {

    fun fetchData(callback: RequestCallback<String>) {
        postData("fetch", callback = callback)
    }

    fun sendData(body: String, callback: RequestCallback<String>) {
        postData("post",body, callback = callback)
    }

    private fun postData(endPoint: String, body: String = "", callback: RequestCallback<String>) {

        val httpBuilder = BuildConfig.BASE_URL.toHttpUrl().newBuilder()
            .addPathSegment(endPoint)
            .build()

        httpClient.newCall(Request.Builder()
            .url(httpBuilder)
            .post(body.toRequestBody())
            .build())
            .enqueue(object: Callback {
                override fun onResponse(call: Call, response: Response) {
                    callback.onReceived(response.body?.string())
                }
                override fun onFailure(call: Call, e: IOException) {
                    callback.onFailure(e)
                }
            })
    }
}