package com.roguekingapps.bgdb

sealed class Response<out T : Any> {
    open class Success<out T : Any> : Response<T>()
}