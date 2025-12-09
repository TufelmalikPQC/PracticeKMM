package com.practice.kmm.modules.travel.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DirectionsBus
import androidx.compose.material.icons.filled.Flight
import androidx.compose.material.icons.filled.Hotel
import androidx.compose.material.icons.filled.House
import androidx.compose.material.icons.filled.Train
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.practice.kmm.theme.Dimensions
import com.practice.kmm.theme.TravelOrange
import com.practice.kmm.theme.TravelTextBlack

data class CategoryItem(val title: String, val icon: ImageVector, val color: Color = TravelOrange)

@Composable
fun CategoryGrid(
    categories: List<CategoryItem>,
    modifier: Modifier = Modifier,
    onCategoryClick: (CategoryItem) -> Unit = {}
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        contentPadding = PaddingValues(Dimensions.Spacing.m),
        horizontalArrangement = Arrangement.spacedBy(Dimensions.Spacing.m),
        verticalArrangement = Arrangement.spacedBy(Dimensions.Spacing.m),
        modifier = modifier.height(200.dp) // Fixed height constraint
    ) {
        items(categories) { item ->
            CategoryCard(item, onClick = { onCategoryClick(item) })
        }
    }
}

@Composable
fun CategoryCard(item: CategoryItem, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(Dimensions.UI.cornerRadius),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Column(
            modifier = Modifier.padding(Dimensions.Spacing.m).fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = item.icon, 
                contentDescription = item.title,
                tint = item.color,
                modifier = Modifier.size(24.dp)
            )
            Text(
                text = item.title,
                style = androidx.compose.material3.MaterialTheme.typography.bodySmall,
                color = TravelTextBlack,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(top = Dimensions.Spacing.s)
            )
        }
    }
}

// Mock Data within file for Preview/Simple usage
val mockCategories = listOf(
    CategoryItem("Flights", Icons.Default.Flight),
    CategoryItem("Hotels", Icons.Default.Hotel),
    CategoryItem("Trains", Icons.Default.Train),
    CategoryItem("Buses", Icons.Default.DirectionsBus),
    CategoryItem("Cabs", Icons.Default.DirectionsBus), // Proxy
    CategoryItem("Stays", Icons.Default.House)
)
