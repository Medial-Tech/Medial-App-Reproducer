plugins {
    id("kotlinMultiplatform")
    id("composeMultiplatform")
}

kotlin {

    cocoapods {

    }

    sourceSets {
        commonMain.dependencies {
            implementation(project(":shared:core"))
            implementation(project(":shared:ui:core"))
            implementation(project(":shared:ui:components"))
            implementation(project(":shared:domain"))
            implementation(project(":shared:chat"))
        }
    }
}