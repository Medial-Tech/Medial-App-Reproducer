plugins {
    id("kotlinMultiplatform")
}

kotlin {

    sourceSets {
        commonMain.dependencies {
            implementation(project(":shared:core"))
            implementation(project(":shared:chat"))

            //child modules
            api(project(":shared:data:models")) //api to give access to models to the domain layer
            api(project(":shared:data:local"))
            api(project(":shared:data:preferences"))
            implementation(project(":shared:data:network"))
        }
    }
}