package com.roguekingapps.bgdb.di

import com.roguekingapps.bgdb.data.BoardGamesRepository
import com.roguekingapps.bgdb.data.BoardGamesRepositoryImpl
import com.roguekingapps.bgdb.data.BoardGamesService
import dagger.Module
import dagger.Provides

@Module(includes = [BoardGamesServiceModule::class])
object BoardGamesRepositoryModule {

    @Provides
    @JvmStatic
    fun provideBoardGamesRepository(service: BoardGamesService): BoardGamesRepository =
        BoardGamesRepositoryImpl(service)

}