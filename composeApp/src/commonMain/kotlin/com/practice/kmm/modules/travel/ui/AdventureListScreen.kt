package com.practice.kmm.modules.travel.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import com.practice.kmm.modules.travel.viewModel.TravelViewModel
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.practice.kmm.models.travel.Adventure
import com.practice.kmm.modules.travel.components.AdventureCard
import com.practice.kmm.modules.travel.components.TravelBottomBar
import com.practice.kmm.modules.travel.components.TravelSearchBar
import com.practice.kmm.modules.travel.components.TravelTabToggle
import com.practice.kmm.theme.Dimensions

@Composable
fun AdventureListScreen(
    onNavigate: (String) -> Unit
) {
    val viewModel: TravelViewModel = androidx.lifecycle.viewmodel.compose.viewModel { TravelViewModel() }
    val uiState by viewModel.uiState.collectAsState()
    val selectedTab = uiState.selectedAdventureTab

    Scaffold(
        bottomBar = {
            TravelBottomBar(currentRoute = "adventure", onNavigate = onNavigate)
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = Dimensions.Spacing.m)
        ) {
            Spacer(modifier = Modifier.height(Dimensions.Spacing.m))
            
            // Search
            TravelSearchBar(onClick = {})
            
            Spacer(modifier = Modifier.height(Dimensions.Spacing.m))
            
            // Toggle
            TravelTabToggle(
                selectedIndex = selectedTab,
                onTabSelected = { viewModel.updateAdventureTab(it) }
            )
            
            Spacer(modifier = Modifier.height(Dimensions.Spacing.m))
            
            // Content
            if (selectedTab == 0) {
                 LazyColumn {
                     items(mockAdventures) { adventure ->
                         AdventureCard(adventure = adventure)
                         Spacer(modifier = Modifier.height(Dimensions.Spacing.m))
                     }
                 }
            } else {
                // "Create your own" content - Placeholder
            }
        }
    }
}

val mockAdventures = listOf(
    Adventure(
        id = "1",
        title = "Delhi-UP Tour",
        imageUrl = "",
        rating = 4.5,
        reviewCount = 200,
        price = 40.7,
        duration = "2 days tour"
    ),
    Adventure(
        id = "2",
        title = "Delhi-UP Tour",
        imageUrl = "",
        rating = 4.5,
        reviewCount = 200,
        price = 40.7,
        duration = "2 days tour"
    )
)
