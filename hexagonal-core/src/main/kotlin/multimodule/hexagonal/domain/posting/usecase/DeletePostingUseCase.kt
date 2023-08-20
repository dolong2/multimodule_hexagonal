package multimodule.hexagonal.domain.posting.usecase

import multimodule.hexagonal.common.annotation.UseCase
import multimodule.hexagonal.domain.member.service.GetCurrentMemberService
import multimodule.hexagonal.domain.posting.exception.PostingNotFoundException
import multimodule.hexagonal.domain.posting.exception.WriterNotSameException
import multimodule.hexagonal.domain.posting.spi.CommandPostingPort
import multimodule.hexagonal.domain.posting.spi.QueryPostingPort

@UseCase
class DeletePostingUseCase(
    private val commandPostingPort: CommandPostingPort,
    private val queryPostingPort: QueryPostingPort,
    private val getCurrentMemberService: GetCurrentMemberService
) {
    fun execute(id: Long) {
        val posting = (queryPostingPort.findByPostingId(id)
            ?: throw PostingNotFoundException())
        val currentMember = getCurrentMemberService.getCurrentMember()
        if (posting.writer != currentMember) {
            throw WriterNotSameException()
        }
        commandPostingPort.delete(posting)
    }
}