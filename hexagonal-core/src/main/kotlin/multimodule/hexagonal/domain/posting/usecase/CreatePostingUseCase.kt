package multimodule.hexagonal.domain.posting.usecase

import multimodule.hexagonal.common.annotation.UseCase
import multimodule.hexagonal.domain.member.service.GetCurrentMemberService
import multimodule.hexagonal.domain.posting.dto.request.CreatePostingReqData
import multimodule.hexagonal.domain.posting.dto.util.toPosting
import multimodule.hexagonal.domain.posting.spi.CommandPostingPort

@UseCase
class CreatePostingUseCase (
    private val commandPostingPort: CommandPostingPort,
    private val getCurrentMemberService: GetCurrentMemberService
) {
    fun execute(createPostingReqData: CreatePostingReqData) {
        val member = getCurrentMemberService.getCurrentMember()
        val posting = createPostingReqData.toPosting(member)
        commandPostingPort.save(posting)
    }
}