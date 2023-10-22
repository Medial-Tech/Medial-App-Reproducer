package app.medial.reproducer.presentation.auth

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

expect class GoogleAuthComponent : AuthComponent {

    @Composable
    override fun Content(
        modifier: Modifier,
        tracking: (String) -> Unit,
        onSuccess: (String, String) -> Unit,
        onError: (Throwable?) -> Unit
    )
}