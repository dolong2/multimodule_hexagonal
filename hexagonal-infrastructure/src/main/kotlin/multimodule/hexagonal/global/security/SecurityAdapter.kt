package multimodule.hexagonal.global.security

import multimodule.hexagonal.common.spi.SecurityPort
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component

@Component
class SecurityAdapter(
) : SecurityPort {
    override fun getCurrentUserId(): String =
        SecurityContextHolder.getContext().authentication.name
}