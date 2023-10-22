import com.codingfeline.buildkonfig.compiler.FieldSpec.Type.STRING

plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.library")
    id("org.jetbrains.compose")
    id("com.codingfeline.buildkonfig")
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    targetHierarchy.default()
    jvmToolchain(11)
    android()
    ios()
    iosSimulatorArm64()

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "14.1"
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "shared"
            isStatic = true
        }

        pod("GoogleSignIn")
        pod("FirebaseAuth")
    }
    
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material3)
                implementation(libs.koin.core)
            }
        }

        val androidMain by getting {
            dependsOn(commonMain)
            dependencies {
                implementation("com.google.firebase:firebase-auth-ktx:22.1.2")
                implementation("com.google.android.gms:play-services-auth:20.7.0")
                implementation("androidx.activity:activity-compose:1.7.2")

                implementation(libs.koin.android)
            }
        }

        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }
}

kotlin.sourceSets.all {
    languageSettings.optIn("kotlin.experimental.ExperimentalObjCName")
}

android {
    namespace = "app.medial.reproducer"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }


    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlin {
        jvmToolchain(17)
    }
}

buildkonfig {
    packageName = "app.medial.reproducer"
    defaultConfigs {
        buildConfigField(STRING, "GOOGLE_WEB_CLIENT_ID", "110863522126-ts1qk6halhb8f7lcb5gupp4k4jnbr9eh.apps.googleusercontent.com")
    }
}