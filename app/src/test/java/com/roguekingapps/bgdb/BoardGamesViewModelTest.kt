package com.roguekingapps.bgdb

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.roguekingapps.bgdb.boardgame.network.BoardGamesRepository
import com.roguekingapps.bgdb.boardgame.network.ResponseResult.Success
import com.roguekingapps.bgdb.boardgame.viewmodel.BoardGamesViewModel
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
    fun `Get Board Games Succeeds`() {
        runBlocking {
            val success = Success("get board games successful")
            `when`(boardGamesRepository.getBoardGames()).thenReturn(success)
            viewModel.getBoardGames()
            assertEquals(success, viewModel.boardGames.value)
        }
    }

}