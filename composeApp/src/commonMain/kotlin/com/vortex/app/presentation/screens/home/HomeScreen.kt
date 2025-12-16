package com.vortex.app.presentation.screens.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DividerDefaults.color
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Color
import com.vortex.app.presentation.components.GameCard
import org.koin.compose.koinInject

@Composable
fun HomeScreen(){
    val viewModel: HomeViewModel=koinInject()
    val state = viewModel.state
    LaunchedEffect(Unit){
        viewModel.loadGames()
    }
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

        if (state.isLoading) {
            CircularProgressIndicator()
        }

        else if (state.error != null) {
            Text(text = "Error: ${state.error}")
        }
        else {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(state.games) { game ->
                    GameCard(game = game)
                }
            }
        }
    }
}
