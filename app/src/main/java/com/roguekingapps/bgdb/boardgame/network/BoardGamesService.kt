package com.roguekingapps.bgdb.boardgame.network

import com.roguekingapps.bgdb.boardgame.network.ResponseResult.Error
import com.roguekingapps.bgdb.boardgame.network.ResponseResult.Success
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface BoardGamesService {

    @GET("xmlapi2/hot/")
    fun getBoardGames(): Deferred<Response<String>>

}

suspend fun <T : Any> awaitResponse(call: () -> Deferred<Response<T>>): ResponseResult<T> {
    return try {
        val response = call.invoke().await()
        if (response.isSuccessful) {
            Success(response.body() as T)
        } else {
            Error()
        }
    } catch (e: Exception) {
        Error()
    }
}