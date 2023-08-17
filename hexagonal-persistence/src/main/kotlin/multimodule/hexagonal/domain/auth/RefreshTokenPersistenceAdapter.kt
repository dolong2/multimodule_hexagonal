package multimodule.hexagonal.domain.auth

import multimodule.hexagonal.domain.auth.adapter.toDomain
import multimodule.hexagonal.domain.auth.adapter.toEntity
import multimodule.hexagonal.domain.auth.model.RefreshToken
import multimodule.hexagonal.domain.auth.repository.RefreshTokenRepository
import multimodule.hexagonal.domain.auth.spi.RefreshTokenPort
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class RefreshTokenPersistenceAdapter(
    private val refreshTokenRepository: RefreshTokenRepository,
) : RefreshTokenPort {
    override fun saveRefreshToken(refreshToken: RefreshToken): RefreshToken =
        refreshTokenRepository
            .save(refreshToken.toEntity())
            .toDomain()

    override fun deleteRefreshTokenByToken(refreshToken: String) {
        refreshTokenRepository.deleteById(refreshToken)
    }

    override fun findByToken(token: String): RefreshToken? =
        refreshTokenRepository.findByIdOrNull(token)
            ?.toDomain()
}