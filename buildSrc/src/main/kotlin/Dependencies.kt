object Dependencies {
    // kotlin
    const val KOTLIN_REFLET = "org.jetbrains.kotlin:kotlin-reflect"
    const val KOTLIN_JDK = "org.jetbrains.kotlin:kotlin-stdlib-jdk8"

    //tomcat
    const val TOMCAT = "org.apache.tomcat.embed:tomcat-embed-core:${DependencyVersion.TOMCAT_VERSION}"

    // spring
    const val SPRING_JPA = "org.springframework.boot:spring-boot-starter-data-jpa"
    const val SPRING_REDIS = "org.springframework.boot:spring-boot-starter-data-redis"
    const val SPRING_SECURITY = "org.springframework.boot:spring-boot-starter-security"
    const val SPRING_WEB = "org.springframework.boot:spring-boot-starter-web"
    const val SPRING_VALIDATION = "org.springframework.boot:spring-boot-starter-validation"
    const val CONFIG_PROCESSOR = "org.springframework.boot:spring-boot-configuration-processor"
    const val SPRING_STARTER_TEST = "org.springframework.boot:spring-boot-starter-test"
    const val SPRING_SECURITY_TEST = "org.springframework.security:spring-security-test"
    const val SPRING_AOP = "org.springframework.boot:spring-boot-starter-aop"
    const val SPRING_TRANSACTION = "org.springframework:spring-tx:${DependencyVersion.SPRING_TRANSACTION}"

    // jackson
    const val JACKSON = "com.fasterxml.jackson.module:jackson-module-kotlin:${DependencyVersion.JACKSON_VERSION}"
    const val JACKSON_TYPE = "com.fasterxml.jackson.datatype:jackson-datatype-jsr310:${DependencyVersion.JACKSON_VERSION}"

    // database
    const val H2_DATABASE = "com.h2database:h2"

    // jwt
    const val JWT_API = "io.jsonwebtoken:jjwt-api:${DependencyVersion.JWT_API_VERSION}"
    const val JWT_IMPL = "io.jsonwebtoken:jjwt-impl:${DependencyVersion.JWT_IMPL_VERSION}"
    const val JWT_JACKSON = "io.jsonwebtoken:jjwt-jackson:${DependencyVersion.JWT_JACKSON_VERSION}"

}