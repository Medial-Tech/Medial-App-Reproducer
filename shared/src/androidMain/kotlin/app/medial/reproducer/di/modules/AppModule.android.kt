package app.medial.reproducer.di.modules

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import app.medial.reproducer.GoogleSignInClient
import app.medial.reproducer.presentation.auth.GoogleAuthComponent
import org.koin.core.module.dsl.factoryOf

actual val platformModule = module {

    singleOf(::GoogleSignInClient)
    factoryOf(::GoogleAuthComponent)

}