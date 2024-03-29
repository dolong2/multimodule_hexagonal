plugins {
    id("org.springframework.boot") version PluginVersion.SPRING_BOOT_VERSION
    id("io.spring.dependency-management") version PluginVersion.DEPENDENCY_MANAGER_VERSION
    kotlin("plugin.spring") version PluginVersion.SPRING_PLUGIN_VERSION
    kotlin("plugin.jpa") version PluginVersion.JPA_PLUGIN_VERSION
}

repositories {
    mavenCentral()
}

dependencies {
    //security
    implementation(Dependencies.SPRING_SECURITY)

    // jwt
    implementation(Dependencies.JWT_API)
    implementation(Dependencies.JWT_IMPL)
    implementation(Dependencies.JWT_JACKSON)

    // impl project
    implementation(project(":hexagonal-persistence"))
    implementation(project(":hexagonal-core"))
    implementation(project(":hexagonal-presentation"))
}

tasks.getByName<Jar>("jar") {
    enabled = false
}