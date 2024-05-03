plugins {
    id("com.medial.app.kotlinMultiplatform")
    id("com.medial.app.composeMultiplatform")
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