package com.practice.kmm.uiToolKit

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.practice.kmm.theme.ShopTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

/**
 * Color selector for product variants.
 *
 * @param colors List of color values (as Long, e.g., 0xFF000000)
 * @param selectedIndex Currently selected color index
 * @param onColorSelected Callback when color is selected
 * @param modifier Modifier for the component
 */
@Composable
fun ColorSelector(
    colors: List<Long>,
    selectedIndex: Int,
    onColorSelected: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        colors.forEachIndexed { index, colorValue ->
            ColorDot(
                color = Color(colorValue),
                isSelected = index == selectedIndex,
                onClick = { onColorSelected(index) }
            )
        }
    }
}

@Composable
private fun ColorDot(
    color: Color,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(32.dp)
            .clip(CircleShape)
            .then(
                if (isSelected) {
                    Modifier.border(
                        width = 2.dp,
                        color = MaterialTheme.colorScheme.onSurface,
                        shape = CircleShape
                    )
                } else {
                    Modifier
                }
            )
            .clickable(onClick = onClick)
    ) {
        Box(
            modifier = Modifier
                .size(if (isSelected) 24.dp else 32.dp)
                .clip(CircleShape)
                .background(color)
                .align(androidx.compose.ui.Alignment.Center)
        )
    }
}

@Preview
@Composable
private fun ColorSelectorPreview() {
    ShopTheme {
        ColorSelector(
            colors = listOf(0xFF1E3A5F, 0xFFE5DDD3, 0xFFB8B8B8),
            selectedIndex = 0,
            onColorSelected = {}
        )
    }
}
