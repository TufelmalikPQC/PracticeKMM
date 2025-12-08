# Route Management Rules

> **Why**: Centralized routes prevent errors.

## ✅ DO

- Define all routes in `Routes` object
- Use constants for route names
- Use functions for routes with params

## ❌ DON'T

- Don't hardcode route strings in UI
- Don't scatter route definitions

## Example

```kotlin
object Routes {
    const val HOME = "home"
    fun profile(id: String) = "profile/$id"
}
```
