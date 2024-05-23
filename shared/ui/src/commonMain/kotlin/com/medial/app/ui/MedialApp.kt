package com.medial.app.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredHeightIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
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
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {

                Text("Hello Kotlin Multiplatform", style = MaterialTheme.typography.titleMedium)
            }
        }
    }
}
