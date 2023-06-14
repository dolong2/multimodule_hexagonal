package multimodule.hexagonal.domain.auth.spi

import multimodule.hexagonal.domain.auth.model.RefreshToken

interface QueryRefreshTokenPort {
    fun findByToken(token: String): RefreshToken?
}