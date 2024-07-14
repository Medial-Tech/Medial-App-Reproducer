package com.medial.app.convention;

import org.gradle.api.Project
import org.gradle.api.plugins.ExtensionAware
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.plugin.cocoapods.CocoapodsExtension

internal fun Project.configureKotlinMultiplatform(
    extension: KotlinMultiplatformExtension
) = extension.apply {
    jvmToolchain(17)
    androidTarget()
    iosArm64()
    iosX64()
    iosSimulatorArm64()

    applyDefaultHierarchyTemplate()

    sourceSets.apply {
        all {
            languageSettings.optIn("kotlinx.cinterop.ExperimentalForeignApi")
        }
        commonMain {
            dependencies {
                implementation(libs.findLibrary("koin.core").get())
                implementation(libs.findLibrary("coroutines.core").get())
                implementation(libs.findLibrary("kotlinx-dateTime").get())
                implementation(libs.findLibrary("napier").get())
                implementation(libs.findLibrary("kotlinx-serialization").get())
            }
        }

        androidMain {
            dependencies {
                implementation(libs.findLibrary("koin.android").get() )
            }
        }

        commonTest.dependencies {
            implementation(kotlin("test"))
        }
    }

    (this as ExtensionAware).extensions.configure<CocoapodsExtension>(::configureKotlinCocoapods)
}