package com.roguekingapps.bgdb

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class BoardGamesViewModel(
    private val scope: CoroutineScope = CoroutineScope(Dispatchers.IO)
) : ViewModel() {

    @Inject
    lateinit var boardGamesRepository: BoardGamesRepository

    private val _boardGames = MutableLiveData<ResponseResult<List<String>>>()
    val boardGames: LiveData<ResponseResult<List<String>>>
        get() = _boardGames

    init {
        DaggerBoardGamesViewModelComponent.builder()
            .boardGamesViewModelModule(BoardGamesViewModelModule())
            .build()
            .inject(this)
    }

    fun getBoardGames() = scope.launch { _boardGames.postValue(boardGamesRepository.getBoardGames()) }

}