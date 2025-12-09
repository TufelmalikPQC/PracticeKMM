package com.practice.kmm.navigation

import kotlinx.serialization.Serializable

sealed class TravelRoutes {
    @Serializable
    data object Graph : TravelRoutes()

    @Serializable
    data object HomeScreen : TravelRoutes()

    @Serializable
    data object AdventureListScreen : TravelRoutes()

    @Serializable
    data object FlightSearchScreen : TravelRoutes()
}
