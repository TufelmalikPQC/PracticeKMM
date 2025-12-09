package com.practice.kmm.uiToolKit

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.practice.kmm.theme.ShopTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

/**
 * Category chip for filtering products.
 *
 * @param text Category label
 * @param isSelected Whether the chip is selected
 * @param onClick Callback when chip is clicked
 * @param modifier Modifier for the component
 */
@Composable
fun CategoryChip(
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val extendedColors = ShopTheme.extendedColors

    Surface(
        modifier = modifier.clickable(onClick = onClick),
        shape = RoundedCornerShape(20.dp),
        color = if (isSelected) {
            MaterialTheme.colorScheme.primary
        } else {
            extendedColors.chipBackground
        },
        border = if (!isSelected) {
            BorderStroke(1.dp, extendedColors.chipBorder)
        } else {
            null
        }
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.labelLarge,
            color = if (isSelected) {
                MaterialTheme.colorScheme.onPrimary
            } else {
                MaterialTheme.colorScheme.onSurface
            },
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp)
        )
    }
}

@Preview
@Composable
private fun CategoryChipPreview() {
    com.practice.kmm.theme.ShopTheme {
        CategoryChip(
            text = "Technology",
            isSelected = false,
            onClick = {}
        )
    }
}

@Preview
@Composable
private fun CategoryChipSelectedPreview() {
    com.practice.kmm.theme.ShopTheme {
        CategoryChip(
            text = "Technology",
            isSelected = true,
            onClick = {}
        )
    }
}
