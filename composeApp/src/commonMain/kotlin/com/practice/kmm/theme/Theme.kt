package com.practice.kmm.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf

/**
 * Extended colors not covered by Material ColorScheme.
 * Access via LocalExtendedColors.current
 */
data class ExtendedColors(
    val cardOrangeStart: androidx.compose.ui.graphics.Color,
    val cardOrangeEnd: androidx.compose.ui.graphics.Color,
    val cardPurpleStart: androidx.compose.ui.graphics.Color,
    val cardPurpleEnd: androidx.compose.ui.graphics.Color,
    val promoPurple: androidx.compose.ui.graphics.Color,
    val promoPink: androidx.compose.ui.graphics.Color,
    val chipBackground: androidx.compose.ui.graphics.Color,
    val chipBorder: androidx.compose.ui.graphics.Color,
    val chipSelected: androidx.compose.ui.graphics.Color,
    val success: androidx.compose.ui.graphics.Color,
    val successBackground: androidx.compose.ui.graphics.Color,
    val rating: androidx.compose.ui.graphics.Color,
    val navSelected: androidx.compose.ui.graphics.Color,
    val navUnselected: androidx.compose.ui.graphics.Color,
    val freeShipping: androidx.compose.ui.graphics.Color,
    val priceText: androidx.compose.ui.graphics.Color
)

val LocalExtendedColors = staticCompositionLocalOf {
}

private val LightColorScheme = lightColorScheme(
    primary = primary,
    onPrimary = onPrimary
)

private val DarkColorScheme = darkColorScheme(
    primary = primary,
    onPrimary = onPrimary
)



val TravelLightColorScheme = lightColorScheme(
    primary = TravelTeal,
    onPrimary = Color.White,
    secondary = TravelOrange,
    onSecondary = Color.White,
    background = Color(0xFFF5F5F5),
    surface = Color.White,
    onSurface = TravelTextBlack
)

@Composable
fun TravelTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) {
        // For now using light scheme for travel as dark mode design isn't provided, 
        // but normally would have TravelDarkColorScheme
        TravelLightColorScheme 
    } else {
        TravelLightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = MaterialTheme.typography,
        content = content
    )
}
