package com.roguekingapps.bgdb

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData

class BoardGamesViewModel(private val boardGamesRepository: BoardGamesRepository) {

    private val _boardGames = MutableLiveData<List<String>>()
    val boardGames: LiveData<List<String>>
        get() = _boardGames

    fun getBoardGames() = _boardGames.postValue(boardGamesRepository.getBoardGames())

}