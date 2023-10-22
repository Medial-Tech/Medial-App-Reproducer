package app.medial.reproducer.presentation.auth

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
import cocoapods.FirebaseAuth.FIRAuth
import cocoapods.FirebaseAuth.FIRGoogleAuthProvider
import cocoapods.GoogleSignIn.GIDConfiguration
import cocoapods.GoogleSignIn.GIDGoogleUser
import cocoapods.GoogleSignIn.GIDSignIn
import cocoapods.GoogleSignIn.GIDSignInResult
import kotlinx.coroutines.launch
import platform.UIKit.UIApplication
import platform.UIKit.UIViewController
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine
import app.medial.reproducer.BuildKonfig

actual class GoogleAuthComponent : AuthComponent {

    private suspend fun signIn(controller: UIViewController) =
        suspendCoroutine<Result<GIDSignInResult>> { cont ->
            GIDSignIn.sharedInstance.signInWithPresentingViewController(controller) { result, error ->
                if (error != null) cont.resume(Result.failure(Throwable(error.localizedDescription)))
                else if (result == null) cont.resume(Result.failure(Throwable("Google Sign in failed")))
                else if (result.user.idToken == null) cont.resume(Result.failure(Throwable("Google Sign in failed")))
                else cont.resume(Result.success(result))
            }
        }

    private suspend fun getFirebaseToken(user: GIDGoogleUser) = suspendCoroutine<String> {
        val idToken = user.idToken?.tokenString
        if (idToken == null) it.resumeWithException(Throwable("Google Sign in failed"))
        val credential =
            FIRGoogleAuthProvider.credentialWithIDToken(idToken!!, user.accessToken.tokenString)

        FIRAuth.auth().signInWithCredential(credential) { result, error ->
            if (error != null) it.resumeWithException(Throwable(error.localizedDescription))
            else if (result == null) it.resumeWithException(Throwable("Firebase Sign in failed"))
            else result.user.getIDTokenForcingRefresh(true) { tokenResult, tokenError ->
                if (tokenError != null) it.resumeWithException(Throwable(tokenError.localizedDescription))
                else if (tokenResult == null) it.resumeWithException(Throwable("Token is null"))
                else it.resume(tokenResult)
            }

        }
    }


    @Composable
    actual override fun Content(
        modifier: Modifier,
        tracking: (String) -> Unit,
        onSuccess: (String, String) -> Unit,
        onError: (Throwable?) -> Unit
    ) {
        val controller  = UIApplication.sharedApplication.keyWindow?.rootViewController
        val scope = rememberCoroutineScope()

        val onClick = suspend {
            val config = GIDConfiguration(clientID = BuildKonfig.GOOGLE_WEB_CLIENT_ID)
            GIDSignIn.sharedInstance.setConfiguration(config)
            controller?.let {
                signIn(it).mapCatching { getFirebaseToken(it.user) }
                    .onSuccess { onSuccess(it, "FIREBASE") }
                    .onFailure(onError)
            }
        }

        Button(
            modifier = modifier,
            onClick = { scope.launch { onClick() } },
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF4285F4),
                contentColor = Color.White
            ),
            contentPadding = PaddingValues(vertical = 8.dp)
        ) {
            Text(
                text = "Login with Google"
            )
        }
    }
}