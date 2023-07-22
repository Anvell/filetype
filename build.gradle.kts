@file:Suppress("DSL_SCOPE_VIOLATION", "SpellCheckingInspection")

import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask
import org.jetbrains.kotlin.util.capitalizeDecapitalize.toLowerCaseAsciiOnly

plugins {
    alias(libs.plugins.kotlin.multiplatform) apply false
    alias(libs.plugins.dokka)
    alias(libs.plugins.kotlinter)
    alias(libs.plugins.dependency.updates)
}

val kotlinterId = libs.plugins.kotlinter.get().pluginId

allprojects {
    apply { plugin(kotlinterId) }

    repositories {
        mavenCentral()
    }

    group = properties["ArtifactGroup"].toString()
    version = properties["ArtifactVersion"].toString()
}

tasks.withType<DependencyUpdatesTask> {
    rejectVersionIf {
        val version = candidate.version.toLowerCaseAsciiOnly()

        listOf("-alpha", "-beta", "-rc")
            .any { it in version }
    }
}
