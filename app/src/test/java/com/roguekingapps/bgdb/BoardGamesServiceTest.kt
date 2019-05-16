package com.roguekingapps.bgdb

import com.roguekingapps.bgdb.ResponseResult.Error
import com.roguekingapps.bgdb.ResponseResult.Success
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
    fun `To Response Succeeds`() {
        runBlocking {
            val data = "to response successful"
            deferred.complete(Response.success(data))
            assertEquals(data, (deferred.toResponse() as Success).data)
        }
    }

    @Test
    fun `To Response Fails`() {
        runBlocking {
            deferred.complete(Response.error(400, ResponseBody.create(null, "to response failed")))
            assertTrue(deferred.toResponse() is Error)
        }
    }

    @Test
    fun `To Response Throws Exception`() {
        runBlocking {
            deferred.completeExceptionally(Exception())
            assertTrue(deferred.toResponse() is Error)
        }
    }

}