package com.roguekingapps.bgdb

import com.roguekingapps.bgdb.ResponseResult.Error
import com.roguekingapps.bgdb.ResponseResult.Success
import kotlinx.coroutines.Deferred
import retrofit2.Response

interface BoardGamesService {

    fun getBoardGames(): Deferred<Response<List<String>>>

}

suspend fun <T : Any> Deferred<Response<T>>.toResponse(): ResponseResult<T> {
    return try {
        val response = await()
        if (response.isSuccessful) {
            Success(response.body() as T)
        } else {
            Error()
        }
    } catch (e: Exception) {
        Error()
    }
}