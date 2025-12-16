package com.vortex.app

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.vortex.app.di.appModule
import com.vortex.app.presentation.screens.home.HomeScreen
import org.koin.compose.KoinApplication
@Composable
fun App() {
    KoinApplication(application = {
        modules(appModule)
    }) {
        MaterialTheme {
            HomeScreen()
        }
    }
}