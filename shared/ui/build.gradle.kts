plugins {
    id("com.medial.app.kotlinMultiplatform")
    id("com.medial.app.composeMultiplatform")
}

kotlin {
    
    sourceSets {
        commonMain.dependencies {
            implementation(project(":shared:core"))
            implementation(project(":shared:ui:core"))
            implementation(project(":shared:ui:components"))
            implementation(project(":shared:ui:screens"))
            implementation(project(":shared:domain"))
        }
    }
}