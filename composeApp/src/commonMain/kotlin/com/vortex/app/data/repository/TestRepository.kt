package com.vortex.app.data.repository

import com.vortex.app.data.model.DogImage
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class TestRepository {
    private val client = HttpClient{
        install(ContentNegotiation) {
            json(Json { ignoreUnknownKeys = true })
        }
    }
    suspend fun getRandomDog() : String {
        val response: DogImage = client.get("https://dog.ceo/api/breeds/image/random").body()
        return response.message
    }
}
