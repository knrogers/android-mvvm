package com.roguekingapps.bgdb

import com.roguekingapps.bgdb.ResponseResult.Error
import com.roguekingapps.bgdb.ResponseResult.Success
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.runBlocking
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
    lateinit var deferred: Deferred<Response<List<String>>>

    @Before
    fun setUp() = MockitoAnnotations.initMocks(this)

    @Test
    fun `Get board games succeeds`() {
        runBlocking {
            val boardGames = arrayListOf("Eclipse", "Mage Knight")
            `when`(service.getBoardGames()).thenReturn(deferred)
            `when`(deferred.await()).thenReturn(Response.success(boardGames))
            assertEquals(boardGames, (boardGamesRepository.getBoardGames() as Success).data)
        }
    }

    @Test
    fun `Get board games fails`() {
        runBlocking {
            `when`(service.getBoardGames()).thenReturn(deferred)
            `when`(deferred.toResponse()).thenReturn(Error())
            assertTrue(boardGamesRepository.getBoardGames() is Error)
        }
    }

}