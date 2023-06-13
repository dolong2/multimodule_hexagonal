package multimodule.hexagonal.domain.auth.spi

import multimodule.hexagonal.domain.auth.dto.response.TokenResponse
import multimodule.hexagonal.domain.auth.model.Role

interface JwtPort {
    fun generateToken(userId: String, role: Role): TokenResponse
}