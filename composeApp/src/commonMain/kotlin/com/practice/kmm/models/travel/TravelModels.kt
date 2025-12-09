package com.practice.kmm.models.travel

import androidx.compose.runtime.Immutable
import kotlinx.serialization.Serializable

@Immutable
@Serializable
data class Adventure(
    val id: String,
    val title: String,
    val imageUrl: String,
    val rating: Double,
    val reviewCount: Int,
    val price: Double,
    val duration: String,
    val isTrusted: Boolean = true
)

@Immutable
@Serializable
data class Flight(
    val id: String,
    val fromCode: String,
    val fromCity: String,
    val toCode: String,
    val toCity: String,
    val date: String
)

@Immutable
@Serializable
data class TravelCategory(
    val id: String,
    val title: String,
    val imageUrl: String
)

@Immutable
@Serializable
data class Trip(
    val id: String,
    val title: String,
    val imageUrl: String,
    val rating: Double,
    val price: Double
)
