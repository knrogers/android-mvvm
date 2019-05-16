package com.roguekingapps.bgdb

class BoardGamesRepositoryImpl(private val service: BoardGamesService) : BoardGamesRepository {

    override suspend fun getBoardGames(): ResponseResult<List<String>> = service.getBoardGames().toResponse()

}

interface BoardGamesRepository {

    suspend fun getBoardGames(): ResponseResult<List<String>>

}