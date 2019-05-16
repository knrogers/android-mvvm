package com.roguekingapps.bgdb

import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.FragmentActivity
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule(private val activity: FragmentActivity) {

    @Provides
    fun provideBoardGamesViewModel(repository: BoardGamesRepository): BoardGamesViewModel =
        ViewModelProviders
            .of(activity, BoardGamesViewModelFactory(repository))
            .get(BoardGamesViewModel::class.java)

}