package com.practice.kmm.modules.travel.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AcUnit
import androidx.compose.material.icons.filled.Deck
import androidx.compose.material.icons.filled.Fastfood
import androidx.compose.material.icons.filled.LocalFireDepartment
import androidx.compose.material.icons.filled.Pool
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.practice.kmm.models.travel.Trip
import com.practice.kmm.modules.travel.components.CategoryGrid
import com.practice.kmm.modules.travel.components.SectionHeader
import com.practice.kmm.modules.travel.components.TravelBottomBar
import com.practice.kmm.modules.travel.components.TravelSearchBar
import com.practice.kmm.modules.travel.components.mockCategories
import com.practice.kmm.theme.Dimensions
import com.practice.kmm.theme.TravelOrange
import com.practice.kmm.theme.TravelTextBlack
import com.practice.kmm.theme.TravelTextGray
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import practicekmm.composeapp.generated.resources.Res
import practicekmm.composeapp.generated.resources.*

@Composable
fun HomeScreen(
    onNavigate: (String) -> Unit
) {
    Scaffold(
        bottomBar = {
            TravelBottomBar(currentRoute = "home", onNavigate = onNavigate)
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(paddingValues)
        ) {
            // Header Image Box
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
            ) {
                 // Background Image (Mock)
                 Box(modifier = Modifier.fillMaxSize().background(Color.LightGray)) 
                 
                 Column(
                     modifier = Modifier
                        .align(Alignment.Center)
                        .padding(horizontal = Dimensions.Spacing.l)
                 ) {
                     TravelSearchBar(onClick = { /* Navigate to search */ })
                 }
            }
            
            // Content Container with rounded top overlap
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = Dimensions.Spacing.m) 
                    // In a real implementation we might offset this to overlap the image
                    .background(Color.White)
            ) {
                // Categories
                CategoryGrid(
                    categories = mockCategories,
                    modifier = Modifier.padding(horizontal = Dimensions.Spacing.m),
                    onCategoryClick = { item ->
                        when(item.title) {
                            "Flights" -> onNavigate("flight")
                            "Hotels" -> onNavigate("adventure") // Demo
                            else -> onNavigate("flight")
                        }
                    }
                )
                
                Spacer(modifier = Modifier.height(Dimensions.Spacing.l))
                
                // Personalized Trips
                SectionHeader(
                    title = stringResource(Res.string.travel_section_personalized),
                    onViewAllClick = { },
                    modifier = Modifier.padding(horizontal = Dimensions.Spacing.m)
                )
                
                Spacer(modifier = Modifier.height(Dimensions.Spacing.m))
                
                LazyRow(
                    contentPadding = PaddingValues(horizontal = Dimensions.Spacing.m),
                    horizontalArrangement = Arrangement.spacedBy(Dimensions.Spacing.m)
                ) {
                    items(mockTrips) { trip ->
                        TripCard(trip)
                    }
                }
                
                Spacer(modifier = Modifier.height(Dimensions.Spacing.l))
                
                // Discover your Interest
                SectionHeader(
                    title = stringResource(Res.string.travel_section_discover),
                    onViewAllClick = { },
                    modifier = Modifier.padding(horizontal = Dimensions.Spacing.m)
                )
                
                Spacer(modifier = Modifier.height(Dimensions.Spacing.m))
                
                LazyRow(
                    contentPadding = PaddingValues(horizontal = Dimensions.Spacing.m),
                    horizontalArrangement = Arrangement.spacedBy(Dimensions.Spacing.l)
                ) {
                    items(mockInterests) { interest ->
                        InterestItem(interest)
                    }
                }
                
                Spacer(modifier = Modifier.height(Dimensions.Spacing.xxl))
            }
        }
    }
}

// Local Component for Trip Card (Personalized Trips)
@Composable
fun TripCard(trip: Trip) {
    Column(
        modifier = Modifier.width(160.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .clip(RoundedCornerShape(Dimensions.UI.cornerRadius))
                .background(Color.LightGray)
        )
        Spacer(modifier = Modifier.height(Dimensions.Spacing.xs))
        Text(text = trip.title, style = androidx.compose.material3.MaterialTheme.typography.titleSmall, fontWeight = FontWeight.Bold, color = TravelTextBlack)
        Text(text = "$${trip.price.toInt()}", style = androidx.compose.material3.MaterialTheme.typography.bodySmall, color = TravelTextBlack)
    }
}

// Local Component for Interest Item
@Composable
fun InterestItem(interest: Interest) {
     Column(
         horizontalAlignment = Alignment.CenterHorizontally
     ) {
         Box(
             modifier = Modifier
                 .width(60.dp)
                 .height(60.dp)
                 .clip(androidx.compose.foundation.shape.CircleShape)
                 .background(Color.White)
                 // Border? or Shadow
         ) {
             Icon(
                 imageVector = interest.icon,
                 contentDescription = interest.title,
                 tint = TravelOrange,
                 modifier = Modifier.align(Alignment.Center)
             )
         }
         Spacer(modifier = Modifier.height(Dimensions.Spacing.xs))
         Text(text = interest.title, style = androidx.compose.material3.MaterialTheme.typography.bodySmall, color = TravelTextBlack, fontWeight = FontWeight.Medium)
     }
}

data class Interest(val title: String, val icon: ImageVector)

val mockTrips = listOf(
    Trip("1", "South India tour", "", 5.0, 100.0),
    Trip("2", "Royal Rajasthan", "", 4.5, 50.0)
)

val mockInterests = listOf(
    Interest("Trending", Icons.Default.LocalFireDepartment),
    Interest("Beach", Icons.Default.Deck),
    Interest("Food", Icons.Default.Fastfood),
    Interest("Pool", Icons.Default.Pool)
)

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen(onNavigate = {})
}