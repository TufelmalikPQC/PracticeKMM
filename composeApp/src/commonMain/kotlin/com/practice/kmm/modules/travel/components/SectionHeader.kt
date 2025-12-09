package com.practice.kmm.modules.travel.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.practice.kmm.theme.TravelTeal
import com.practice.kmm.theme.TravelTextBlack
import org.jetbrains.compose.resources.stringResource
import practicekmm.composeapp.generated.resources.Res
import practicekmm.composeapp.generated.resources.travel_action_view_all

@Composable
fun SectionHeader(
    title: String,
    onViewAllClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            style = androidx.compose.material3.MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = TravelTextBlack
        )
        Row(
            modifier = Modifier.clickable(onClick = onViewAllClick),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(Res.string.travel_action_view_all),
                style = androidx.compose.material3.MaterialTheme.typography.bodyMedium,
                color = TravelTeal
            )
        }
    }
}
