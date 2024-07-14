package com.medial.app.core

import io.sentry.kotlin.multiplatform.PlatformOptionsConfiguration
import kotlinx.cinterop.ExperimentalForeignApi

@OptIn(ExperimentalForeignApi::class)
actual val SentryHelper.platformOptions: PlatformOptionsConfiguration
    get() = { options ->
        options.releaseName = releaseName
        options.dsn = dsn
        options.environment = environment
        options.dist = dist
        options.debug = debug
    }