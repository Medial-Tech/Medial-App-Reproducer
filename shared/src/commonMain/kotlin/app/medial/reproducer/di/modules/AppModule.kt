package app.medial.reproducer.di.modules

import org.koin.core.module.Module
import org.koin.dsl.module

expect val platformModule: Module

val appModule: Module
    get() = module {
        includes(platformModule)
    }