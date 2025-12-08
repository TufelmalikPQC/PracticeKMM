---
trigger: always_on
---

# String Naming Rules

> [Official Reference](https://developer.android.com/guide/topics/resources/string-resource)

> [!CAUTION]
> **NEVER use hardcoded strings.** All user-facing text MUST come from `strings.xml`.

## Prefix Convention

| Prefix | Usage | Example |
|--------|-------|---------|
| `action_` | Buttons, clickable actions | `action_submit` |
| `str_` | General text | `str_welcome_message` |
| `title_` | Screen/section titles | `title_home` |
| `msg_` | User messages | `msg_success` |
| `error_` | Error messages | `error_network` |
| `hint_` | Input hints | `hint_enter_email` |
| `label_` | UI labels | `label_username` |
| `cd_` | Content descriptions | `cd_menu_icon` |

## Core Rules
- Use **snake_case** for names
- **No duplicates** – reuse same string resource
- **Purpose-based** names, not location-based

## Quick Example
```xml
<string name="action_login">Login</string>
<string name="title_home">Home</string>
<string name="error_network">Network error</string>
<string name="cd_back_button">Navigate back</string>
```

## Usage in Compose
```kotlin
Text(stringResource(R.string.title_home))
Icon(Icons.Default.Menu, contentDescription = stringResource(R.string.cd_menu_icon))
```

## ❌ DON'T
```xml
<string name="login">Login</string>           <!-- No prefix -->
<string name="home_screen_title">Home</string> <!-- Location-based -->
```

## ✅ DO
```xml
<string name="action_login">Login</string>
<string name="title_home">Home</string>
```

## Formatting & Plurals
```xml
<string name="msg_welcome">Welcome, %1$s!</string>
<plurals name="msg_items"><item quantity="one">%d item</item></plurals>
```
