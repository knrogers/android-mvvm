package com.roguekingapps.bgdb

class BoardGamesRepositoryImpl(private val service: BoardGamesService) : BoardGamesRepository {

    override suspend fun getBoardGames(): List<String> {
        return service.getBoardGames().await()
    }

}

interface BoardGamesRepository {

    suspend fun getBoardGames(): List<String>

}