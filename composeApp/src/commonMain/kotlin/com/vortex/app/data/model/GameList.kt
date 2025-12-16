package com.vortex.app.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GameResponse(
    val results: List<GameList>
)
@Serializable
class GameList (
    val id: Int,
    val name: String,
    //val platforms: String,
    @SerialName("background_image")
    val backgroundImage: String?,
    val rating: Double?,
    val released: String?
)


