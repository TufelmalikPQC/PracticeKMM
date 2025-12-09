package com.practice.kmm.modules.travel.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.practice.kmm.models.travel.Adventure
import com.practice.kmm.theme.Dimensions
import com.practice.kmm.theme.TravelOrange
import com.practice.kmm.theme.TravelTeal
import com.practice.kmm.theme.TravelTextBlack
import com.practice.kmm.theme.TravelTextGray
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import practicekmm.composeapp.generated.resources.Res
import practicekmm.composeapp.generated.resources.travel_action_book_now

@Composable
fun AdventureCard(
    adventure: Adventure,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(Dimensions.UI.cornerRadius),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(Dimensions.Spacing.m)
        ) {
            // Image Area (Collage Mock)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(RoundedCornerShape(Dimensions.UI.cornerRadius))
            ) {
                // Mock Grid: Main Image Left (60%), Two small Right (40%)
                Row(modifier = Modifier.fillMaxSize()) {
                    Box(modifier = Modifier.weight(0.6f).fillMaxHeight().background(Color.Gray))
                    Spacer(modifier = Modifier.width(2.dp))
                    Column(modifier = Modifier.weight(0.4f).fillMaxHeight()) {
                         Box(modifier = Modifier.weight(1f).fillMaxWidth().background(Color.LightGray))
                         Spacer(modifier = Modifier.height(2.dp))
                         Box(modifier = Modifier.weight(1f).fillMaxWidth().background(Color.DarkGray)) {
                             // Overlay +Count
                             Box(modifier = Modifier.fillMaxSize().background(Color.Black.copy(alpha=0.3f)), contentAlignment = Alignment.Center) {
                                  Text("+40", color = Color.White, fontWeight = FontWeight.Bold)
                             }
                         }
                    }
                }
                
                // Heart Icon
                IconButton(
                     onClick = {},
                     modifier = Modifier.align(Alignment.TopStart).padding(8.dp)
                ) {
                     Icon(Icons.Default.FavoriteBorder, contentDescription = "Favorite", tint = Color.White)
                }
            }
            
            Spacer(modifier = Modifier.height(Dimensions.Spacing.s))
            
            // Info Row 1: Rating | Price Label
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    repeat(5) {
                        Icon(Icons.Default.Star, contentDescription = null, tint = TravelTeal, modifier = Modifier.size(12.dp))
                    }
                    Text(
                        text = " • Very good ${adventure.reviewCount} Reviews",
                        style = androidx.compose.material3.MaterialTheme.typography.labelSmall,
                        color = TravelTextGray,
                        modifier = Modifier.padding(start = 4.dp)
                    )
                }
                
                Text(
                     text = "Starting at $${adventure.price}",
                     style = androidx.compose.material3.MaterialTheme.typography.titleSmall,
                     fontWeight = FontWeight.Bold,
                     color = TravelTextBlack
                )
            }
            
            Spacer(modifier = Modifier.height(4.dp))
            
            // Info Row 2: Title | Duration Badge
            Row(
                 modifier = Modifier.fillMaxWidth(),
                 horizontalArrangement = Arrangement.SpaceBetween,
                 verticalAlignment = Alignment.CenterVertically
            ) {
                 Row(verticalAlignment = Alignment.CenterVertically) {
                     Icon(Icons.Default.LocationOn, contentDescription = null, tint = TravelTextGray, modifier = Modifier.size(16.dp))
                     Text(
                        text = adventure.title,
                        style = androidx.compose.material3.MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = TravelTextBlack
                     )
                 }
                 
                 Box(
                     modifier = Modifier
                        .border(1.dp, Color.LightGray, RoundedCornerShape(50))
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                 ) {
                     Text(adventure.duration, style = androidx.compose.material3.MaterialTheme.typography.labelSmall, color = TravelTextBlack)
                 }
            }
            
            Spacer(modifier = Modifier.height(Dimensions.Spacing.m))
            
            // Footer: Book Button | Trusted Partner
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(containerColor = TravelOrange),
                    shape = RoundedCornerShape(Dimensions.UI.cornerRadiusSmall),
                    modifier = Modifier.height(36.dp)
                ) {
                    Text(stringResource(Res.string.travel_action_book_now), color = Color.White, style = androidx.compose.material3.MaterialTheme.typography.labelMedium)
                }
                
                Row(verticalAlignment = Alignment.CenterVertically) {
                     // Trusted Icon (Mock)
                     Icon(Icons.Default.Star, contentDescription = null, tint = TravelTextGray, modifier = Modifier.size(14.dp))
                     Text(" Trusted Partner", style = androidx.compose.material3.MaterialTheme.typography.labelSmall, color = TravelTextGray)
                }
            }
        }
    }
}

@org.jetbrains.compose.ui.tooling.preview.Preview
@Composable
private fun AdventureCardPreview() {
    com.practice.kmm.theme.TravelTheme {
        AdventureCard(
            adventure = com.practice.kmm.models.travel.Adventure(
                id = "1", title = "Delhi Tour", imageUrl = "", rating = 4.5, reviewCount = 100, price = 50.0, duration = "2 days"
            )
        )
    }
}
