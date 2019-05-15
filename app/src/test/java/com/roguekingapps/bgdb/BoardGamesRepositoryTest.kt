package com.roguekingapps.bgdb

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import kotlin.test.assertEquals

class BoardGamesRepositoryTest {

    private val boardGamesRepository: BoardGamesRepository by lazy { BoardGamesRepositoryImpl(service) }

    @Mock
    lateinit var service: BoardGamesService

    @Mock
    lateinit var response: Deferred<List<String>>

    @Before
    fun setUp() = MockitoAnnotations.initMocks(this)

    @Test
    fun `Get board games succeeds`() {
        runBlocking {
            val boardGames = arrayListOf("Eclipse", "Mage Knight")
            `when`(service.getBoardGames()).thenReturn(response)
            `when`(response.await()).thenReturn(boardGames)
            assertEquals(boardGames, boardGamesRepository.getBoardGames())
        }
    }

}