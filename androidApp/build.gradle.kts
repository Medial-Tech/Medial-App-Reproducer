plugins {
    id("com.android.application")
    kotlin("android")
    id("org.jetbrains.compose")
}

android {
    namespace = "app.medial.reproducer.android"
    compileSdk = 34
    defaultConfig {
        applicationId = "app.medial.reproducer.android"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }
    lint {
        abortOnError = false
        checkReleaseBuilds = false
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

kotlin {
    jvmToolchain(17)
}

dependencies {
    implementation(project(":shared"))

    implementation(androidLibs.core.ktx)
    implementation(androidLibs.fragment.ktx)
    implementation(androidLibs.appcompat)
    implementation(androidLibs.material)
    implementation(androidLibs.constraintlayout)
    implementation(androidLibs.lifecycle)
    implementation(androidLibs.lifecycle.compose)
    implementation(androidLibs.glide)

    implementation("androidx.compose.ui:ui:1.4.3")
    implementation("androidx.compose.ui:ui-tooling:1.4.3")
    implementation("androidx.compose.ui:ui-tooling-preview:1.4.3")
    implementation("androidx.compose.foundation:foundation:1.4.3")
    implementation("androidx.compose.material:material:1.4.3")
    implementation("androidx.activity:activity-compose:1.7.1")

    api("androidx.activity:activity-compose:1.7.2")
    api("androidx.core:core-ktx:1.10.1")
}