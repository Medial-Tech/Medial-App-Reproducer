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
            implementation(project(":shared:domain"))
        }
    }
}