package com.roguekingapps.bgdb

class BoardGamesRepositoryImpl(private val service: BoardGamesService) : BoardGamesRepository {

    override suspend fun getBoardGames(): Response<List<String>> = service.getBoardGames().await()

}

interface BoardGamesRepository {

    suspend fun getBoardGames(): Response<List<String>>

}