package com.roguekingapps.bgdb

import android.arch.core.executor.testing.InstantTaskExecutorRule
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import kotlin.test.assertEquals

class BoardGamesViewModelTest {

    private val viewModel: BoardGamesViewModel by lazy {
        BoardGamesViewModel(boardGamesRepository, CoroutineScope(Dispatchers.Unconfined))
    }

    @Mock
    lateinit var boardGamesRepository: BoardGamesRepository

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Before
    fun setUp() = MockitoAnnotations.initMocks(this)

    @Test
    fun `Get board games succeeds`() {
        runBlocking {
            val boardGames = arrayListOf("Eclipse", "Mage Knight")
            `when`(boardGamesRepository.getBoardGames()).thenReturn(boardGames)
            viewModel.getBoardGames()
            assertEquals(boardGames, viewModel.boardGames.value)
        }
    }

}