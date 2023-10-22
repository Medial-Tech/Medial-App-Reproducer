plugins {
    //trick: for the same plugin versions in all sub-modules
    id("com.android.application").version("8.2.0-beta06").apply(false)
    id("com.android.library").version("8.2.0-beta06").apply(false)
    kotlin("multiplatform").version(libs.versions.kotlin.get()).apply(false)
    id("org.jetbrains.compose").version(libs.versions.compose.get()).apply(false)
    id("com.google.gms.google-services").version("4.3.14").apply(false)
    id("com.codingfeline.buildkonfig").version("0.14.0").apply(false)
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
