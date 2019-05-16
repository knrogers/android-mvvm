package com.roguekingapps.bgdb

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider

class BoardGamesViewModelFactory(private val repository: BoardGamesRepository) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = BoardGamesViewModel(repository) as T

}