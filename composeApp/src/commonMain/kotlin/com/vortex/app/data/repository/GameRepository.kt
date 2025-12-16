package com.vortex.app.data.repository

import com.vortex.app.data.model.GameList
import com.vortex.app.data.model.GameResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import com.vortex.app.BuildKonfig
import io.ktor.client.request.parameter

class GameRepository (

    private val client: HttpClient) {
    private val apiKey = BuildKonfig.RAWG_KEY
    suspend fun getGames(): List<GameList>{
        val apiUrl = "=$apiKey&page_size=10"
        val response: GameResponse = client.get("https://api.rawg.io/api/games")
        {
            parameter("key",apiKey)
            parameter("page_size",10)
        }.body()
        return response.results
    }
}