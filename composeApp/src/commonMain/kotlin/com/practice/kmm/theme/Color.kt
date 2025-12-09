package com.practice.kmm.theme

import androidx.compose.ui.graphics.Color

/**
 * E-Commerce App Color Palette
 * All colors defined here and accessed via MaterialTheme.colorScheme
 */
object AppColors {
    // Primary (Orange accent from designs)
    val primary = Color(0xFFFF6B00)
    val onPrimary = Color(0xFFFFFFFF)
    val primaryContainer = Color(0xFFFFE0CC)
    val onPrimaryContainer = Color(0xFF331500)

    // Secondary
    val secondary = Color(0xFF1A1A1A)
    val onSecondary = Color(0xFFFFFFFF)
    val secondaryContainer = Color(0xFF2D2D2D)
    val onSecondaryContainer = Color(0xFFE0E0E0)

    // Background & Surface
    val background = Color(0xFFFFFFFF)
    val onBackground = Color(0xFF1A1A1A)
    val surface = Color(0xFFFFFFFF)
    val onSurface = Color(0xFF1A1A1A)
    val surfaceVariant = Color(0xFFF5F5F5)
    val onSurfaceVariant = Color(0xFF666666)

    // Outline
    val outline = Color(0xFFE0E0E0)
    val outlineVariant = Color(0xFFF0F0F0)

    // Error
    val error = Color(0xFFEF4444)
    val onError = Color(0xFFFFFFFF)

    // ---- Custom App Colors ----

    // Gradient Colors for Payment Cards
    val cardOrangeStart = Color(0xFFFC7B54)
    val cardOrangeEnd = Color(0xFFFF9472)
    val cardPurpleStart = Color(0xFF7B61FF)
    val cardPurpleEnd = Color(0xFF9B8AFF)

    // Promo Banner Gradient
    val promoPurple = Color(0xFFA855F7)
    val promoPink = Color(0xFFD946EF)

    // Category Chips
    val chipBackground = Color(0xFFF5F5F5)
    val chipBorder = Color(0xFFE0E0E0)
    val chipSelected = Color(0xFFFF6B00)

    // Status Colors
    val success = Color(0xFF22C55E)
    val successBackground = Color(0xFFDCFCE7)
    val rating = Color(0xFFF59E0B)

    // Navigation
    val navSelected = Color(0xFFFF6B00)
    val navUnselected = Color(0xFF9E9E9E)

    // Product Card
    val freeShipping = Color(0xFFFF6B00)
    val priceText = Color(0xFFFF6B00)

    // Dark Theme Colors
    val backgroundDark = Color(0xFF121212)
    val onBackgroundDark = Color(0xFFE0E0E0)
    val surfaceDark = Color(0xFF1E1E1E)
    val onSurfaceDark = Color(0xFFE0E0E0)
    val surfaceVariantDark = Color(0xFF2D2D2D)
}
