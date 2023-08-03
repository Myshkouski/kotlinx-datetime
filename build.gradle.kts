plugins {
    kotlin("multiplatform") version "1.8.21"
}

group = "by.mylab"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

kotlin {
//    jvm {
//        jvmToolchain(11)
//        withJava()
//    }
    js(IR) {
        nodejs()
        useEsModules()
        binaries.executable()
    }
    sourceSets {
        val commonMain by getting
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
//        val jvmMain by getting
//        val jvmTest by getting
        val jsMain by getting
        val jsTest by getting
    }
}
