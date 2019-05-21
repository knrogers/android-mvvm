package com.roguekingapps.bgdb

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import com.roguekingapps.bgdb.boardgame.network.BoardGames
import com.roguekingapps.bgdb.boardgame.network.BoardGamesRepository
import com.roguekingapps.bgdb.boardgame.network.BoardGamesRepositoryImpl
import com.roguekingapps.bgdb.boardgame.network.BoardGamesService
import com.roguekingapps.bgdb.boardgame.network.ResponseResult.Error
import com.roguekingapps.bgdb.boardgame.network.ResponseResult.Success
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.runBlocking
import okhttp3.ResponseBody
import org.junit.Test
import retrofit2.Response
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class BoardGamesRepositoryTest {

    private val boardGamesRepository: BoardGamesRepository by lazy { BoardGamesRepositoryImpl(service) }
    private val service = mock<BoardGamesService>()
    private val deferred = mock<Deferred<Response<BoardGames>>>()

    @Test
    fun `Get Board Games Succeeds`() {
        runBlocking {
            val boardGames = mock<BoardGames>()
            whenever(service.getBoardGames()).thenReturn(deferred)
            whenever(deferred.await()).thenReturn(Response.success(boardGames))
            assertEquals(boardGames, (boardGamesRepository.getBoardGames() as Success).data)
        }
    }

    @Test
    fun `Get Board Games Fails`() {
        runBlocking {
            whenever(service.getBoardGames()).thenReturn(deferred)
            whenever(deferred.await()).thenReturn(Response.error(400, ResponseBody.create(null, "get board games failed")))
            assertTrue(boardGamesRepository.getBoardGames() is Error)
        }
    }

}