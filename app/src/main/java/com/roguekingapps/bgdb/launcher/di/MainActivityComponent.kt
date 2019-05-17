package com.roguekingapps.bgdb.launcher.di

import com.roguekingapps.bgdb.boardgame.viewmodel.BoardGamesViewModel
import com.roguekingapps.bgdb.common.di.ActivityScope
import com.roguekingapps.bgdb.launcher.ui.MainActivity
import dagger.BindsInstance
import dagger.Component

@ActivityScope
@Component(modules = [MainActivityModule::class])
interface MainActivityComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance activity: MainActivity): MainActivityComponent
    }

    val viewModel: BoardGamesViewModel

}
