import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

group = "com.medial.app.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.compose.gradlePlugin)
    compileOnly(libs.compose.compiler.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("kotlinMultiplatform"){
            id = "kotlinMultiplatform"
            implementationClass = "KotlinMultiplatformPlugin"
            version = "1.0.0"
        }

        register("composeMultiplatform"){
            id = "composeMultiplatform"
            implementationClass = "ComposeMultiplatformPlugin"
            version = "1.0.0"
        }
    }
}