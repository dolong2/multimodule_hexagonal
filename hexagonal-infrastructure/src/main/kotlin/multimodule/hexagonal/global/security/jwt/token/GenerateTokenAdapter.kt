package multimodule.hexagonal.global.security.jwt.token

import io.jsonwebtoken.Header
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import multimodule.hexagonal.domain.auth.dto.response.TokenResponse
import multimodule.hexagonal.domain.auth.model.RefreshToken
import multimodule.hexagonal.domain.auth.model.Role
import multimodule.hexagonal.domain.auth.spi.JwtPort
import multimodule.hexagonal.domain.auth.spi.RefreshTokenPort
import multimodule.hexagonal.global.security.jwt.properties.JwtProperty
import multimodule.hexagonal.global.security.jwt.properties.TokenTimeProperty
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.util.*

@Component
class GenerateTokenAdapter(
    private val jwtProperty: JwtProperty,
    private val tokenTimeProperty: TokenTimeProperty,
    private val refreshTokenPort: RefreshTokenPort
) : JwtPort {
    object JwtPrefix{
        const val ACCESS = "access"
        const val REFRESH = "refresh"
        const val ROLE = "role"
    }

    override fun generateToken(userId: String, role: Role): TokenResponse =
        TokenResponse(
            accessToken = generatedAccessToken(userId, role),
            refreshToken = generatedRefreshToken(userId),
            accessTokenExp = LocalDateTime.now().withNano(0).plusSeconds(tokenTimeProperty.accessTime),
            refreshTokenExp = LocalDateTime.now().withNano(0).plusSeconds(tokenTimeProperty.refreshTime)
        )

    private fun generatedAccessToken(userId: String, role: Role) =
        Jwts.builder()
            .signWith(SignatureAlgorithm.HS512, jwtProperty.secret)
            .setHeaderParam(Header.JWT_TYPE, JwtPrefix.ACCESS)
            .setId(userId)
            .claim(JwtPrefix.ROLE, role.name)
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + tokenTimeProperty.accessTime * 1000))
            .compact()

    private fun generatedRefreshToken(userId: String): String =
        Jwts.builder()
            .signWith(SignatureAlgorithm.HS512, jwtProperty.secret)
            .setHeaderParam(Header.JWT_TYPE, JwtPrefix.REFRESH)
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + tokenTimeProperty.refreshTime * 1000))
            .compact()
            .apply { refreshTokenPort.saveRefreshToken(RefreshToken(token = this, userId = userId)) }
}