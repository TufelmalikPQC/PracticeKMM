package com.practice.kmm

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.practice.kmm.modules.travel.ui.AdventureListScreen
import com.practice.kmm.modules.travel.ui.FlightSearchScreen
import com.practice.kmm.modules.travel.ui.HomeScreen
import com.practice.kmm.theme.TravelTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun PreviewScreen() {
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        HomeScreen(onNavigate = {})
        AdventureListScreen(onNavigate = {})
        FlightSearchScreen(onNavigate = {})
    }
}

@Preview
@Composable
private fun AllPreviewsPreview() {
    TravelTheme {
        PreviewScreen()
    }
}
