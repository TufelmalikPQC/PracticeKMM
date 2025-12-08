package com.practice.kmm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform