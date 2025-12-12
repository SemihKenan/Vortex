package com.vortex.app

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform