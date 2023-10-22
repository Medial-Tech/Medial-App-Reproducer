package app.medial.reproducer

import android.content.Context
import android.content.Intent
import android.content.IntentSender
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.BeginSignInRequest.GoogleIdTokenRequestOptions
import com.google.android.gms.auth.api.identity.Identity
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await
import app.medial.reproducer.BuildKonfig

class GoogleSignInClient(context: Context) {

    private val oneTapClient = Identity.getSignInClient(context)

    suspend fun signIn(): IntentSender {
        return oneTapClient.beginSignIn(buildSignInReq())
            .await()
            .pendingIntent
            .intentSender
    }

    private fun buildSignInReq(): BeginSignInRequest {
        return BeginSignInRequest.builder()
            .setGoogleIdTokenRequestOptions(
                GoogleIdTokenRequestOptions.builder()
                    .setSupported(true)
                    .setFilterByAuthorizedAccounts(false)
                    .setServerClientId(BuildKonfig.GOOGLE_WEB_CLIENT_ID)
                    .build()
            )
            .setAutoSelectEnabled(true)
            .build()
    }

    suspend fun handleIntent(
        intent: Intent?,
        onComplete: (String) -> Unit,
        onError: (Throwable?) -> Unit,
    ) {
        try {
            val googleIdToken = oneTapClient.getSignInCredentialFromIntent(intent).googleIdToken
            val firebaseCredential = GoogleAuthProvider.getCredential(googleIdToken, null)
            Firebase.auth.signInWithCredential(firebaseCredential)
            val token = Firebase.auth.currentUser?.getIdToken(true)?.await()?.token
            token?.let(onComplete) ?: onError(Throwable("Token is null"))
        } catch (e: Throwable) {
            onError(e)
        }
    }
}