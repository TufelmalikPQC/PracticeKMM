package com.practice.kmm.uiToolKit

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import com.practice.kmm.model.data.Project
import com.practice.kmm.theme.Dimensions
import com.practice.kmm.theme.Purple400
import com.practice.kmm.theme.Purple500
import com.practice.kmm.theme.Purple600
import kotlinx.datetime.Month

/**
 * Project card component for the horizontal carousel.
 *
 * @param project Project data
 * @param onClick Card click callback
 * @param modifier Modifier for the card
 */
@Composable
fun ProjectCard(
    project: Project,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val gradient = Brush.linearGradient(
        colors = listOf(Purple600, Purple500, Purple400)
    )

    Card(
        onClick = onClick,
        modifier = modifier
            .width(Dimensions.projectCardWidth)
            .height(Dimensions.projectCardHeight),
        shape = RoundedCornerShape(Dimensions.cornerLarge),
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = Dimensions.cardElevationHigh
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(gradient)
                .padding(Dimensions.spacing16)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                // Project header
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(Dimensions.spacing8)
                ) {
                    // Project icon
                    Box(
                        modifier = Modifier
                            .size(Dimensions.iconSizeLarge)
                            .clip(RoundedCornerShape(Dimensions.cornerSmall))
                            .background(Color.White.copy(alpha = 0.2f)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "💡",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                    Text(
                        text = project.name,
                        style = MaterialTheme.typography.labelMedium,
                        color = Color.White.copy(alpha = 0.8f)
                    )
                }

                // Project title
                Text(
                    text = project.title,
                    style = MaterialTheme.typography.headlineSmall,
                    color = Color.White
                )

                // Project date
                Text(
                    text = formatProjectDate(project.date.month, project.date.dayOfMonth, project.date.year),
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.White.copy(alpha = 0.7f)
                )
            }
        }
    }
}

private fun formatProjectDate(month: Month, day: Int, year: Int): String {
    val monthName = month.name.lowercase().replaceFirstChar { it.uppercase() }
    return "$monthName $day, $year"
}
