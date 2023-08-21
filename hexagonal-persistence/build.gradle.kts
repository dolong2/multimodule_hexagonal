plugins {
    id("org.springframework.boot") version PluginVersion.SPRING_BOOT_VERSION
    id("io.spring.dependency-management") version PluginVersion.DEPENDENCY_MANAGER_VERSION
    kotlin("plugin.jpa") version PluginVersion.JPA_PLUGIN_VERSION
    kotlin("plugin.spring") version PluginVersion.SPRING_PLUGIN_VERSION apply false
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":hexagonal-core"))
    implementation(Dependencies.SPRING_JPA)
    implementation(Dependencies.SPRING_REDIS)
    runtimeOnly(Dependencies.H2_DATABASE)
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}