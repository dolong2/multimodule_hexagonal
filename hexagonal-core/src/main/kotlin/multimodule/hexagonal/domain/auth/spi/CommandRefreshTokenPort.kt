package multimodule.hexagonal.domain.auth.spi

import multimodule.hexagonal.domain.auth.model.RefreshToken

interface CommandRefreshTokenPort {
    fun saveRefreshToken(refreshToken: RefreshToken): RefreshToken
    fun deleteRefreshTokenByToken(refreshToken: String)
}