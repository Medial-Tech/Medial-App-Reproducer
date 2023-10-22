package app.medial.reproducer.presentation.auth

import android.app.Activity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResult
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import app.medial.reproducer.GoogleSignInClient
import kotlinx.coroutines.launch

actual class GoogleAuthComponent(
    private val client: GoogleSignInClient
) : AuthComponent {

    @Composable
    actual override fun Content(
        modifier: Modifier,
        tracking: (String) -> Unit,
        onSuccess: (String, String) -> Unit,
        onError: (Throwable?) -> Unit
    ) {
        val scope = rememberCoroutineScope()

        val handleResult = { result: ActivityResult ->
            when {
                result.resultCode == Activity.RESULT_OK -> {
                    scope.launch {
                        client.handleIntent(
                            result.data,
                            onComplete = { onSuccess(it, "FIREBASE") },
                            onError
                        )
                    }
                }

                result.data == null -> onError(Throwable("User cancelled Firebase"))
                else -> onError(Throwable(result.resultCode.toString()))
            }
        }

        val launcher = rememberLauncherForActivityResult(
            contract = ActivityResultContracts.StartIntentSenderForResult(),
            onResult = { handleResult(it) }
        )

        val onClick = suspend {
            tracking("initialising firebase gmail")
            launcher.launch(IntentSenderRequest.Builder(client.signIn()).build())
        }


        Button(
            modifier = modifier,
            onClick = { scope.launch { onClick() } },
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF4285F4),
                contentColor = Color.White
            ),
            contentPadding = PaddingValues(vertical = 8.dp, horizontal = 16.dp)
        ) {
            Text(
                text = "Login with Google"
            )
        }

    }
}