package app.medial.reproducer.presentation

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
actual fun AppTheme(
    darkTheme: Boolean,
    dynamicColors: Boolean,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        content = content,
    )
}