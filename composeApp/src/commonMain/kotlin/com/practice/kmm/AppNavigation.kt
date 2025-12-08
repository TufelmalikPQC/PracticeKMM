package com.practice.kmm

import kotlinx.serialization.Serializable

/**
 * Navigation routes for the app.
 * Using sealed class with @Serializable for type-safe navigation.
 */
@Serializable
sealed class Screen {
    @Serializable
    data object Home : Screen()

    @Serializable
    data object Calendar : Screen()

    @Serializable
    data object CreateTask : Screen()
}
