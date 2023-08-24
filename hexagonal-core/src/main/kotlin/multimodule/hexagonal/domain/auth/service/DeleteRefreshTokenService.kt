package multimodule.hexagonal.domain.auth.service

interface DeleteRefreshTokenService {
    fun deleteRefreshTokenByUserId(userId: String)
}