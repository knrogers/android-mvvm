package com.roguekingapps.bgdb

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class BoardGamesViewModelModule {

    @Provides
    fun provideBoardGamesService(): BoardGamesService =
        Retrofit.Builder()
            .baseUrl("https://www")
            .build()
            .create(BoardGamesService::class.java)

    @Provides
    @ViewModelScope
    fun provideBoardGamesRepository(service: BoardGamesService): BoardGamesRepository =
        BoardGamesRepositoryImpl(service)

}