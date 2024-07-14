plugins {
    id("kotlinMultiplatform")
    id("composeMultiplatform")
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(project(":shared:ui:core"))
            implementation(project(":shared:core"))
            implementation(project(":shared:domain"))
        }

        androidMain.dependencies {
        }
    }
}