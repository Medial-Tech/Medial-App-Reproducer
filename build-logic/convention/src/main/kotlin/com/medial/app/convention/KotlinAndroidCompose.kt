package com.medial.app.convention

import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.Project

internal fun Project.configureKotlinAndroidCompose(
    extension: LibraryExtension
) = extension.apply {
    buildFeatures { compose = true }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.findVersion("compose-compiler").get().requiredVersion
    }
}