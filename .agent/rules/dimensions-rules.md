# Dimensions Rules

> **Why**: Centralized dimensions ensure consistency and easy updates.

## ✅ DO

- Create `Dimensions.kt` in `theme/`
- Define all dp/sp values there
- Use dimensions from file

## ❌ DON'T

- Don't hardcode `.dp` or `.sp` in UI

## Dimensions.kt

```kotlin
object Dimens {
    // Padding
    val paddingXs = 4.dp
    val paddingSm = 8.dp
    val paddingMd = 16.dp
    val paddingLg = 24.dp
    
    // Radius
    val radiusSm = 4.dp
    val radiusMd = 8.dp
    val radiusLg = 16.dp
    
    // Font sizes
    val fontSm = 12.sp
    val fontMd = 16.sp
    val fontLg = 24.sp
    
    // Touch target
    val minTouchTarget = 48.dp
}
```

## Usage

```kotlin
// ✅ Correct
Modifier.padding(Dimens.paddingMd)
Text(fontSize = Dimens.fontMd)

// ❌ Wrong
Modifier.padding(16.dp)
Text(fontSize = 16.sp)
```
