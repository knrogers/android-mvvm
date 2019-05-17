package com.roguekingapps.bgdb.launcher.di

import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.FragmentActivity
import com.roguekingapps.bgdb.boardgame.network.BoardGamesRepository
import com.roguekingapps.bgdb.boardgame.viewmodel.BoardGamesViewModel
import com.roguekingapps.bgdb.common.viewmodel.ViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule(private val activity: FragmentActivity) {

    @Provides
    fun provideBoardGamesViewModel(repository: BoardGamesRepository): BoardGamesViewModel =
        ViewModelProviders
            .of(activity, ViewModelFactory(BoardGamesViewModel(repository)))
            .get(BoardGamesViewModel::class.java)

}