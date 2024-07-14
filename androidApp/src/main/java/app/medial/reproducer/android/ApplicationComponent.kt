package app.medial.reproducer.android

import android.app.Application
import com.medial.app.Sentry

class ApplicationComponent : Application() {

    override fun onCreate() {
        super.onCreate()
        Sentry.doInit()
    }
}