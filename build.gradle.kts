plugins {
    kotlin("multiplatform") version "1.7.20"
    id("maven-publish")
}

group = "org.jetbrains.base64"
version = "1.0.0"

repositories {
    mavenCentral()
}

kotlin {

    /**
     * If you want to make it possible to use your library directly from the Android project,
     * or you need to use Android SDK to implement platform-specific features
     * (for example, working with files stored on the device), use the android() target declaration instead.
     * To make it work, you need to connect the android-library Gradle plugin and provide Android-specific information
     * in the android configuration block in the build.gradle.kts:
     * For sake of brevity we shall skip this step for now
     * but can later refer to https://dev.to/kotlin/how-to-build-and-publish-a-kotlin-multiplatform-library-creating-your-first-library-1bp8
     * undert the Supporting Android target
     */
   // android()

    /**
     * JVM target for Android
     * The resulting artifact could be used in multiplatform projects that target any JVM platforms, including Android.
     *
     */
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "1.8"
        }
        withJava()
        testRuns["test"].executionTask.configure {
            useJUnitPlatform()
        }
    }
    // TODO Whats the Diff btn the compiler types BOTH, IR, LEGACY
    js(BOTH) {
        browser {
            commonWebpackConfig {
                cssSupport.enabled = true
            }
        }
    }
    // TODO comment out since do we need to specify our hostTarget since we only want to support iOS
    /**
     * By dooing so we can ranme Don’t forget to also rename source set declarations and folder names according to the target name (nativeMain -> iosMain in our case).
     */
    val hostOs = System.getProperty("os.name")
    val isMingwX64 = hostOs.startsWith("Windows")
    val nativeTarget = when {
        hostOs == "Mac OS X" -> macosX64("native")
        hostOs == "Linux" -> linuxX64("native")
        isMingwX64 -> mingwX64("native")
        else -> throw GradleException("Host OS is not supported in Kotlin/Native.")
    }
    //ios()

    
    sourceSets {
        val commonMain by getting
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val jvmMain by getting
        val jvmTest by getting
        val jsMain by getting
        val jsTest by getting
        val nativeMain by getting
        val nativeTest by getting
    }
}
