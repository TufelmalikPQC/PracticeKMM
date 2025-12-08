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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import com.practice.kmm.model.enums.TaskCategory
import com.practice.kmm.theme.Dimensions
import com.practice.kmm.theme.GradientPurpleEnd
import com.practice.kmm.theme.GradientPurpleStart
import com.practice.kmm.theme.Neutral200
import com.practice.kmm.theme.Neutral600

/**
 * Category chip for task category selection.
 *
 * @param category Task category
 * @param selected Whether the category is selected
 * @param onClick Click callback
 * @param modifier Modifier for the chip
 */
@Composable
fun CategoryChip(
    category: TaskCategory,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val gradient = Brush.horizontalGradient(
        colors = listOf(GradientPurpleStart, GradientPurpleEnd)
    )

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(Dimensions.cornerFull))
            .then(
                if (selected) {
                    Modifier.background(gradient)
                } else {
                    Modifier
                        .background(Color.Transparent)
                        .border(
                            width = Dimensions.spacing2,
                            color = Neutral200,
                            shape = RoundedCornerShape(Dimensions.cornerFull)
                        )
                }
            )
            .clickable { onClick() }
            .padding(
                horizontal = Dimensions.spacing20,
                vertical = Dimensions.spacing10
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = category.displayName,
            style = MaterialTheme.typography.labelLarge,
            color = if (selected) Color.White else Neutral600
        )
    }
}
