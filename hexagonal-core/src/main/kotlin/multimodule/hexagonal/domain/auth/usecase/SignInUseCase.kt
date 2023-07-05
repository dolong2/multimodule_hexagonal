package multimodule.hexagonal.domain.auth.usecase

import multimodule.hexagonal.common.annotation.UseCase
import multimodule.hexagonal.common.service.SecurityService
import multimodule.hexagonal.domain.auth.dto.request.SignInData
import multimodule.hexagonal.domain.auth.dto.response.TokenResponseData
import multimodule.hexagonal.domain.auth.spi.JwtPort
import multimodule.hexagonal.domain.member.spi.QueryMemberPort

@UseCase
class SignInUseCase(
    private val queryMemberPort: QueryMemberPort,
    private val securityService: SecurityService,
    private val jwtPort: JwtPort
) {
    fun execute(signInData: SignInData): TokenResponseData {
        val member = queryMemberPort.findMemberByEmail(signInData.email)
            ?: throw RuntimeException()// TODO 해당 유저가 존재하지 않음
        securityService.matchPassword(signInData.password, member.password)
        return jwtPort.generateToken(member.id, member.roles[0])
    }
}