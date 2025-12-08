package com.practice.kmm.uiToolKit

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import com.practice.kmm.theme.Dimensions
import com.practice.kmm.theme.GradientPurpleEnd
import com.practice.kmm.theme.GradientPurpleStart

/**
 * Primary button with gradient background.
 *
 * @param text Button text
 * @param onClick Click callback
 * @param modifier Modifier for the button
 * @param enabled Whether the button is enabled
 */
@Composable
fun PrimaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    val gradientBrush = Brush.horizontalGradient(
        colors = listOf(GradientPurpleStart, GradientPurpleEnd)
    )

    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(Dimensions.buttonHeight),
        enabled = enabled,
        shape = RoundedCornerShape(Dimensions.cornerFull),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            contentColor = Color.White
        ),
        contentPadding = PaddingValues()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(Dimensions.buttonHeight)
                .background(
                    brush = if (enabled) gradientBrush else Brush.horizontalGradient(
                        colors = listOf(Color.Gray, Color.Gray)
                    ),
                    shape = RoundedCornerShape(Dimensions.cornerFull)
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = text,
                style = MaterialTheme.typography.titleMedium,
                color = Color.White
            )
        }
    }
}
