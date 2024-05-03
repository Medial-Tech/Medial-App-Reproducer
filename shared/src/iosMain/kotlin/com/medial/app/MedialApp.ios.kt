package com.medial.app

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.uikit.OnFocusBehavior
import androidx.compose.ui.window.ComposeUIViewController
import com.medial.app.ui.MedialApp
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import platform.UIKit.UIViewController

object MedialApp {

    private val deeplink = MutableStateFlow<String?>(null)

    /**
     * Call from iOS
     */
    fun setUpDeeplink(deeplink: String?) {
        this.deeplink.update { deeplink }
    }

    fun viewController(): UIViewController {

        return ComposeUIViewController(
            configure = { onFocusBehavior = OnFocusBehavior.DoNothing },
        ) {
            MedialApp(
                modifier = Modifier.fillMaxSize(),
                darkTheme = false,
                isDynamicTheme = false
            )
        }
    }

}