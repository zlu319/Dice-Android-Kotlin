# Dice-Android-Kotlin

This repository has been moved to GitLab: [https://gitlab.com/zlu319/Dice-Android-Kotlin](https://gitlab.com/zlu319/Dice-Android-Kotlin)
## Description

The program is an interactive Dice Roller App that support Login Functionality to sync dice rolls to an external Firebase Real-Time Database.
When the user is not logged in, the dice roller simply displays the dice roll, while keeping an invisible tally of dice rolls since App Launch. Once the user decides to log in, the results are synced to the online Database upon the next dice roll. (Logging Into the Dice Roll Viewer companion app with the same account allows real-time viewing of dice rolls; helpful when one is playing a Socially-Distant online board Game with a friend) A “clear” button allows the user to clear history both locally and from the Database. Upon logout, the results of the rolls are saved until the next sync.

Based off [this app example](https://developer.android.com/codelabs/basic-android-kotlin-training-create-dice-roller-in-kotlin#0)

## Repository URLs and Download Links:

### Repository URL:

https://github.com/michael-land/Dice-Android-Kotlin

### Download Instructions:
There is an APK download here at GitHub Releases:

https://github.com/michael-land/Dice-Android-Kotlin/releases/tag/v1.0

Sideload the APK file onto your android device. (Should work with Android 5.0 and above; tested to work on Android 8.0 Oreo and Android 11 Nougat.)

Once you do, you can login with your email using the buttons in the App. Note that you must remember your password!

### Backend URL:
https://console.firebase.google.com/project/dicerolltracker/database/dicerolltracker-default-rtdb/data
Please send us your Gmail address so we can grant you access! Or simply enjoy using our app!

## Companion App:

https://github.com/danieljnchen/DiceRollReader

This is the Application developed by my partner Daniel Chen. It reads and displays the Dice Roll results from the same firebase repository once you log into his app with the same account.

