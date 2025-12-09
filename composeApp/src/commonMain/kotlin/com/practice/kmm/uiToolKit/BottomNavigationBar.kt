package com.practice.kmm.uiToolKit

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.practice.kmm.theme.ShopTheme
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import practicekmm.composeapp.generated.resources.Res
import practicekmm.composeapp.generated.resources.nav_cart
import practicekmm.composeapp.generated.resources.nav_home
import practicekmm.composeapp.generated.resources.nav_profile
import practicekmm.composeapp.generated.resources.nav_wishlist

/**
 * Bottom navigation tabs.
 */
enum class BottomNavTab {
    HOME, CART, WISHLIST, PROFILE
}

/**
 * Bottom navigation bar for the shop.
 *
 * @param selectedTab Currently selected tab
 * @param onTabSelected Callback when tab is selected
 * @param modifier Modifier for the component
 */
@Composable
fun ShopBottomNavigationBar(
    selectedTab: BottomNavTab,
    onTabSelected: (BottomNavTab) -> Unit,
    modifier: Modifier = Modifier
) {
    val extendedColors = ShopTheme.extendedColors

    NavigationBar(
        modifier = modifier
            .fillMaxWidth()
            .height(80.dp),
        containerColor = MaterialTheme.colorScheme.surface,
        tonalElevation = 8.dp
    ) {
        NavigationBarItem(
            selected = selectedTab == BottomNavTab.HOME,
            onClick = { onTabSelected(BottomNavTab.HOME) },
            icon = {
                Icon(
                    imageVector = if (selectedTab == BottomNavTab.HOME) Icons.Filled.Home else Icons.Outlined.Home,
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
            },
            label = {
                Text(
                    text = stringResource(Res.string.nav_home),
                    style = MaterialTheme.typography.labelSmall
                )
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = extendedColors.navSelected,
                selectedTextColor = extendedColors.navSelected,
                unselectedIconColor = extendedColors.navUnselected,
                unselectedTextColor = extendedColors.navUnselected,
                indicatorColor = MaterialTheme.colorScheme.surface
            )
        )

        NavigationBarItem(
            selected = selectedTab == BottomNavTab.CART,
            onClick = { onTabSelected(BottomNavTab.CART) },
            icon = {
                Icon(
                    imageVector = if (selectedTab == BottomNavTab.CART) Icons.Filled.ShoppingCart else Icons.Outlined.ShoppingCart,
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
            },
            label = {
                Text(
                    text = stringResource(Res.string.nav_cart),
                    style = MaterialTheme.typography.labelSmall
                )
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = extendedColors.navSelected,
                selectedTextColor = extendedColors.navSelected,
                unselectedIconColor = extendedColors.navUnselected,
                unselectedTextColor = extendedColors.navUnselected,
                indicatorColor = MaterialTheme.colorScheme.surface
            )
        )

        NavigationBarItem(
            selected = selectedTab == BottomNavTab.WISHLIST,
            onClick = { onTabSelected(BottomNavTab.WISHLIST) },
            icon = {
                Icon(
                    imageVector = if (selectedTab == BottomNavTab.WISHLIST) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
            },
            label = {
                Text(
                    text = stringResource(Res.string.nav_wishlist),
                    style = MaterialTheme.typography.labelSmall
                )
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = extendedColors.navSelected,
                selectedTextColor = extendedColors.navSelected,
                unselectedIconColor = extendedColors.navUnselected,
                unselectedTextColor = extendedColors.navUnselected,
                indicatorColor = MaterialTheme.colorScheme.surface
            )
        )

        NavigationBarItem(
            selected = selectedTab == BottomNavTab.PROFILE,
            onClick = { onTabSelected(BottomNavTab.PROFILE) },
            icon = {
                Icon(
                    imageVector = if (selectedTab == BottomNavTab.PROFILE) Icons.Filled.Person else Icons.Outlined.Person,
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
            },
            label = {
                Text(
                    text = stringResource(Res.string.nav_profile),
                    style = MaterialTheme.typography.labelSmall
                )
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = extendedColors.navSelected,
                selectedTextColor = extendedColors.navSelected,
                unselectedIconColor = extendedColors.navUnselected,
                unselectedTextColor = extendedColors.navUnselected,
                indicatorColor = MaterialTheme.colorScheme.surface
            )
        )
    }
}

@Preview
@Composable
private fun ShopBottomNavigationBarPreview() {
    ShopTheme {
        ShopBottomNavigationBar(
            selectedTab = BottomNavTab.HOME,
            onTabSelected = {}
        )
    }
}
