package com.vortex.app

import androidx.compose.material3.MaterialTheme
import com.vortex.app.presentation.screens.TestScreen
import androidx.compose.runtime.Composable
import com.vortex.app.di.appModule
import org.koin.compose.KoinApplication
@Composable
fun App() {
    KoinApplication(application = {
        modules(appModule)
    }) {
        MaterialTheme {
            TestScreen()
        }
    }
}