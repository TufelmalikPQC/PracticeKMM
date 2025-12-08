package com.practice.kmm.uiToolKit

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import com.practice.kmm.theme.Dimensions
import com.practice.kmm.theme.Neutral200
import com.practice.kmm.theme.Neutral700

/**
 * Filter chip component for tab-like filtering (e.g., My Tasks, In-progress, Completed).
 *
 * @param text Chip label
 * @param selected Whether the chip is selected
 * @param onClick Click callback
 * @param modifier Modifier for the chip
 */
@Composable
fun FilterChip(
    text: String,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val backgroundColor = if (selected) Color.White else Color.Transparent
    val borderColor = if (selected) Neutral200 else Neutral200
    val textColor = if (selected) Neutral700 else Neutral700

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(Dimensions.cornerFull))
            .background(backgroundColor)
            .border(
                width = Dimensions.spacing2,
                color = borderColor,
                shape = RoundedCornerShape(Dimensions.cornerFull)
            )
            .clickable { onClick() }
            .padding(
                horizontal = Dimensions.spacing16,
                vertical = Dimensions.spacing10
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.labelLarge,
            color = textColor
        )
    }
}
