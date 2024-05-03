package com.medial.app

import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.ui.Modifier
import com.medial.app.ui.MedialApp

fun AppCompatActivity.setUpMedialApp(
    modifier: Modifier = Modifier,
) {
    setContent {
        MedialApp(
            modifier = modifier,
            darkTheme = isSystemInDarkTheme(),
            isDynamicTheme = true
        )
    }

}