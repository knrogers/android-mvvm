package com.roguekingapps.bgdb

import kotlinx.coroutines.Deferred

interface BoardGamesService {

    fun getBoardGames(): Deferred<Response<List<String>>>

}