package multimodule.hexagonal.common.service.impl

import multimodule.hexagonal.common.service.SecurityService
import multimodule.hexagonal.common.spi.SecurityPort
import org.springframework.stereotype.Service

@Service
class SecurityServiceImpl(
    private val securityPort: SecurityPort
) : SecurityService {
    override fun getUserId(): String =
        securityPort.getCurrentUserId()

    override fun encodePassword(rawPassword: String): String =
        securityPort.encodeRawPassword(rawPassword)
}