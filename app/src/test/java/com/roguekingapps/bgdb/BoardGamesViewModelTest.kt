package com.roguekingapps.bgdb

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import com.roguekingapps.bgdb.boardgame.network.BoardGames
import com.roguekingapps.bgdb.boardgame.network.BoardGamesRepository
import com.roguekingapps.bgdb.boardgame.network.ResponseResult.Success
import com.roguekingapps.bgdb.boardgame.viewmodel.BoardGamesViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test
import kotlin.test.assertEquals

class BoardGamesViewModelTest {

    private val viewModel: BoardGamesViewModel by lazy {
        BoardGamesViewModel(boardGamesRepository, CoroutineScope(Dispatchers.Unconfined))
    }

    private val boardGamesRepository = mock<BoardGamesRepository>()

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Test
    fun `Get Board Games Succeeds`() {
        runBlocking {
            val success = Success(mock<BoardGames>())
            whenever(boardGamesRepository.getBoardGames()).thenReturn(success)
            viewModel.getBoardGames()
            assertEquals(success, viewModel.boardGames.value)
        }
    }

}