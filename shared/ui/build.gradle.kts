plugins {
    id("kotlinMultiplatform")
    id("composeMultiplatform")
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