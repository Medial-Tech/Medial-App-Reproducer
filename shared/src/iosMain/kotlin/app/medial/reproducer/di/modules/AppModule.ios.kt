package app.medial.reproducer.di.modules

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import app.medial.reproducer.presentation.auth.GoogleAuthComponent

actual val platformModule = module {

    factoryOf(::GoogleAuthComponent)
}