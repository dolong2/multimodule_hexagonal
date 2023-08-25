package multimodule.hexagonal.domain.auth.service.impl

import multimodule.hexagonal.common.annotation.Service
import multimodule.hexagonal.domain.auth.service.DeleteRefreshTokenService
import multimodule.hexagonal.domain.auth.spi.CommandRefreshTokenPort

@Service
class DeleteRefreshTokenServiceImpl(
    private val commandRefreshTokenPort: CommandRefreshTokenPort
) : DeleteRefreshTokenService {
    override fun deleteRefreshTokenByUserId(userId: String) {
        commandRefreshTokenPort.deleteRefreshTokenByUserId(userId)
    }
}