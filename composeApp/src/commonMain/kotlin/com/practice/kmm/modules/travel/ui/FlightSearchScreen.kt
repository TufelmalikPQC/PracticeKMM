package com.practice.kmm.modules.travel.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import com.practice.kmm.modules.travel.viewModel.TravelViewModel
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.practice.kmm.models.travel.Flight
import com.practice.kmm.modules.travel.components.FlightCard
import com.practice.kmm.modules.travel.components.FlightTabRow
import com.practice.kmm.modules.travel.components.TravelBottomBar
import com.practice.kmm.modules.travel.components.TravelTabToggle
import com.practice.kmm.theme.Dimensions
import com.practice.kmm.theme.TravelTextBlack
import org.jetbrains.compose.resources.stringResource
import practicekmm.composeapp.generated.resources.Res
import practicekmm.composeapp.generated.resources.*

@Composable
fun FlightSearchScreen(
    onNavigate: (String) -> Unit
) {
    val viewModel: TravelViewModel = androidx.lifecycle.viewmodel.compose.viewModel { TravelViewModel() }
    val uiState by viewModel.uiState.collectAsState()
    val selectedTab = uiState.selectedAdventureTab // Re-using tab state or separate? separate in model.
    // Wait, TravelViewModel is shared? Usually specific VM per screen or Shared. 
    // Let's use same VM instance logic or new instance. 
    // For simplicity, new instance.
    val selectedTransportMode = uiState.selectedTransportMode

    Scaffold(
        bottomBar = {
            TravelBottomBar(currentRoute = "flight", onNavigate = onNavigate)
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = Dimensions.Spacing.m)
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.height(Dimensions.Spacing.m))
            
            // Toggle
            TravelTabToggle(
                selectedIndex = selectedTab, // Reuses adventure tab state for now or add flight specific tab state?
                // The design for flight screen has "Popular | Create" toggle too? 
                // Let's assume yes.
                onTabSelected = { viewModel.updateAdventureTab(it) }
            )
            
            Spacer(modifier = Modifier.height(Dimensions.Spacing.l))
            
            // Label
            Text(
                text = stringResource(Res.string.travel_label_choose_transport),
                style = androidx.compose.material3.MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = TravelTextBlack
            )
            
            Spacer(modifier = Modifier.height(Dimensions.Spacing.m))
            
            // Transport Tabs
            FlightTabRow(
                selectedTabIndex = selectedTransportMode,
                onTabSelected = { viewModel.updateTransportMode(it) }
            )
            
            Spacer(modifier = Modifier.height(Dimensions.Spacing.l))
            
            // Flights
            if (selectedTransportMode == 0) {
                 FlightCard(
                     flight = Flight("1", "DEL", "New Delhi, India", "GOI", "Goa, India", "9 jun 2023"),
                     title = "Flight 1"
                 )
                 FlightCard(
                     flight = Flight("2", "GOI", "Goa, India", "BOM", "Mumbai, India", "16 jun 2023"),
                     title = "Flight 2"
                 )
                 
                 Spacer(modifier = Modifier.height(Dimensions.Spacing.l))
                 
                 // Add Flight Button
                 Button(
                     onClick = {},
                     modifier = Modifier.fillMaxWidth().height(Dimensions.UI.buttonHeight),
                     colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                     shape = RoundedCornerShape(Dimensions.UI.cornerRadius),
                     border = androidx.compose.foundation.BorderStroke(1.dp, TravelTextBlack)
                 ) {
                     Text(stringResource(Res.string.travel_action_add_flight), color = TravelTextBlack)
                 }
            } else {
                Text("Content not implemented for other modes")
            }
            
            Spacer(modifier = Modifier.height(Dimensions.Spacing.xxl))
        }
    }
}
