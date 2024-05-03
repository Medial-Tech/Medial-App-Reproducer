plugins {
    id("com.medial.app.kotlinMultiplatform")
    alias(libs.plugins.composeMultiplatform)
}

kotlin {
    
    sourceSets {
        commonMain.dependencies {
            implementation(project(":shared:core"))
            implementation(project(":shared:data:models"))
            implementation(compose.runtime)
        }
    }
}