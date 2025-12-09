package com.practice.kmm.modules.travel.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.practice.kmm.theme.Dimensions
import com.practice.kmm.theme.TravelTextGray
import org.jetbrains.compose.resources.stringResource
import practicekmm.composeapp.generated.resources.Res
import practicekmm.composeapp.generated.resources.travel_hint_search

@Composable
fun TravelSearchBar(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(Dimensions.UI.cornerRadius))
            .background(Color.White)
            .padding(horizontal = Dimensions.Spacing.m, vertical = Dimensions.Spacing.m)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null,
                tint = TravelTextGray
            )
            Text(
                text = stringResource(Res.string.travel_hint_search),
                style = androidx.compose.material3.MaterialTheme.typography.bodyMedium,
                color = TravelTextGray,
                modifier = Modifier.padding(start = Dimensions.Spacing.s)
            )
        }
    }
}
