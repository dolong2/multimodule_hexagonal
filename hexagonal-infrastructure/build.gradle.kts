plugins {
    id("org.springframework.boot") version "3.0.6"
    id("io.spring.dependency-management") version "1.1.0"
    kotlin("plugin.spring") version "1.7.22" apply false
    kotlin("plugin.jpa") version "1.7.22" apply false
}

repositories {
    mavenCentral()
}

dependencies {
    // impl project
    implementation(project(":hexagonal-persistence"))
    implementation(project(":hexagonal-core"))
    implementation(project(":hexagonal-presentation"))
}

tasks.getByName<Jar>("jar") {
    enabled = false
}