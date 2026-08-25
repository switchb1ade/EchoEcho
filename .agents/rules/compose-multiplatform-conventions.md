---
description: Guidelines and guardrails for Compose Multiplatform projects and resource generation.
trigger: model_decision
---

# Compose Multiplatform Guardrails

1. **Resource Accessor Namespace**:
   - In Compose Multiplatform, `Res` class package is derived from `rootProject.name` in `settings.gradle.kts`.
   - Never change `rootProject.name` without synchronizing all `import <name>.composeapp.generated.resources.Res` imports.
   - For user-facing app renames, change `<string name="app_name">` in `strings.xml` / `app_name.xml`.

2. **Clean Working Tree**:
   - Always verify `.gitignore` excludes `/build` and `*.apk` before staging.
