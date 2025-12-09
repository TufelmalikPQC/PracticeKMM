package com.practice.kmm

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.practice.kmm.modules.shop.navigation.ShopRoutes
import com.practice.kmm.modules.shop.navigation.shopGraph
import com.practice.kmm.theme.ShopTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

/**
 * Main App composable with navigation setup.
 * Entry point for the application UI.
 */
@Composable
@Preview
fun App() {
    ShopTheme {
        val navController = rememberNavController()

        NavHost(
            navController = navController,
            startDestination = ShopRoutes.Home,
            modifier = Modifier.fillMaxSize()
        ) {
            shopGraph(navController)
        }
    }
}
