package com.roguekingapps.bgdb

import android.arch.core.executor.testing.InstantTaskExecutorRule
import com.roguekingapps.bgdb.Response.Success
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
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
            @Suppress("UNCHECKED_CAST") val success = mock(Success::class.java) as Success<List<String>>
            `when`(boardGamesRepository.getBoardGames()).thenReturn(success)
            viewModel.getBoardGames()
            assertEquals(success, viewModel.boardGames.value)
        }
    }

}