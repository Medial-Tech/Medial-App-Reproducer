plugins {
    id("com.medial.app.kotlinMultiplatform")
}

kotlin {

    sourceSets {
        commonMain.dependencies {
            implementation(project(":shared:core"))
            api(project(":shared:data"))

            //child modules
            api(project(":shared:domain:models"))
            api(project(":shared:domain:mappers"))

            implementation(project(":shared:unfurler"))
            implementation(project(":shared:articleExtractor"))
        }
    }
}