plugins {
    id("java-library")
    alias(libs.plugins.jetbrains.kotlin.jvm)
}

group = "org.example"
version = "unspecified"

dependencies {
    implementation(project(":pixelbin"))
    implementation(libs.kotlinx.coroutines)
}
