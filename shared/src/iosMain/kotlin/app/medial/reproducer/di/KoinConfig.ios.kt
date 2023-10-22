package app.medial.reproducer.di

import app.medial.reproducer.di.modules.appModule
import org.koin.core.context.startKoin
import org.koin.dsl.module
import platform.UIKit.UIViewController

data class UiControllerWrapper(val uiController: UIViewController)

actual class KoinConfig(private val uiController: UIViewController) {
    actual fun initKoin() {
        startKoin {
            modules(
                module { single { UiControllerWrapper(uiController) } },
                appModule
            )
        }
    }
}