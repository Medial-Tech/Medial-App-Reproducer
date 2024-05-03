plugins {
    id("com.medial.app.kotlinMultiplatform")
}

kotlin {

    sourceSets {
        commonMain.dependencies {
            implementation(project(":shared:core"))
            implementation(project(":shared:data:models"))
            implementation(project(":shared:data:preferences"))
        }
        androidMain.dependencies {
        }
        iosMain.dependencies {
        }
    }
}