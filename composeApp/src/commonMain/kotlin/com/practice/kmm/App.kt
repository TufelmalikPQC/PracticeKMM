package com.practice.kmm

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.practice.kmm.modules.travel.ui.AdventureListScreen
import com.practice.kmm.modules.travel.ui.FlightSearchScreen
import com.practice.kmm.modules.travel.ui.HomeScreen
import com.practice.kmm.navigation.TravelRoutes
import com.practice.kmm.theme.TravelTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    TravelTheme {
        val navController = rememberNavController()
        
        NavHost(
            navController = navController,
            startDestination = TravelRoutes.HomeScreen
        ) {
            composable<TravelRoutes.HomeScreen> {
                HomeScreen(
                    onNavigate = { route ->
                        when(route) {
                            "flight" -> navController.navigate(TravelRoutes.FlightSearchScreen)
                            "adventure" -> navController.navigate(TravelRoutes.AdventureListScreen)
                            "home" -> navController.navigate(TravelRoutes.HomeScreen)
                            else -> { /* Handle others */ }
                        }
                    }
                )
            }
            
            composable<TravelRoutes.AdventureListScreen> {
                AdventureListScreen(
                    onNavigate = { route ->
                        if (route == "home") navController.navigate(TravelRoutes.HomeScreen)
                        // Add other nav
                    }
                )
            }
            
            composable<TravelRoutes.FlightSearchScreen> {
                FlightSearchScreen(
                    onNavigate = { route ->
                        if (route == "home") navController.navigate(TravelRoutes.HomeScreen)
                    }
                )
            }
        }
    }
}
