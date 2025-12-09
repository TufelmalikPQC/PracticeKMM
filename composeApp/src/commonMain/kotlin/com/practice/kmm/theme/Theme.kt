package com.practice.kmm.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
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
    ExtendedColors(
        cardOrangeStart = AppColors.cardOrangeStart,
        cardOrangeEnd = AppColors.cardOrangeEnd,
        cardPurpleStart = AppColors.cardPurpleStart,
        cardPurpleEnd = AppColors.cardPurpleEnd,
        promoPurple = AppColors.promoPurple,
        promoPink = AppColors.promoPink,
        chipBackground = AppColors.chipBackground,
        chipBorder = AppColors.chipBorder,
        chipSelected = AppColors.chipSelected,
        success = AppColors.success,
        successBackground = AppColors.successBackground,
        rating = AppColors.rating,
        navSelected = AppColors.navSelected,
        navUnselected = AppColors.navUnselected,
        freeShipping = AppColors.freeShipping,
        priceText = AppColors.priceText
    )
}

private val LightColorScheme = lightColorScheme(
    primary = AppColors.primary,
    onPrimary = AppColors.onPrimary,
    primaryContainer = AppColors.primaryContainer,
    onPrimaryContainer = AppColors.onPrimaryContainer,
    secondary = AppColors.secondary,
    onSecondary = AppColors.onSecondary,
    secondaryContainer = AppColors.secondaryContainer,
    onSecondaryContainer = AppColors.onSecondaryContainer,
    background = AppColors.background,
    onBackground = AppColors.onBackground,
    surface = AppColors.surface,
    onSurface = AppColors.onSurface,
    surfaceVariant = AppColors.surfaceVariant,
    onSurfaceVariant = AppColors.onSurfaceVariant,
    outline = AppColors.outline,
    outlineVariant = AppColors.outlineVariant,
    error = AppColors.error,
    onError = AppColors.onError
)

private val DarkColorScheme = darkColorScheme(
    primary = AppColors.primary,
    onPrimary = AppColors.onPrimary,
    primaryContainer = AppColors.primaryContainer,
    onPrimaryContainer = AppColors.onPrimaryContainer,
    secondary = AppColors.secondary,
    onSecondary = AppColors.onSecondary,
    background = AppColors.backgroundDark,
    onBackground = AppColors.onBackgroundDark,
    surface = AppColors.surfaceDark,
    onSurface = AppColors.onSurfaceDark,
    surfaceVariant = AppColors.surfaceVariantDark,
    onSurfaceVariant = AppColors.onSurfaceVariant,
    outline = AppColors.outline,
    error = AppColors.error,
    onError = AppColors.onError
)

/**
 * Main theme composable for the Shop app.
 */
@Composable
fun ShopTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    val extendedColors = ExtendedColors(
        cardOrangeStart = AppColors.cardOrangeStart,
        cardOrangeEnd = AppColors.cardOrangeEnd,
        cardPurpleStart = AppColors.cardPurpleStart,
        cardPurpleEnd = AppColors.cardPurpleEnd,
        promoPurple = AppColors.promoPurple,
        promoPink = AppColors.promoPink,
        chipBackground = AppColors.chipBackground,
        chipBorder = AppColors.chipBorder,
        chipSelected = AppColors.chipSelected,
        success = AppColors.success,
        successBackground = AppColors.successBackground,
        rating = AppColors.rating,
        navSelected = AppColors.navSelected,
        navUnselected = AppColors.navUnselected,
        freeShipping = AppColors.freeShipping,
        priceText = AppColors.priceText
    )

    CompositionLocalProvider(LocalExtendedColors provides extendedColors) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = AppTypography,
            content = content
        )
    }
}

/**
 * Extension property to access extended colors from MaterialTheme.
 */
object ShopTheme {
    val extendedColors: ExtendedColors
        @Composable
        get() = LocalExtendedColors.current
}
