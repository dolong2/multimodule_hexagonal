package multimodule.hexagonal.domain.auth.usecase

import multimodule.hexagonal.common.annotation.UseCase
import multimodule.hexagonal.common.spi.SecurityPort
import multimodule.hexagonal.domain.auth.exception.RefreshTokenExpiredException
import multimodule.hexagonal.domain.auth.exception.RefreshTokenNotValidException
import multimodule.hexagonal.domain.auth.spi.CommandRefreshTokenPort
import multimodule.hexagonal.domain.auth.spi.QueryRefreshTokenPort

@UseCase
class SignOutUseCase(
    private val securityPort: SecurityPort,
    private val commandRefreshTokenPort: CommandRefreshTokenPort,
    private val queryRefreshTokenPort: QueryRefreshTokenPort,

) {
    fun execute(refreshToken: String) {
        val userId = securityPort.getCurrentUserId()
        val token = queryRefreshTokenPort.findByToken(refreshToken) ?: throw RefreshTokenExpiredException()
        if (token.userId == userId)
            commandRefreshTokenPort.deleteRefreshTokenByToken(token.token)
        else
            throw RefreshTokenNotValidException()
    }
}