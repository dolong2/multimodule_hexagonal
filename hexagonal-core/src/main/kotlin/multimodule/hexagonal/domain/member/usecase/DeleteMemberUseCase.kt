package multimodule.hexagonal.domain.member.usecase

import multimodule.hexagonal.common.annotation.UseCase
import multimodule.hexagonal.domain.auth.service.DeleteRefreshTokenService
import multimodule.hexagonal.domain.member.service.GetCurrentMemberService
import multimodule.hexagonal.domain.member.spi.CommandMemberPort
import multimodule.hexagonal.domain.posting.service.DeletePostingService

@UseCase
class DeleteMemberUseCase(
    private val commandMemberPort: CommandMemberPort,
    private val getCurrentMemberService: GetCurrentMemberService,
    private val deleteRefreshTokenService: DeleteRefreshTokenService,
    private val deletePostingService: DeletePostingService
) {
    fun execute() {
        val member = getCurrentMemberService.getCurrentMember()
        deletePostingService.deleteByMember(member)
        deleteRefreshTokenService.deleteRefreshTokenByUserId(member.id)
        commandMemberPort.delete(member)
    }
}