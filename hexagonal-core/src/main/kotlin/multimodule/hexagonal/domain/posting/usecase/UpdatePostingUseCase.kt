package multimodule.hexagonal.domain.posting.usecase

import multimodule.hexagonal.common.annotation.UseCase
import multimodule.hexagonal.domain.member.service.GetCurrentMemberService
import multimodule.hexagonal.domain.posting.dto.request.UpdatePostingReqData
import multimodule.hexagonal.domain.posting.exception.PostingNotFoundException
import multimodule.hexagonal.domain.posting.exception.WriterNotSameException
import multimodule.hexagonal.domain.posting.spi.CommandPostingPort
import multimodule.hexagonal.domain.posting.spi.QueryPostingPort

@UseCase
class UpdatePostingUseCase(
    private val commandPostingPort: CommandPostingPort,
    private val getCurrentMemberService: GetCurrentMemberService,
    private val queryPostingPort: QueryPostingPort
) {
    fun execute(id: Long, updatePostingReqData: UpdatePostingReqData) {
        val posting = (queryPostingPort.findByPostingId(id)
            ?: throw PostingNotFoundException())
        if (posting.writer != getCurrentMemberService.getCurrentMember())
            throw WriterNotSameException()
        val updatedPosting = posting.copy(title = updatePostingReqData.title, content = updatePostingReqData.content)
        commandPostingPort.save(updatedPosting)
    }
}