plugins {
    id("com.medial.app.kotlinMultiplatform")
    id("com.medial.app.composeMultiplatform")
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {

    cocoapods {
        podfile = project.file("../iosApp/Podfile")
    }

    sourceSets {
        commonMain.dependencies {
            implementation(project(":shared:core"))
            implementation(project(":shared:ui"))
            implementation(project(":shared:domain"))
        }

        androidMain.dependencies {
            implementation("androidx.activity:activity-compose:1.7.1")
        }
    }
}

kotlin.sourceSets.all {
    languageSettings.optIn("kotlin.experimental.ExperimentalObjCName")
}