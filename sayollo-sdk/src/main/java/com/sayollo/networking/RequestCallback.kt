package com.sayollo.networking

interface RequestCallback<T> {
    fun onReceived(response: T?)
    fun onFailure(t: Throwable?)
}