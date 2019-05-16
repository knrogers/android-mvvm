package com.roguekingapps.bgdb

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class BoardGamesRepositoryModule {

    @Provides
    fun provideBoardGamesService(): BoardGamesService =
        Retrofit.Builder()
            .baseUrl("https://www")
            .build()
            .create(BoardGamesService::class.java)

}