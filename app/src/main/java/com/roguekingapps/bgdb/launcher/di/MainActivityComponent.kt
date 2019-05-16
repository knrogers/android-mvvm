package com.roguekingapps.bgdb.launcher.di

import com.roguekingapps.bgdb.launcher.MainActivity
import com.roguekingapps.bgdb.common.di.ActivityScope
import com.roguekingapps.bgdb.boardgame.di.BoardGamesRepositoryModule
import com.roguekingapps.bgdb.boardgame.di.BoardGamesViewModelModule
import dagger.Component

@ActivityScope
@Component(
    modules = [
        MainActivityModule::class,
        BoardGamesViewModelModule::class,
        BoardGamesRepositoryModule::class
    ]
)
interface MainActivityComponent {

    fun inject(activity: MainActivity)

}
