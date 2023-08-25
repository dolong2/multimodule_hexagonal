package multimodule.hexagonal.domain.member.usecase

import multimodule.hexagonal.common.annotation.UseCase
import multimodule.hexagonal.domain.member.dto.response.MemberResData
import multimodule.hexagonal.domain.member.dto.util.toResponse
import multimodule.hexagonal.domain.member.service.GetCurrentMemberService
import multimodule.hexagonal.domain.posting.service.GetPostingService

@UseCase
class GetMemberUseCase(
    private val getCurrentMemberService: GetCurrentMemberService,
    private val getPostingService: GetPostingService

) {
    fun execute(): MemberResData{
        val currentMember = getCurrentMemberService.getCurrentMember()
        val postings = getPostingService.getPostingByMember(currentMember)
        return currentMember.toResponse(postings)
    }
}