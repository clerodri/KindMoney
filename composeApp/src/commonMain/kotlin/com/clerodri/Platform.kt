package com.clerodri

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform