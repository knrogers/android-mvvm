package com.roguekingapps.bgdb.ui.boardgame

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.roguekingapps.bgdb.data.BoardGames
import com.roguekingapps.bgdb.data.BoardGamesRepository
import com.roguekingapps.bgdb.data.ResponseResult
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BoardGamesViewModel(
    private val boardGamesRepository: BoardGamesRepository,
    private val scope: CoroutineScope = CoroutineScope(Dispatchers.IO)
) : ViewModel() {

    private val _boardGames = MutableLiveData<ResponseResult<BoardGames>>()
    val boardGames: LiveData<ResponseResult<BoardGames>>
        get() = _boardGames

    fun getBoardGames() = scope.launch { _boardGames.postValue(boardGamesRepository.getBoardGames()) }

}