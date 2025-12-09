package com.practice.kmm.modules.travel.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.practice.kmm.theme.Dimensions
import com.practice.kmm.theme.TravelOrange
import com.practice.kmm.theme.TravelTeal
import com.practice.kmm.theme.TravelTextBlack

@Composable
fun TravelTabToggle(
    selectedIndex: Int,
    onTabSelected: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val tabs = listOf("Popular Destination", "Create your own")
    
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp)
            .border(1.dp, TravelTeal, RoundedCornerShape(Dimensions.UI.cornerRadiusSmall))
            .clip(RoundedCornerShape(Dimensions.UI.cornerRadiusSmall))
            .background(Color.White)
    ) {
        Row(modifier = Modifier.fillMaxSize()) {
            tabs.forEachIndexed { index, title ->
                val isSelected = selectedIndex == index
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .background(if (isSelected) TravelTeal else Color.Transparent)
                        .clickable { onTabSelected(index) },
                    contentAlignment = Alignment.Center
                ) {
                   Text(
                       text = title,
                       style = androidx.compose.material3.MaterialTheme.typography.bodyMedium,
                       fontWeight = FontWeight.Medium,
                       color = if (isSelected) Color.White else TravelTeal
                   )
                }
            }
        }
    }
}
