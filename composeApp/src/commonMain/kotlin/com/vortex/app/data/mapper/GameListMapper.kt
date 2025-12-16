package com.vortex.app.data.mapper

import com.vortex.app.data.model.GameList
import com.vortex.app.data.model.GameUiModel

fun GameList.toUiModel(): GameUiModel {
    return GameUiModel(
        id = this.id,
        title = this.name,
        image = this.backgroundImage,
        rating = "${this.rating ?: 0.0}/ 5.0",
        releaseDate = this.released?:"Unknown"
    )
}
fun List<GameList>.touiList(): List<GameUiModel>{
    return this.map { it.toUiModel() }
}