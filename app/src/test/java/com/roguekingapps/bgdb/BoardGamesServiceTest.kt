package com.roguekingapps.bgdb

import com.roguekingapps.bgdb.boardgame.network.ResponseResult.Error
import com.roguekingapps.bgdb.boardgame.network.ResponseResult.Success
import com.roguekingapps.bgdb.boardgame.network.awaitResponse
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.runBlocking
import okhttp3.ResponseBody
import org.junit.Test
import retrofit2.Response
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class BoardGamesServiceTest {

    private val deferred = CompletableDeferred<Response<String>>()

    @Test
    fun `Await Response Succeeds`() {
        runBlocking {
            val data = "await response successful"
            deferred.complete(Response.success(data))
            assertEquals(data, (awaitResponse { deferred } as Success).data)
        }
    }

    @Test
    fun `Await Response Fails`() {
        runBlocking {
            deferred.complete(Response.error(400, ResponseBody.create(null, "await response failed")))
            assertTrue(awaitResponse { deferred } is Error)
        }
    }

    @Test
    fun `Await Response Throws Exception`() {
        runBlocking {
            deferred.completeExceptionally(Exception())
            assertTrue(awaitResponse { deferred } is Error)
        }
    }

}