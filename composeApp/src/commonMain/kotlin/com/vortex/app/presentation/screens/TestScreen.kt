package com.vortex.app.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.vortex.app.data.repository.TestRepository
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import org.koin.compose.koinInject

@Composable
fun TestScreen() {
    val repo: TestRepository = koinInject()
    var imageUrl by remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        try {
            imageUrl = repo.getRandomDog()
        } catch (e: Exception) {
            println("Error: ${e.message}")
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

            Text("Test Success")
            Spacer(modifier = Modifier.height(20.dp))
            KamelImage(
                resource = asyncPainterResource(imageUrl),
                contentDescription = "Dog Image",
                modifier = Modifier.size(250.dp),
                onLoading = {CircularProgressIndicator()},
                onFailure = {exception ->
                    Text("Image Error: ${exception.message}")
                    println("Kamel Error ${exception.message}" )})
    }
}