package multimodule.hexagonal.domain.auth.spi

import multimodule.hexagonal.domain.auth.dto.response.TokenResponseData
import multimodule.hexagonal.domain.auth.model.Role

interface JwtPort {
    fun generateToken(userId: String, role: Role): TokenResponseData
}