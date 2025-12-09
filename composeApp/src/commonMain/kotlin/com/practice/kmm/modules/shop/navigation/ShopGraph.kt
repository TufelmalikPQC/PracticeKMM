package com.practice.kmm.modules.shop.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.practice.kmm.modules.shop.ui.CheckoutScreen
import com.practice.kmm.modules.shop.ui.ProductDetailScreen
import com.practice.kmm.modules.shop.ui.ShopHomeScreen
import com.practice.kmm.uiToolKit.BottomNavTab

/**
 * Navigation graph for the Shop feature.
 *
 * @param navController Navigation controller
 */
fun NavGraphBuilder.shopGraph(navController: NavController) {

    composable<ShopRoutes.Home> {
        ShopHomeScreen(
            onProductClick = { productId ->
                navController.navigate(ShopRoutes.ProductDetail(productId))
            },
            onTabSelected = { tab ->
                // Handle bottom nav tab selection
                when (tab) {
                    BottomNavTab.HOME -> { /* Already on home */ }
                    BottomNavTab.CART -> { /* Navigate to cart */ }
                    BottomNavTab.WISHLIST -> { /* Navigate to wishlist */ }
                    BottomNavTab.PROFILE -> { /* Navigate to profile */ }
                }
            }
        )
    }

    composable<ShopRoutes.ProductDetail> { backStackEntry ->
        val route = backStackEntry.toRoute<ShopRoutes.ProductDetail>()
        ProductDetailScreen(
            productId = route.productId,
            onNavigateBack = {
                navController.popBackStack()
            },
            onBuyNow = {
                navController.navigate(ShopRoutes.Checkout(route.productId))
            },
            onAddToCart = {
                // Add to cart logic
            }
        )
    }

    composable<ShopRoutes.Checkout> { backStackEntry ->
        val route = backStackEntry.toRoute<ShopRoutes.Checkout>()
        CheckoutScreen(
            productId = route.productId,
            onNavigateBack = {
                navController.popBackStack()
            },
            onFinalizePurchase = {
                // Handle purchase finalization
                // Navigate to success screen or back to home
                navController.navigate(ShopRoutes.Home) {
                    popUpTo(ShopRoutes.Home) { inclusive = true }
                }
            }
        )
    }
}