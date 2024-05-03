package com.medial.app.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.medial.app.ui.core.theme.MedialTheme

/**
 * Starting point of the Compose Multiplatform UI
 */
@Composable
fun MedialApp(
    modifier: Modifier = Modifier,
    darkTheme: Boolean,
    isDynamicTheme: Boolean
) {
    MedialTheme(
        darkTheme = darkTheme,
        dynamicColors = isDynamicTheme
    ) {
        Surface(
            color = MaterialTheme.colorScheme.background,
            modifier = modifier
        ) {
            Scaffold(
                modifier = Modifier.fillMaxSize()
            ) { innerPadding ->
                Box(
                    modifier = Modifier.fillMaxSize().padding(innerPadding),
                    contentAlignment = Alignment.Center
                ) {

                    Text("Hello Kotlin Multiplatform!")
                }
            }
        }
    }
}
