package multimodule.hexagonal.common.service.impl

import multimodule.hexagonal.common.service.SecurityService
import multimodule.hexagonal.common.service.exception.PasswordNotCorrectException
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

    override fun matchPassword(rawPassword: String, encodedPassword: String) {
        if (!securityPort.isCorrectPassword(rawPassword, encodedPassword))
            throw PasswordNotCorrectException()// TODO 패스워드가 올바르지 않음
    }
}