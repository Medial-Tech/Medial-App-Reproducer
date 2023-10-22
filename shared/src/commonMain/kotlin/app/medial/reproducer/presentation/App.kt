package app.medial.reproducer.presentation

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import app.medial.reproducer.presentation.auth.AuthScreen

@Composable
fun App(
    darkTheme: Boolean = false,
    dynamicColor: Boolean = false
) {
    AppTheme(
        darkTheme = darkTheme,
        dynamicColors = dynamicColor
    ) {
        Surface(
            color = MaterialTheme.colorScheme.background,
        ) {
            AuthScreen.Content()
        }
    }
}
