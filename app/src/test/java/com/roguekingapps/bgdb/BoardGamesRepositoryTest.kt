package com.roguekingapps.bgdb

import com.roguekingapps.bgdb.boardgame.network.BoardGamesRepository
import com.roguekingapps.bgdb.boardgame.network.BoardGamesRepositoryImpl
import com.roguekingapps.bgdb.boardgame.network.BoardGamesService
import com.roguekingapps.bgdb.boardgame.network.ResponseResult.Error
import com.roguekingapps.bgdb.boardgame.network.ResponseResult.Success
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.runBlocking
import okhttp3.ResponseBody
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import retrofit2.Response
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class BoardGamesRepositoryTest {

    private val boardGamesRepository: BoardGamesRepository by lazy { BoardGamesRepositoryImpl(service) }

    @Mock
    lateinit var service: BoardGamesService

    @Mock
    lateinit var deferred: Deferred<Response<String>>

    @Before
    fun setUp() = MockitoAnnotations.initMocks(this)

    @Test
    fun `Get Board Games Succeeds`() {
        runBlocking {
            val boardGames = "Eclipse, Mage Knight"
            `when`(service.getBoardGames()).thenReturn(deferred)
            `when`(deferred.await()).thenReturn(Response.success(boardGames))
            assertEquals(boardGames, (boardGamesRepository.getBoardGames() as Success).data)
        }
    }

    @Test
    fun `Get Board Games Fails`() {
        runBlocking {
            `when`(service.getBoardGames()).thenReturn(deferred)
            `when`(deferred.await()).thenReturn(Response.error(400, ResponseBody.create(null, "get board games failed")))
            assertTrue(boardGamesRepository.getBoardGames() is Error)
        }
    }

}