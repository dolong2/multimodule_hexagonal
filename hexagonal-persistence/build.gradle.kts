plugins {
    id("io.spring.dependency-management") version PluginVersion.DEPENDENCY_MANAGER_VERSION
    kotlin("plugin.jpa") version PluginVersion.JPA_PLUGIN_VERSION
    kotlin("plugin.spring") version PluginVersion.SPRING_PLUGIN_VERSION
    kotlin("plugin.allopen") version PluginVersion.ALLOPEN_VERSION
}

dependencies {
    implementation(project(":hexagonal-core"))
    implementation(Dependencies.SPRING_JPA)
    implementation(Dependencies.SPRING_REDIS)
    runtimeOnly(Dependencies.H2_DATABASE)
}

allOpen {
    annotation(AllOpen.ENTITY)
    annotation(AllOpen.MAPPED_SUPERCLASS)
    annotation(AllOpen.EMBEDDABLE)
}