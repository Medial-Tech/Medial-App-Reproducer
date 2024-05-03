package com.medial.app.ui.core.theme

import android.os.Build
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
actual fun MedialTheme(
    darkTheme: Boolean,
    dynamicColors: Boolean,
    content: @Composable () -> Unit
) {

    val context = LocalContext.current
    val isDynamicColorAvailable = dynamicColors && Build.VERSION.SDK_INT > Build.VERSION_CODES.S
    val colorScheme = when {
        isDynamicColorAvailable && darkTheme -> {
            dynamicDarkColorScheme(context).let {
                it.copy(
                    surface = it.background.copy(),
                    onBackground = it.onBackground.copy(alpha = 0.8f)
                )
            }
        }
        isDynamicColorAvailable -> dynamicLightColorScheme(context)
        darkTheme -> DarkColors
        else -> LightColors
    }

    MaterialTheme(
        colorScheme = colorScheme,
        content = content,
        typography = MedialTypography()
    )
}