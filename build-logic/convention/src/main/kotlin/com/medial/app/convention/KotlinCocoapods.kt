package com.medial.app.convention

import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.plugin.cocoapods.CocoapodsExtension

internal fun Project.configureKotlinCocoapods(
    extension: CocoapodsExtension
) = extension.apply {
    val moduleName = this@configureKotlinCocoapods.path.split(":").drop(1).joinToString("-")
    summary = "Some description for the Shared Module"
    homepage = "Link to the Shared Module homepage"
    version = "1.0"
    ios.deploymentTarget = "14.1"
    name = moduleName
    framework {
        isStatic = true
        baseName = moduleName
    }
}