plugins {
    id("com.medial.app.kotlinMultiplatform")
}

kotlin {

    sourceSets {
        commonMain.dependencies {
            implementation(project(":shared:core"))
        }

        androidMain.dependencies {

        }
    }
}