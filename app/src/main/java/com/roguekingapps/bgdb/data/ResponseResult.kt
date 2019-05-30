package com.roguekingapps.bgdb.data

sealed class ResponseResult<out T : Any> {
    data class Success<out T : Any>(val data: T) : ResponseResult<T>()
    class Error : ResponseResult<Nothing>()
}