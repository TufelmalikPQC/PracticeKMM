# Dimensions Rules

> All `.dp`/`.sp` values must be in `theme/Dimens.kt`. Never hardcode in UI.

## Naming Convention (Material Design 3 - 8dp Grid)

| Group | Prefix | Scale (dp) | Based On |
|-------|--------|------------|----------|
| **Spacing** | `spacing` | `None(0)` `Xxs(4)` `Xs(8)` `Sm(12)` `Md(16)` `Lg(24)` `Xl(32)` `Xxl(48)` | 8dp grid |
| **Radius** | `corner` | `None(0)` `Xs(4)` `Sm(8)` `Md(12)` `Lg(16)` `Xl(28)` `Full(9999)` | M3 Shape |
| **Icon** | `icon` | `Xs(16)` `Sm(20)` `Md(24)` `Lg(40)` `Xl(48)` | M3 Icons |
| **Elevation** | `elevation` | `Level0(0)` `Level1(1)` `Level2(3)` `Level3(6)` `Level4(8)` `Level5(12)` | M3 Elevation |
| **Touch** | `touch` | `Min(48)` | Accessibility |
| **Stroke** | `stroke` | `Thin(1)` `Thick(2)` | M3 Outline |

### Typography (use `MaterialTheme.typography` - not raw sp)

| Token | Font Size (sp) | Line Height (sp) |
|-------|----------------|------------------|
| `displayLarge` | 57 | 64 |
| `displayMedium` | 45 | 52 |
| `displaySmall` | 36 | 44 |
| `headlineLarge` | 32 | 40 |
| `headlineMedium` | 28 | 36 |
| `headlineSmall` | 24 | 32 |
| `titleLarge` | 22 | 28 |
| `titleMedium` | 16 | 24 |
| `titleSmall` | 14 | 20 |
| `bodyLarge` | 16 | 24 |
| `bodyMedium` | 14 | 20 |
| `bodySmall` | 12 | 16 |
| `labelLarge` | 14 | 20 |
| `labelMedium` | 12 | 16 |
| `labelSmall` | 11 | 16 |

## Content-Aware Padding Rule

**Problem**: Icon (16dp) inside container with 24dp padding → icon looks too small.

**Formula**: `Effective Padding = Container Padding - Content Size`

```kotlin-example
// ❌ Wrong
Box(Modifier.padding(24.dp)) { Icon(size = 16.dp) }

// ✅ Correct: 24 - 16 = 8dp
Box(Modifier.padding(Dimens.paddingSm)) { Icon(size = Dimens.iconSm) }
```

## Usage

```kotlin
Modifier.padding(Dimens.paddingMd)
Spacer(Modifier.width(Dimens.spaceHMd))
RoundedCornerShape(Dimens.radiusMd)
Icon(modifier = Modifier.size(Dimens.iconMd))
Text(fontSize = Dimens.fontMd)
```
