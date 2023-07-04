package multimodule.hexagonal.global.security

import multimodule.hexagonal.common.spi.SecurityPort
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component

@Component
class SecurityAdapter(
    private val passwordEncoder: PasswordEncoder
) : SecurityPort {
    override fun getCurrentUserId(): String =
        SecurityContextHolder.getContext().authentication.name

    override fun encodeRawPassword(rawPassword: String): String =
        passwordEncoder.encode(rawPassword)
}