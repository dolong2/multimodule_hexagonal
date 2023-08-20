package multimodule.hexagonal.domain.auth.usecase

import multimodule.hexagonal.common.annotation.UseCase
import multimodule.hexagonal.domain.auth.dto.response.TokenResponseData
import multimodule.hexagonal.domain.auth.exception.RefreshTokenExpiredException
import multimodule.hexagonal.domain.auth.spi.JwtPort
import multimodule.hexagonal.domain.auth.spi.QueryRefreshTokenPort
import multimodule.hexagonal.domain.member.exception.MemberNotFoundException
import multimodule.hexagonal.domain.member.spi.QueryMemberPort

@UseCase
class ReissueTokenUseCase(
    private val queryRefreshTokenPort: QueryRefreshTokenPort,
    private val queryMemberPort: QueryMemberPort,
    private val jwtPort: JwtPort,
) {
    fun execute(refreshToken: String): TokenResponseData {
        val token = (queryRefreshTokenPort.findByToken(refreshToken)
            ?: throw RefreshTokenExpiredException())
        val userId = token.userId
        val member = (queryMemberPort.findByMemberId(userId)
            ?: throw MemberNotFoundException())
        return jwtPort.generateToken(member.id, member.roles[0])
    }
}