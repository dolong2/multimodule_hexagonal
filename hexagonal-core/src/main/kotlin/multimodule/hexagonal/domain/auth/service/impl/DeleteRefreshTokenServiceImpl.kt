package multimodule.hexagonal.domain.auth.service.impl

import multimodule.hexagonal.domain.auth.service.DeleteRefreshTokenService
import multimodule.hexagonal.domain.auth.spi.CommandRefreshTokenPort
import org.springframework.stereotype.Service

@Service
class DeleteRefreshTokenServiceImpl(
    private val commandRefreshTokenPort: CommandRefreshTokenPort
) : DeleteRefreshTokenService {
    override fun deleteRefreshTokenByUserId(userId: String) {
        commandRefreshTokenPort.deleteRefreshTokenByUserId(userId)
    }
}