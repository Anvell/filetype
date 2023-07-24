@file:Suppress("DSL_SCOPE_VIOLATION")

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotest.multiplatform)
    alias(libs.plugins.dokka)
    id("maven-publish")
}

kotlin {
    jvm()
    js(IR) {
        browser()
    }
    iosArm64()
    iosSimulatorArm64()
    iosX64()
    linuxX64()
    macosArm64()
    macosX64()
    mingwX64()
    tvosArm64()
    tvosSimulatorArm64()
    tvosX64()
    watchosArm64()
    watchosSimulatorArm64()
    watchosX64()
    watchosX86()

    sourceSets {
        all {
            with(languageSettings) {
                optIn("kotlin.contracts.ExperimentalContracts")
                optIn("kotlin.experimental.ExperimentalTypeInference")
            }
        }

        getByName("commonTest") {
            dependencies {
                implementation(libs.kotest.framework.engine)
                implementation(libs.kotest.assertions.core)
            }
        }
        getByName("jvmTest") {
            dependencies {
                runtimeOnly(libs.kotest.runner.junit5)
            }
        }

        create("nativeMain") {
            dependsOn(getByName("commonMain"))
            getByName("iosArm64Main").dependsOn(this)
            getByName("iosSimulatorArm64Main").dependsOn(this)
            getByName("iosX64Main").dependsOn(this)
            getByName("linuxX64Main").dependsOn(this)
            getByName("macosArm64Main").dependsOn(this)
            getByName("macosX64Main").dependsOn(this)
            getByName("mingwX64Main").dependsOn(this)
            getByName("tvosArm64Main").dependsOn(this)
            getByName("tvosSimulatorArm64Main").dependsOn(this)
            getByName("tvosX64Main").dependsOn(this)
            getByName("watchosArm64Main").dependsOn(this)
            getByName("watchosSimulatorArm64Main").dependsOn(this)
            getByName("watchosX64Main").dependsOn(this)
            getByName("watchosX86Main").dependsOn(this)
        }
    }
}

tasks.named<Test>("jvmTest") {
    useJUnitPlatform()
}
