package com.practice.kmm.modules.shop.navigation

import kotlinx.serialization.Serializable

/**
 * Type-safe navigation routes for the Shop feature.
 */
@Serializable
sealed class ShopRoutes {

    @Serializable
    data object Home : ShopRoutes()

    @Serializable
    data class ProductDetail(val productId: String) : ShopRoutes()

    @Serializable
    data class Checkout(val productId: String) : ShopRoutes()
}
