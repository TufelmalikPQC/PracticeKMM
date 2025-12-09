package com.practice.kmm.modules.travel.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.practice.kmm.theme.TravelOrange
import com.practice.kmm.theme.TravelTeal
import com.practice.kmm.theme.TravelTextGray
import org.jetbrains.compose.resources.stringResource
import practicekmm.composeapp.generated.resources.Res
import practicekmm.composeapp.generated.resources.travel_action_view_all
import practicekmm.composeapp.generated.resources.*

@Composable
fun TravelBottomBar(
    currentRoute: String?,
    onNavigate: (String) -> Unit
) {
    NavigationBar(
        containerColor = Color.White
    ) {
        // Home
        NavigationBarItem(
            selected = currentRoute == "home",
            onClick = { onNavigate("home") },
            icon = { Icon(Icons.Default.Home, contentDescription = null) },
            label = { Text("Home") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = TravelOrange,
                selectedTextColor = TravelOrange,
                unselectedIconColor = TravelTextGray,
                unselectedTextColor = TravelTextGray,
                indicatorColor = Color.Transparent
            )
        )
        // Notifications
        NavigationBarItem(
            selected = currentRoute == "notifications",
            onClick = { onNavigate("notifications") },
            icon = { Icon(Icons.Default.Notifications, contentDescription = null) },
            label = { Text("Notifications") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = TravelOrange,
                selectedTextColor = TravelOrange,
                unselectedIconColor = TravelTextGray,
                unselectedTextColor = TravelTextGray,
                indicatorColor = Color.Transparent
            )
        )
        // My Trips
        NavigationBarItem(
            selected = currentRoute == "adventure",
            onClick = { onNavigate("adventure") },
            icon = { Icon(Icons.Default.ShoppingBag, contentDescription = null) }, 
            label = { Text("My Trips") }, 
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = TravelOrange,
                selectedTextColor = TravelOrange,
                unselectedIconColor = TravelTextGray,
                unselectedTextColor = TravelTextGray,
                indicatorColor = Color.Transparent
            )
        )
        // Multi-city
        NavigationBarItem(
            selected = currentRoute == "flight",
            onClick = { onNavigate("flight") },
            icon = { Icon(Icons.Default.Search, contentDescription = null) },
            label = { Text("Multi-city") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = TravelOrange,
                selectedTextColor = TravelOrange,
                unselectedIconColor = TravelTextGray,
                unselectedTextColor = TravelTextGray,
                indicatorColor = Color.Transparent
            )
        )
        // Account
        NavigationBarItem(
            selected = currentRoute == "account",
            onClick = { onNavigate("account") },
            icon = { Icon(Icons.Default.AccountCircle, contentDescription = null) },
            label = { Text("Account") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = TravelOrange,
                selectedTextColor = TravelOrange,
                unselectedIconColor = TravelTextGray,
                unselectedTextColor = TravelTextGray,
                indicatorColor = Color.Transparent
            )
        )
    }
}

@org.jetbrains.compose.ui.tooling.preview.Preview
@Composable
private fun TravelBottomBarPreview() {
    com.practice.kmm.theme.TravelTheme {
        TravelBottomBar(currentRoute = "home", onNavigate = {})
    }
}
