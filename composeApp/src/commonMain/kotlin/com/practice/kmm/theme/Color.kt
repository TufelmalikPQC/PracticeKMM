package com.practice.kmm.theme

import androidx.compose.ui.graphics.Color

// ═══════════════════════════════════════════════════════════
// PRIMITIVES (Base Palette)
// Naming: {ColorName}{Shade} (0=Lightest, 1000=Darkest)
// ═══════════════════════════════════════════════════════════

// Purple/Violet - Primary Brand Colors
val Purple50 = Color(0xFFF5F3FF)
val Purple100 = Color(0xFFEDE9FE)
val Purple200 = Color(0xFFDDD6FE)
val Purple300 = Color(0xFFC4B5FD)
val Purple400 = Color(0xFFA78BFA)
val Purple500 = Color(0xFF8B5CF6)
val Purple600 = Color(0xFF7C3AED)
val Purple700 = Color(0xFF6D28D9)
val Purple800 = Color(0xFF5B21B6)
val Purple900 = Color(0xFF4C1D95)

// Blue - Secondary/Accent Colors
val Blue50 = Color(0xFFEFF6FF)
val Blue100 = Color(0xFFDBEAFE)
val Blue400 = Color(0xFF60A5FA)
val Blue500 = Color(0xFF3B82F6)
val Blue600 = Color(0xFF2563EB)

// Neutral/Gray Colors
val Neutral0 = Color(0xFFFFFFFF)
val Neutral50 = Color(0xFFF8FAFC)
val Neutral100 = Color(0xFFF1F5F9)
val Neutral200 = Color(0xFFE2E8F0)
val Neutral300 = Color(0xFFCBD5E1)
val Neutral400 = Color(0xFF94A3B8)
val Neutral500 = Color(0xFF64748B)
val Neutral600 = Color(0xFF475569)
val Neutral700 = Color(0xFF334155)
val Neutral800 = Color(0xFF1E293B)
val Neutral900 = Color(0xFF0F172A)
val Neutral1000 = Color(0xFF000000)

// Status Colors
val Green400 = Color(0xFF4ADE80)
val Green500 = Color(0xFF22C55E)
val Red400 = Color(0xFFF87171)
val Red500 = Color(0xFFEF4444)
val Orange400 = Color(0xFFFBAF32)
val Orange500 = Color(0xFFF97316)

// ═══════════════════════════════════════════════════════════
// MATERIAL 3 LIGHT THEME MAPPING
// ═══════════════════════════════════════════════════════════

val md_theme_light_primary = Purple600
val md_theme_light_onPrimary = Neutral0
val md_theme_light_primaryContainer = Purple100
val md_theme_light_onPrimaryContainer = Purple900
val md_theme_light_secondary = Blue500
val md_theme_light_onSecondary = Neutral0
val md_theme_light_secondaryContainer = Blue100
val md_theme_light_onSecondaryContainer = Blue600
val md_theme_light_tertiary = Purple400
val md_theme_light_onTertiary = Neutral0
val md_theme_light_tertiaryContainer = Purple100
val md_theme_light_onTertiaryContainer = Purple800
val md_theme_light_error = Red500
val md_theme_light_onError = Neutral0
val md_theme_light_errorContainer = Color(0xFFFFDAD6)
val md_theme_light_onErrorContainer = Color(0xFF410002)
val md_theme_light_background = Neutral50
val md_theme_light_onBackground = Neutral900
val md_theme_light_surface = Neutral0
val md_theme_light_onSurface = Neutral900
val md_theme_light_surfaceVariant = Neutral100
val md_theme_light_onSurfaceVariant = Neutral600
val md_theme_light_outline = Neutral300
val md_theme_light_outlineVariant = Neutral200

// ═══════════════════════════════════════════════════════════
// MATERIAL 3 DARK THEME MAPPING
// ═══════════════════════════════════════════════════════════

val md_theme_dark_primary = Purple400
val md_theme_dark_onPrimary = Purple900
val md_theme_dark_primaryContainer = Purple700
val md_theme_dark_onPrimaryContainer = Purple100
val md_theme_dark_secondary = Blue400
val md_theme_dark_onSecondary = Blue600
val md_theme_dark_secondaryContainer = Blue600
val md_theme_dark_onSecondaryContainer = Blue100
val md_theme_dark_tertiary = Purple300
val md_theme_dark_onTertiary = Purple800
val md_theme_dark_tertiaryContainer = Purple700
val md_theme_dark_onTertiaryContainer = Purple100
val md_theme_dark_error = Red400
val md_theme_dark_onError = Color(0xFF690005)
val md_theme_dark_errorContainer = Color(0xFF93000A)
val md_theme_dark_onErrorContainer = Color(0xFFFFDAD6)
val md_theme_dark_background = Neutral900
val md_theme_dark_onBackground = Neutral100
val md_theme_dark_surface = Neutral800
val md_theme_dark_onSurface = Neutral100
val md_theme_dark_surfaceVariant = Neutral700
val md_theme_dark_onSurfaceVariant = Neutral300
val md_theme_dark_outline = Neutral500
val md_theme_dark_outlineVariant = Neutral600

// ═══════════════════════════════════════════════════════════
// GRADIENT COLORS (For cards and headers)
// ═══════════════════════════════════════════════════════════

val GradientPurpleStart = Purple600
val GradientPurpleMiddle = Purple500
val GradientPurpleEnd = Blue500
val GradientCardStart = Purple500
val GradientCardEnd = Purple400
