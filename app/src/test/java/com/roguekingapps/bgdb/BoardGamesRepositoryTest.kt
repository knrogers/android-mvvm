package com.roguekingapps.bgdb

import com.roguekingapps.bgdb.Response.Success
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.mockito.MockitoAnnotations
import kotlin.test.assertEquals

class BoardGamesRepositoryTest {

    private val boardGamesRepository: BoardGamesRepository by lazy { BoardGamesRepositoryImpl(service) }

    @Mock
    lateinit var service: BoardGamesService

    @Mock
    lateinit var response: Deferred<Response<List<String>>>

    @Before
    fun setUp() = MockitoAnnotations.initMocks(this)

    @Test
    fun `Get board games succeeds`() {
        runBlocking {
            @Suppress("UNCHECKED_CAST") val success = mock(Success::class.java) as Success<List<String>>
            `when`(service.getBoardGames()).thenReturn(response)
            `when`(response.await()).thenReturn(success)
            assertEquals(success, boardGamesRepository.getBoardGames())
        }
    }

}