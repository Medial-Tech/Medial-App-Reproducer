package com.medial.app.core

import io.sentry.kotlin.multiplatform.PlatformOptionsConfiguration
import io.sentry.kotlin.multiplatform.Sentry
import io.sentry.kotlin.multiplatform.protocol.User

expect val SentryHelper.platformOptions: PlatformOptionsConfiguration


object SentryHelper {

    internal val releaseName = "testing"
    internal val dsn = "https://2c91ff199047b08b038cf095e6c81a34@o4507548242149376.ingest.de.sentry.io/4507548245426256"
    internal val environment = "debug"
    internal val dist = "1.0"
    internal val debug = true

    fun init() {
        Sentry.initWithPlatformOptions(platformOptions)
    }

    fun setUser(id: String, props: Map<String, String> = emptyMap()) {
        User(id = id, other = props.toMutableMap())
            .also(Sentry::setUser)
    }

    fun captureException(e: Throwable) {
        Sentry.captureException(e)
    }
}