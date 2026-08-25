---
name: bluestacks-adb
description: Automated testing, APK installation, logcat inspection, and screenshot verification on BlueStacks emulator on Windows.
---

# BlueStacks ADB Testing Workflow

## Tool Path
- BlueStacks Native ADB: `C:\Program Files\BlueStacks_nxt\HD-Adb.exe`
- Target Device: `emulator-5554` (or `127.0.0.1:5555`)

## Common Operations

### 1. Verify Connection & Device ABI
```powershell
& "C:\Program Files\BlueStacks_nxt\HD-Adb.exe" devices
& "C:\Program Files\BlueStacks_nxt\HD-Adb.exe" -s emulator-5554 shell getprop ro.product.cpu.abi
```

### 2. Install APK
```powershell
& "C:\Program Files\BlueStacks_nxt\HD-Adb.exe" -s emulator-5554 install -r "<path-to-apk>"
```

### 3. Launch App
```powershell
& "C:\Program Files\BlueStacks_nxt\HD-Adb.exe" -s emulator-5554 shell monkey -p <package-name> -c android.intent.category.LAUNCHER 1
```

### 4. Capture and Pull Screenshot
```powershell
& "C:\Program Files\BlueStacks_nxt\HD-Adb.exe" -s emulator-5554 shell screencap -p /sdcard/screen.png
& "C:\Program Files\BlueStacks_nxt\HD-Adb.exe" -s emulator-5554 pull /sdcard/screen.png "<destination-path>"
```
