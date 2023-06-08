plugins {
    id("org.springframework.boot") version PluginVersion.SPRING_BOOT_VERSION
    id("io.spring.dependency-management") version PluginVersion.DEPENDENCY_MANAGER_VERSION
    kotlin("plugin.spring") version PluginVersion.SPRING_PLUGIN_VERSION
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