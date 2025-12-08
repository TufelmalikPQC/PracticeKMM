package com.practice.kmm.uiToolKit

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import com.practice.kmm.model.data.Task
import com.practice.kmm.theme.Dimensions
import com.practice.kmm.theme.GradientPurpleEnd
import com.practice.kmm.theme.GradientPurpleStart
import com.practice.kmm.theme.textSecondary
import org.jetbrains.compose.resources.stringResource
import practicekmm.composeapp.generated.resources.Res
import practicekmm.composeapp.generated.resources.cd_more_options
import practicekmm.composeapp.generated.resources.label_days_ago

/**
 * Task card component showing task info with gradient icon and menu.
 *
 * @param task Task data
 * @param onClick Click callback for the entire card
 * @param onMenuClick Menu button click callback
 * @param modifier Modifier for the card
 */
@Composable
fun TaskCard(
    task: Task,
    onClick: () -> Unit,
    onMenuClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val gradient = Brush.horizontalGradient(
        colors = listOf(GradientPurpleStart, GradientPurpleEnd)
    )

    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick() },
        shape = RoundedCornerShape(Dimensions.cornerMedium),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = Dimensions.cardElevation
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(Dimensions.spacing16),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(Dimensions.spacing12)
        ) {
            // Task icon with gradient background
            Box(
                modifier = Modifier
                    .size(Dimensions.taskCardIconSize)
                    .clip(RoundedCornerShape(Dimensions.cornerSmall))
                    .background(gradient),
                contentAlignment = Alignment.Center
            ) {
                // Calendar/task icon emoji
                Text(
                    text = "📋",
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.White
                )
            }

            // Task info
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(Dimensions.spacing4)
            ) {
                Text(
                    text = task.name,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = stringResource(Res.string.label_days_ago, 2),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.textSecondary
                )
            }

            // Menu button
            IconButton(onClick = onMenuClick) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = stringResource(Res.string.cd_more_options),
                    tint = MaterialTheme.colorScheme.textSecondary
                )
            }
        }
    }
}
