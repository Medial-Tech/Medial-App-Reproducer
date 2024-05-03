package com.medial.app

import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier

object NapierKt {

    fun init() {
        Napier.base(DebugAntilog())
    }
}