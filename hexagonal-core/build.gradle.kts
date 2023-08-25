plugins {
    kotlin("plugin.allopen") version PluginVersion.ALLOPEN_VERSION
}

repositories {
    mavenCentral()
}

dependencies {
    // transaction
    implementation(Dependencies.SPRING_TRANSACTION)
}

allOpen{
    annotation(AllOpen.USECASE)
    annotation(AllOpen.READ_ONLY_USECASE)
    annotation(AllOpen.SERVICE)
}