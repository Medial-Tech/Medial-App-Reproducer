package com.medial.app.convention

import org.gradle.api.Project
import org.jetbrains.kotlin.compose.compiler.gradle.ComposeCompilerGradlePluginExtension
import java.io.File

fun Project.configureComposeCompiler(
    extension: ComposeCompilerGradlePluginExtension
) = with(extension){
    enableStrongSkippingMode.set(true)
    includeTraceMarkers.set(true)
    includeSourceInformation.set(true)

    stabilityConfigurationFile.set(File(rootDir.absolutePath + "/shared/compose_compiler_config.conf"))

    /**
     * Trigger this with:
     * ./gradlew assembleRelease -P enableMultiModuleComposeReports=true --rerun-tasks
     */
    if (project.hasProperty("enableMultiModuleComposeReports")) {
        reportsDestination.set(File(rootProject.buildDir.absolutePath + "/compose_metrics/"))
        metricsDestination.set(File(rootProject.buildDir.absolutePath + "/compose_metrics/"))
    }
}