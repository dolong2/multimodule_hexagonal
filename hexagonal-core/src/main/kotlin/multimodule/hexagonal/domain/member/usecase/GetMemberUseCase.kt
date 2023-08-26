package multimodule.hexagonal.domain.member.usecase

import multimodule.hexagonal.common.annotation.UseCase
import multimodule.hexagonal.domain.member.dto.response.MemberResData
import multimodule.hexagonal.domain.member.dto.util.toResponse
import multimodule.hexagonal.domain.member.exception.MemberNotFoundException
import multimodule.hexagonal.domain.member.service.GetCurrentMemberService
import multimodule.hexagonal.domain.member.spi.QueryMemberPort
import multimodule.hexagonal.domain.posting.service.GetPostingService

@UseCase
class GetMemberUseCase(
    private val getCurrentMemberService: GetCurrentMemberService,
    private val getPostingService: GetPostingService,
    private val queryMemberPort: QueryMemberPort
) {
    fun execute(): MemberResData {
        val currentMember = getCurrentMemberService.getCurrentMember()
        val postings = getPostingService.getPostingByMember(currentMember)
        return currentMember.toResponse(postings)
    }

    fun execute(memberId: String): MemberResData {
        val member = (queryMemberPort.findByMemberId(memberId)
            ?: throw MemberNotFoundException())
        val postings = getPostingService.getPostingByMember(member)
        return member.toResponse(postings)
    }
}