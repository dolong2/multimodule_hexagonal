plugins {
    id("org.springframework.boot") version PluginVersion.SPRING_BOOT_VERSION
    id("io.spring.dependency-management") version PluginVersion.DEPENDENCY_MANAGER_VERSION
    kotlin("plugin.spring") version PluginVersion.SPRING_PLUGIN_VERSION
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(Dependencies.SPRING_WEB)
    implementation(project(":hexagonal-core"))
}

tasks.getByName<Jar>("bootJar") {
    enabled = false
}