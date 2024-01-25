package app.medial.reproducer.presentation

import Test
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

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
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {

                Test.Content()
            }
        }
    }
}
