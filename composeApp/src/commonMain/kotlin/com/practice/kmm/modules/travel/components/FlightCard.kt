package com.practice.kmm.modules.travel.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Flight
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.SwapVert
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.practice.kmm.models.travel.Flight
import com.practice.kmm.theme.Dimensions
import com.practice.kmm.theme.TravelTeal
import com.practice.kmm.theme.TravelTextBlack
import com.practice.kmm.theme.TravelTextGray
import org.jetbrains.compose.resources.stringResource
import practicekmm.composeapp.generated.resources.Res
import practicekmm.composeapp.generated.resources.travel_label_depart

@Composable
fun FlightCard(
    flight: Flight,
    modifier: Modifier = Modifier,
    title: String = "Flight 1"
) {
    Card(
        modifier = modifier.fillMaxWidth().padding(bottom = Dimensions.Spacing.m),
        shape = RoundedCornerShape(Dimensions.UI.cornerRadius),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.5.dp)
    ) {
        Column(modifier = Modifier.padding(Dimensions.Spacing.m)) {
            // Header
            Text(
                text = title,
                style = androidx.compose.material3.MaterialTheme.typography.bodyLarge,
                color = TravelTextGray
            )
            Spacer(modifier = Modifier.height(Dimensions.Spacing.m))
            Divider(color = Color.LightGray, thickness = 0.5.dp)
            Spacer(modifier = Modifier.height(Dimensions.Spacing.m))

            // Route Section
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Route Column with Dotted Line Effect (Simulated)
                Row(verticalAlignment = Alignment.Top) {
                     Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.height(80.dp), verticalArrangement = Arrangement.SpaceBetween) {
                         Icon(Icons.Default.Flight, contentDescription = null, tint = TravelTeal, modifier = Modifier.rotate(90f).size(24.dp))
                         // Dotted Line Placeholder
                         Box(modifier = Modifier.width(1.dp).weight(1f).background(TravelTeal)) // Solid for now, dash needs Canvas
                         Icon(Icons.Default.LocationOn, contentDescription = null, tint = TravelTeal, modifier = Modifier.size(24.dp))
                     }
                     Spacer(modifier = Modifier.width(Dimensions.Spacing.m))
                     Column(modifier = Modifier.height(80.dp), verticalArrangement = Arrangement.SpaceBetween) {
                         Column {
                             Text(flight.fromCode, fontWeight = FontWeight.Bold, style = androidx.compose.material3.MaterialTheme.typography.titleMedium)
                             Text(flight.fromCity, style = androidx.compose.material3.MaterialTheme.typography.bodySmall, color = TravelTextGray)
                         }
                         Column {
                             Text(flight.toCode, fontWeight = FontWeight.Bold, style = androidx.compose.material3.MaterialTheme.typography.titleMedium)
                             Text(flight.toCity, style = androidx.compose.material3.MaterialTheme.typography.bodySmall, color = TravelTextGray)
                         }
                     }
                }
                
                // Swap Button
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .background(TravelTeal, shape = CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(Icons.Default.SwapVert, contentDescription = null, tint = Color.White)
                }
            }
            
            Spacer(modifier = Modifier.height(Dimensions.Spacing.m))
            Divider(color = Color.LightGray, thickness = 0.5.dp)
            Spacer(modifier = Modifier.height(Dimensions.Spacing.m))
            
            // Depart Date
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    Icons.Default.DateRange, 
                    contentDescription = null, 
                    tint = TravelTeal,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(Dimensions.Spacing.m))
                Column {
                    Text(
                        stringResource(Res.string.travel_label_depart), 
                        style = androidx.compose.material3.MaterialTheme.typography.bodySmall, 
                        color = TravelTextGray
                    )
                     Text(
                        flight.date, 
                        style = androidx.compose.material3.MaterialTheme.typography.bodyMedium, 
                        fontWeight = FontWeight.SemiBold,
                         color = TravelTextBlack
                    )
                }
            }
        }
    }
}

@org.jetbrains.compose.ui.tooling.preview.Preview
@Composable
private fun FlightCardPreview() {
    com.practice.kmm.theme.TravelTheme {
        FlightCard(
            flight = com.practice.kmm.models.travel.Flight("1", "DEL", "New Delhi", "MUM", "Mumbai", "01 Jan"),
            title = "Flight 1"
        )
    }
}
