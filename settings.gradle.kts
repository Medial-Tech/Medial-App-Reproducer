pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        maven("https://oss.sonatype.org/content/repositories/snapshots")
    }
    versionCatalogs {
        create("androidLibs") {
            from(files("gradle/androidLibs.versions.toml"))
        }
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version("0.4.0")
}

rootProject.name = "Reproducer"
include(":androidApp")
include(":shared")
include(":shared:unfurler")
include(":shared:core")
include(":shared:data")
include(":shared:data:preferences")
include(":shared:data:network")
include(":shared:data:local")
include(":shared:data:models")
include(":shared:domain")
include(":shared:domain:models")
include(":shared:domain:mappers")
include(":shared:ui")
include(":shared:ui:screens")
include(":shared:ui:core")
include(":shared:ui:components")
include(":shared:articleExtractor")
include(":shared:chat")
