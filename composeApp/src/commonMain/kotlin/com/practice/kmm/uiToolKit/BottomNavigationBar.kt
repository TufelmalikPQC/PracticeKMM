package com.practice.kmm.uiToolKit

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import com.practice.kmm.theme.Dimensions
import com.practice.kmm.theme.textSecondary
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource
import practicekmm.composeapp.generated.resources.Res
import practicekmm.composeapp.generated.resources.cd_calendar_icon
import practicekmm.composeapp.generated.resources.cd_home_icon
import practicekmm.composeapp.generated.resources.cd_notifications_icon
import practicekmm.composeapp.generated.resources.cd_search_nav_icon

/**
 * Navigation destinations for bottom navigation.
 */
enum class BottomNavDestination(
    val route: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val labelRes: StringResource
) {
    Home(
        route = "home",
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Outlined.Home,
        labelRes = Res.string.cd_home_icon
    ),
    Calendar(
        route = "calendar",
        selectedIcon = Icons.Filled.DateRange,
        unselectedIcon = Icons.Outlined.DateRange,
        labelRes = Res.string.cd_calendar_icon
    ),
    Notifications(
        route = "notifications",
        selectedIcon = Icons.Filled.Notifications,
        unselectedIcon = Icons.Outlined.Notifications,
        labelRes = Res.string.cd_notifications_icon
    ),
    Search(
        route = "search",
        selectedIcon = Icons.Filled.Search,
        unselectedIcon = Icons.Outlined.Search,
        labelRes = Res.string.cd_search_nav_icon
    )
}

/**
 * Bottom navigation bar component.
 *
 * @param currentDestination Current selected destination
 * @param onDestinationSelected Callback when destination is selected
 * @param modifier Modifier for the component
 */
@Composable
fun BottomNavigationBar(
    currentDestination: BottomNavDestination,
    onDestinationSelected: (BottomNavDestination) -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .height(Dimensions.bottomNavHeight),
        color = MaterialTheme.colorScheme.surface,
        shadowElevation = Dimensions.cardElevationHigh
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            BottomNavDestination.entries.forEach { destination ->
                val isSelected = currentDestination == destination
                val icon = if (isSelected) destination.selectedIcon else destination.unselectedIcon
                val tint = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.textSecondary

                IconButton(
                    onClick = { onDestinationSelected(destination) }
                ) {
                    Icon(
                        imageVector = icon,
                        contentDescription = stringResource(destination.labelRes),
                        tint = tint,
                        modifier = Modifier.size(Dimensions.iconSizeMedium)
                    )
                }
            }
        }
    }
}
