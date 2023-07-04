package multimodule.hexagonal.domain.auth.usecase

import multimodule.hexagonal.common.annotation.UseCase
import multimodule.hexagonal.common.service.SecurityService
import multimodule.hexagonal.domain.auth.dto.request.SignUpData
import multimodule.hexagonal.domain.auth.dto.util.toMember
import multimodule.hexagonal.domain.member.spi.CommandMemberPort
import multimodule.hexagonal.domain.member.spi.QueryMemberPort

@UseCase
class SignupUseCase(
    private val commandMemberPort: CommandMemberPort,
    private val queryMemberPort: QueryMemberPort,
    private val securityService: SecurityService
) {
    fun execute(signUpData: SignUpData) {
        if (queryMemberPort.existsMemberEmail(signUpData.email))
            throw RuntimeException() //TODO 이미 존재하는 유저
        val encodedPassword = securityService.encodePassword(signUpData.password)
        commandMemberPort.save(signUpData.toMember(encodedPassword))
    }
}