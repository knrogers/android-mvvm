package com.roguekingapps.bgdb

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BoardGamesViewModel(
    private val boardGamesRepository: BoardGamesRepository,
    private val scope: CoroutineScope = CoroutineScope(Dispatchers.IO)
) : ViewModel() {

    private val _boardGames = MutableLiveData<ResponseResult<List<String>>>()
    val boardGames: LiveData<ResponseResult<List<String>>>
        get() = _boardGames

    fun getBoardGames() = scope.launch { _boardGames.postValue(boardGamesRepository.getBoardGames()) }

}