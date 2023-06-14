
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version PluginVersion.JVM_VERSION
}

java.sourceCompatibility = JavaVersion.VERSION_17

allprojects {
    group = "com.example"
    version = "0.0.1-SNAPSHOT"

    repositories {
        mavenCentral()
    }
}

subprojects {
    apply {
        plugin("org.jetbrains.kotlin.jvm")
        version = PluginVersion.JVM_VERSION
    }

    dependencies {
        // kotlin
        implementation(Dependencies.KOTLIN_REFLET)
        implementation(Dependencies.KOTLIN_JDK)
        implementation(Dependencies.JACKSON)

        //tomcat
        implementation(Dependencies.TOMCAT)

        // test
        implementation(Dependencies.SPRING_STARTER_TEST)
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "17"
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }

    configurations {
        compileOnly {
            extendsFrom(configurations.annotationProcessor.get())
        }
    }
}
