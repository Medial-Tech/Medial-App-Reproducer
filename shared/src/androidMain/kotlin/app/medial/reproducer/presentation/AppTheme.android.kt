package app.medial.reproducer.presentation

import android.os.Build
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
actual fun AppTheme(
    darkTheme: Boolean,
    dynamicColors: Boolean,
    content: @Composable () -> Unit
) {
    val context = LocalContext.current
    val isDynamicColorAvailable = dynamicColors && Build.VERSION.SDK_INT > Build.VERSION_CODES.S
    val colorScheme = when {
        isDynamicColorAvailable && darkTheme -> dynamicDarkColorScheme(context)
        isDynamicColorAvailable -> dynamicLightColorScheme(context)
        darkTheme -> darkColorScheme()
        else -> lightColorScheme()
    }

    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}