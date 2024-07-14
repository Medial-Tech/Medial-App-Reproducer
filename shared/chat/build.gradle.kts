plugins {
    id("kotlinMultiplatform")
}

kotlin {

    cocoapods {

    }

    sourceSets {
        commonMain.dependencies {
            implementation(project(":shared:core"))
            implementation(project(":shared:data:preferences"))
            implementation(project(":shared:data:models"))
        }

        androidMain.dependencies {
        }
    }
}