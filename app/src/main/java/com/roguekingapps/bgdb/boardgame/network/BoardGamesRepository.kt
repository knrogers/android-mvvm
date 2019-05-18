package com.roguekingapps.bgdb.boardgame.network

class BoardGamesRepositoryImpl(private val service: BoardGamesService) : BoardGamesRepository {

    override suspend fun getBoardGames(): ResponseResult<String> = awaitResponse(service::getBoardGames)

}

interface BoardGamesRepository {

    suspend fun getBoardGames(): ResponseResult<String>

}