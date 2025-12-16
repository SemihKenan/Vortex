package com.vortex.app.presentation.screens.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.vortex.app.data.mapper.toUiModel
import com.vortex.app.data.model.GameList
import com.vortex.app.data.model.GameUiModel
import com.vortex.app.data.repository.GameRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

data class HomeUiState(
    val isLoading: Boolean = false,
    val games: List<GameUiModel> = emptyList(),
    val error: String? = null
)
class HomeViewModel(private val repository: GameRepository){
    var state by mutableStateOf(HomeUiState())
        private set
    fun loadGames(){
        CoroutineScope(Dispatchers.Main).launch {
            state = state.copy(isLoading = true, error= null)
            try {
                val result = repository.getGames()

                val uiData = result.map { it.toUiModel() } //Mapper

                state = state.copy(games = uiData, isLoading = false)
            } catch (e: Exception){
                state=state.copy(error = e.message, isLoading = false)
                println("ERROR: ${e.message}")
            }

        }
    }
}