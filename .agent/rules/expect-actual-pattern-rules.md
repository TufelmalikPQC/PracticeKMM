# Expect/Actual Pattern Rules

> **Why**: Proper abstraction of platform APIs.

## ✅ DO

- Declare `expect` in commonMain
- Implement `actual` for each platform
- Keep expect declarations minimal

## ❌ DON'T

- Don't skip platform implementations
- Don't add platform imports to commonMain
