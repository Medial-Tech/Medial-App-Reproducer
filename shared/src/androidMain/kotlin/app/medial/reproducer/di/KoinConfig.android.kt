package app.medial.reproducer.di

import android.content.Context
import app.medial.reproducer.di.modules.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.error.KoinAppAlreadyStartedException

actual class KoinConfig(private val context:Context) {
    actual fun initKoin() {
        try {
            startKoin {
                androidContext(context)
                modules(appModule)
            }
        } catch (_: KoinAppAlreadyStartedException){ }
            // ignore}
    }
}