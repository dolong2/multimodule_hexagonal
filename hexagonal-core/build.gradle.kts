group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework:spring-tx:6.0.6")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}