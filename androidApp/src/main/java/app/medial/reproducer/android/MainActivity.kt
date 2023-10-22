package app.medial.reproducer.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import app.medial.reproducer.di.KoinConfig
import app.medial.reproducer.presentation.App
import com.google.firebase.ktx.Firebase
import com.google.firebase.ktx.initialize

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        KoinConfig(this).initKoin()
        Firebase.initialize(this)
        setContent {
            App()
        }
    }
}