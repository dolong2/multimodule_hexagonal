package multimodule.hexagonal.domain.posting.usecase

import multimodule.hexagonal.common.annotation.UseCase
import multimodule.hexagonal.domain.like.service.DeleteLikeService
import multimodule.hexagonal.domain.member.service.GetCurrentMemberService
import multimodule.hexagonal.domain.posting.exception.PostingNotFoundException
import multimodule.hexagonal.domain.posting.service.GetPostingService

@UseCase
class DeletePostingLikeUseCase(
    private val deleteLikeService: DeleteLikeService,
    private val getCurrentMemberService: GetCurrentMemberService,
    private val getPostingService: GetPostingService
) {
    fun execute(postingId: Long) {
        val posting = (getPostingService.getPostingById(postingId)
            ?: throw PostingNotFoundException())
        val member = getCurrentMemberService.getCurrentMember()
        deleteLikeService.deleteByPostingAndMember(posting, member)
    }
}