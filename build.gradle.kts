import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version PluginVersion.JVM_VERSION
}

java.sourceCompatibility = JavaVersion.VERSION_17

subprojects {
    apply {
        plugin("org.jetbrains.kotlin.jvm")
        version = PluginVersion.JVM_VERSION
    }
    apply {
        plugin("org.jetbrains.kotlin.kapt")
        version = PluginVersion.KAPT_VERSION
    }

    dependencies {
        // kotlin
        implementation(Dependencies.KOTLIN_REFLET)
        implementation(Dependencies.KOTLIN_JDK)
        implementation(Dependencies.JACKSON)

        //tomcat
        implementation(Dependencies.TOMCAT)

        // test
//        implementation(Dependencies.SPRING_STARTER_TEST)
    }
}

allprojects {
    group = "multimodule.hexagonal"
    version = "0.0.1-SNAPSHOT"

    repositories {
        mavenCentral()
    }

    tasks {
        compileKotlin {
            kotlinOptions {
                freeCompilerArgs = listOf("-Xjsr305=strict")
                jvmTarget = PluginVersion.JVM_TARGET_VERSION
            }
        }
        compileJava {
            sourceCompatibility = JavaVersion.VERSION_17.majorVersion
        }
        test {
            useJUnitPlatform()
        }
    }
}
