package com.vortex.app.di

import com.vortex.app.data.repository.TestRepository
import org.koin.dsl.module

val appModule = module {
    single{ TestRepository() }
    }
