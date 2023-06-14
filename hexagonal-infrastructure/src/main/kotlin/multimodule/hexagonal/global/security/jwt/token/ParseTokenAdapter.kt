package multimodule.hexagonal.global.security.jwt.token

import io.jsonwebtoken.*
import multimodule.hexagonal.domain.auth.model.Role
import multimodule.hexagonal.global.security.auth.AdminDetailsService
import multimodule.hexagonal.global.security.auth.MemberDetailsService
import multimodule.hexagonal.global.security.exception.ExpiredTokenException
import multimodule.hexagonal.global.security.exception.TokenNotValidException
import multimodule.hexagonal.global.security.jwt.properties.JwtProperty
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component

@Component
class ParseTokenAdapter(
    private val jwtProperty: JwtProperty,
    private val memberDetailsService: MemberDetailsService,
    private val adminDetailsService: AdminDetailsService
) {
    object JwtPrefix{
        const val ACCESS = "access"
        const val REFRESH = "refresh"
        const val ROLE = "role"
        const val PREFIX = "Bearer "
    }
    fun parseToken(token: String): String? =
        if(token.startsWith(JwtPrefix.PREFIX)) token.substring(JwtPrefix.PREFIX.length) else null
    fun getAuthentication(token: String): Authentication {
        val claims = getClaims(token)

        if(claims.header[Header.JWT_TYPE] != JwtPrefix.ACCESS)
            throw RuntimeException()

        val userDetails = getDetails(claims.body)

        return UsernamePasswordAuthenticationToken(userDetails, "", userDetails.authorities)
    }

    fun getClaimsBody(token: String): String {
        val claims = getClaims(token)
        return claims.body.id
    }

    private fun getClaims(token: String): Jws<Claims> {
        return try {
            Jwts.parserBuilder()
                .setSigningKey(jwtProperty.secret)
                .build().
                parseClaimsJws(token)
        } catch (e: Exception) {
            when(e) {
                is InvalidClaimException -> throw TokenNotValidException()
                is ExpiredJwtException -> throw ExpiredTokenException()
                is JwtException -> throw TokenNotValidException()
                else -> throw RuntimeException()
            }
        }
    }

    private fun getDetails(body: Claims): UserDetails {
        val role = body[JwtPrefix.ROLE, String::class.java]

        return when(role) {
            Role.ROLE_MEMBER.name -> memberDetailsService.loadUserByUsername(body.id)
            Role.ROLE_ADMIN.name -> adminDetailsService.loadUserByUsername(body.id)
            else -> throw throw RuntimeException()
        }
    }
}