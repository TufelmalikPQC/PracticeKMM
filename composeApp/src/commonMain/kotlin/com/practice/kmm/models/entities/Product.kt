package com.practice.kmm.models.entities

/**
 * Represents a product in the shop.
 */
data class Product(
    val id: String,
    val name: String,
    val price: Double,
    val originalPrice: Double? = null,
    val imageUrl: String = "",
    val thumbnails: List<String> = emptyList(),
    val rating: Float = 0f,
    val reviewCount: Int = 0,
    val colors: List<Long> = emptyList(),
    val hasFreeShipping: Boolean = false,
    val category: String = ""
)
