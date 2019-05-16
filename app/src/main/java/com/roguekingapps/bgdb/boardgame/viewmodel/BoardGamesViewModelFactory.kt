package com.roguekingapps.bgdb.boardgame.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.roguekingapps.bgdb.boardgame.network.BoardGamesRepository

class BoardGamesViewModelFactory(private val repository: BoardGamesRepository) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = BoardGamesViewModel(repository) as T

}