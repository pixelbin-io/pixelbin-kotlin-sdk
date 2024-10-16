import com.vanniktech.maven.publish.JavaLibrary
import com.vanniktech.maven.publish.JavadocJar
import com.vanniktech.maven.publish.SonatypeHost

plugins {
    id("java-library")
    alias(libs.plugins.jetbrains.kotlin.jvm)
    alias(libs.plugins.vanniktech.maven.publish)
}

dependencies {
    implementation(libs.gson)
    implementation(libs.okhttp)
    implementation(libs.okhttp.logging)
    implementation(libs.kotlinx.coroutines)
}

mavenPublishing {
    coordinates("io.pixelbin", "pixelbin-kotlin-sdk", "0.0.12")
    pom {
        name.set("PixelBin")
        description.set("Pixelbin kotlin sdk used to integrate pixelbin with your project")
        url.set("https://www.pixelbin.io/")
        licenses {
            license {
                name.set("MIT license")
                url.set("https://opensource.org/licenses/MIT")
            }
        }
        developers {
            developer {
                id.set("pixelbin")
                name.set("PixelBin")
                email.set("dev@pixelbin.io")
            }
        }
        scm {
            url.set("https://github.com/pixelbin-dev/pixelbin-kotlin-sdk")
            connection.set("scm:git:git://github.com/pixelbin-dev/pixelbin-kotlin-sdk.git")
            developerConnection.set("scm:git:ssh://git@github.com/pixelbin-dev/pixelbin-kotlin-sdk.git")
        }
    }

    configure(
        JavaLibrary(
            javadocJar = JavadocJar.Javadoc(),
            sourcesJar = false,
        ),
    )
    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)
    signAllPublications()
}
