package app.medial.reproducer.presentation

import androidx.compose.runtime.Composable

@Composable
expect fun AppTheme(
    darkTheme:Boolean = false,
    dynamicColors: Boolean = false,
    content: @Composable () -> Unit
)