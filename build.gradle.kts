buildscript {
    dependencies {
        classpath(libs.moko.resources.generator)
    }
}

plugins {
    //trick: for the same plugin versions in all sub-modules
    id("com.android.application").version("8.2.0").apply(false)
    id("com.android.library").version("8.2.0").apply(false)
    kotlin("multiplatform").version(libs.versions.kotlin.get()).apply(false)
    kotlin("plugin.serialization").version("1.4.21").apply(false)
    id("org.jetbrains.compose").version(libs.versions.compose.get()).apply(false)
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
