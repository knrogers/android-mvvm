package com.roguekingapps.bgdb.launcher.di

import android.arch.lifecycle.ViewModelProviders
import com.roguekingapps.bgdb.boardgame.di.BoardGamesViewModelModule
import com.roguekingapps.bgdb.boardgame.network.BoardGamesRepository
import com.roguekingapps.bgdb.boardgame.viewmodel.BoardGamesViewModel
import com.roguekingapps.bgdb.common.viewmodel.ViewModelFactory
import com.roguekingapps.bgdb.launcher.ui.MainActivity
import dagger.Module
import dagger.Provides

@Module(includes = [BoardGamesViewModelModule::class])
object MainActivityModule {

    @Provides
    @JvmStatic
    fun provideBoardGamesViewModel(activity: MainActivity, repository: BoardGamesRepository): BoardGamesViewModel =
        ViewModelProviders
            .of(activity, ViewModelFactory(BoardGamesViewModel(repository)))
            .get(BoardGamesViewModel::class.java)

}