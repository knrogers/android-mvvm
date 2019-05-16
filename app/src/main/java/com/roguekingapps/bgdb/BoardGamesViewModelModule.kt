package com.roguekingapps.bgdb

import dagger.Module
import dagger.Provides

@Module
class BoardGamesViewModelModule {

    @Provides
    fun provideBoardGamesRepository(service: BoardGamesService): BoardGamesRepository =
        BoardGamesRepositoryImpl(service)

}