package com.practice.kmm.modules.travel.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.practice.kmm.theme.Dimensions
import com.practice.kmm.theme.TravelOrange
import com.practice.kmm.theme.TravelTextBlack
import com.practice.kmm.theme.TravelTextGray

@Composable
fun FlightTabRow(
    selectedTabIndex: Int,
    onTabSelected: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val tabs = listOf("Flight", "Trains", "Buses", "Cabs")

    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        tabs.forEachIndexed { index, title ->
            val isSelected = selectedTabIndex == index
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .clickable { onTabSelected(index) }
                    .padding(vertical = Dimensions.Spacing.s)
                    .weight(1f) // Distribute space evenly
            ) {
                Text(
                    text = title,
                    style = if (isSelected) androidx.compose.material3.MaterialTheme.typography.titleMedium else androidx.compose.material3.MaterialTheme.typography.bodyMedium,
                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                    color = if (isSelected) TravelTextBlack else TravelTextGray
                )
                Spacer(modifier = Modifier.height(8.dp))
                if (isSelected) {
                    Divider(
                        color = TravelTextBlack,
                        thickness = 2.dp,
                        modifier = Modifier.width(24.dp)
                    )
                } else {
                    Spacer(modifier = Modifier.height(2.dp)) // Placeholder to prevent jump
                }
            }
        }
    }
}
