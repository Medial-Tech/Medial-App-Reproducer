package com.medial.app.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuBoxScope
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.medial.app.ui.core.theme.MedialTheme

/**
 * Starting point of the Compose Multiplatform UI
 */
@OptIn(ExperimentalMaterial3Api::class)
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

                Button(
                    onClick = { throw Exception("Testing Crash")}
                ){
                    Text(text = "Crash")
                }
            }
        }
    }
}