package com.roguekingapps.bgdb.data

import com.roguekingapps.bgdb.data.ResponseResult.Error
import com.roguekingapps.bgdb.data.ResponseResult.Success
import retrofit2.Response

interface ResponseHandler<T : Any> {

    suspend fun doRequest(): Response<T>
    fun onSuccess(response: Response<T>): Success<T>
    fun onFailure(): Error
    fun onException(): Error

}

suspend fun <T : Any> awaitResponse(handler: ResponseHandler<T>): ResponseResult<T> {
    return try {
        val response = handler.doRequest()
        if (response.isSuccessful) handler.onSuccess(response)
        else handler.onFailure()
    } catch (e: Exception) {
        handler.onException()
    }
}