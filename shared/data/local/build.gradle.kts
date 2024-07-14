plugins {
    id("kotlinMultiplatform")
}

kotlin {
    
    sourceSets {
        commonMain.dependencies {
            implementation(project(":shared:core"))
            implementation(project(":shared:data:models"))
        }
    }
}