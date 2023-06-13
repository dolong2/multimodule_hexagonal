package multimodule.hexagonal.global.security.jwt.properties

import io.jsonwebtoken.security.Keys
import org.springframework.boot.context.properties.ConfigurationProperties
import java.security.Key


@ConfigurationProperties("jwt")
class JwtProperty (
    secret: String,
) {
    val secret: Key

    init {
        this.secret = Keys.hmacShaKeyFor(secret.toByteArray())
    }
}