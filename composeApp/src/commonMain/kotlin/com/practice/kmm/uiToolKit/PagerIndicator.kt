package com.practice.kmm.uiToolKit

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.practice.kmm.theme.ShopTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

/**
 * Page indicator dots for carousels and pagers.
 *
 * @param pageCount Total number of pages
 * @param currentPage Currently selected page (0-indexed)
 * @param modifier Modifier for the component
 * @param indicatorSize Size of each indicator dot
 * @param spacing Spacing between dots
 */
@Composable
fun PagerIndicator(
    pageCount: Int,
    currentPage: Int,
    modifier: Modifier = Modifier,
    indicatorSize: Dp = 8.dp,
    spacing: Dp = 8.dp
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(spacing)
    ) {
        repeat(pageCount) { index ->
            Box(
                modifier = Modifier
                    .size(
                        width = if (index == currentPage) indicatorSize * 2.5f else indicatorSize,
                        height = indicatorSize
                    )
                    .clip(CircleShape)
                    .background(
                        if (index == currentPage) {
                            MaterialTheme.colorScheme.primary
                        } else {
                            MaterialTheme.colorScheme.outlineVariant
                        }
                    )
            )
        }
    }
}

@Preview
@Composable
private fun PagerIndicatorPreview() {
    ShopTheme {
        PagerIndicator(
            pageCount = 4,
            currentPage = 0
        )
    }
}
