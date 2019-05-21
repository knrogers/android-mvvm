package com.roguekingapps.bgdb

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import com.roguekingapps.bgdb.boardgame.network.BoardGames
import com.roguekingapps.bgdb.boardgame.network.ResponseHandler
import com.roguekingapps.bgdb.boardgame.network.ResponseResult.Error
import com.roguekingapps.bgdb.boardgame.network.ResponseResult.Success
import com.roguekingapps.bgdb.boardgame.network.awaitResponse
import kotlinx.coroutines.runBlocking
import okhttp3.ResponseBody
import org.junit.Test
import retrofit2.Response
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class BoardGamesServiceTest {

    private val handler = mock<ResponseHandler<BoardGames>>()

    @Test
    fun `Await Response Succeeds`() {
        runBlocking {
            val data = BoardGames(emptyList())
            val response = Response.success(data)
            whenever(handler.doRequest()).thenReturn(response)
            whenever(handler.onSuccess(response)).thenReturn(Success(data))
            assertEquals(data, (awaitResponse(handler) as Success).data)
        }
    }

    @Test
    fun `Await Response Fails`() {
        runBlocking {
            val response = Response.error<BoardGames>(400, ResponseBody.create(null, "await response failed"))
            whenever(handler.doRequest()).thenReturn(response)
            whenever(handler.onFailure()).thenReturn(Error())
            assertTrue(awaitResponse(handler) is Error)
        }
    }

    @Test
    fun `Await Response Throws Exception`() {
        runBlocking {
            whenever(handler.doRequest()).then { throw Exception() }
            whenever(handler.onException()).thenReturn(Error())
            assertTrue(awaitResponse(handler) is Error)
        }
    }

}