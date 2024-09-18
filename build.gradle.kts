// Top-level build file where you can add configuration options common to all subprojects/modules.
plugins {
    alias(libs.plugins.jetbrains.kotlin.jvm) apply false
    alias(libs.plugins.foojay.resolver.convention) apply false
    alias(libs.plugins.vanniktech.maven.publish) apply false
}
