package com.roguekingapps.bgdb

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
