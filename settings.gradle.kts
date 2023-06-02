pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
    
}
rootProject.name = "multi_module"
include("hexagonal-presentation")
include("hexagonal-core")
include("hexagonal-infrastructure")
include("hexagonal-persistence")
