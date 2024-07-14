package com.medial.app.core

import io.sentry.SentryLevel
import io.sentry.kotlin.multiplatform.PlatformOptionsConfiguration

actual val SentryHelper.platformOptions: PlatformOptionsConfiguration
    get() = { options ->
        options.release = releaseName
        options.dsn = dsn
        options.environment = environment
        options.dist = dist
        options.isDebug = debug
        options.setDiagnosticLevel(SentryLevel.DEBUG)
    }