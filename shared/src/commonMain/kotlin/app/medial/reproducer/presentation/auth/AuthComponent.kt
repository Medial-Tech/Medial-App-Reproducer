package app.medial.reproducer.presentation.auth

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

interface AuthComponent {

    @Composable
    fun Content(
        modifier:Modifier,
        tracking:(String)-> Unit,
        onSuccess:(String, String) -> Unit,
        onError:(Throwable?) -> Unit
    )
}