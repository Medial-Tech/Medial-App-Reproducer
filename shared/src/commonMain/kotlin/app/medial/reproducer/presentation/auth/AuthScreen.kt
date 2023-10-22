package app.medial.reproducer.presentation.auth

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

object AuthScreen : KoinComponent {

    private val signInComponent by inject<GoogleAuthComponent>()

    @Composable
    fun Content() {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            signInComponent.Content(
                modifier = Modifier,
                tracking = {},
                onSuccess = { _, _ -> },
                onError = {}
            )
        }
    }
}