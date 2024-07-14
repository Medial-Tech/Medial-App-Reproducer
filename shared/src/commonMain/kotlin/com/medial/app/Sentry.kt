package com.medial.app

import com.medial.app.core.SentryHelper

object Sentry {

    fun doInit() {
        SentryHelper.init()
    }

}