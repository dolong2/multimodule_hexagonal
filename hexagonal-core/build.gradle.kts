plugins {
    id("org.springframework.boot") version PluginVersion.SPRING_BOOT_VERSION
    id("io.spring.dependency-management") version PluginVersion.DEPENDENCY_MANAGER_VERSION
    kotlin("plugin.spring") version PluginVersion.SPRING_PLUGIN_VERSION apply false
}

repositories {
    mavenCentral()
}

dependencies {
    // transaction
    implementation(Dependencies.SPRING_TRANSACTION)
}