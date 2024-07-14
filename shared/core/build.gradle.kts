plugins {
    id("kotlinMultiplatform")
}

kotlin {

    cocoapods {
        pod("Sentry") {
            version = "~> 8.25"
            linkOnly = true
            extraOpts += listOf("-compiler-option", "-fmodules")
        }
    }

    sourceSets {
        commonMain.dependencies {
            implementation(libs.sentry)
        }

        androidMain.dependencies {

        }
    }
}