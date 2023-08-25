package multimodule.hexagonal.domain.member.service.impl

import multimodule.hexagonal.common.annotation.Service
import multimodule.hexagonal.common.spi.SecurityPort
import multimodule.hexagonal.domain.member.exception.MemberNotFoundException
import multimodule.hexagonal.domain.member.model.Member
import multimodule.hexagonal.domain.member.service.GetCurrentMemberService
import multimodule.hexagonal.domain.member.spi.QueryMemberPort

@Service
class GetCurrentMemberServiceImpl(
    private val securityPort: SecurityPort,
    private val queryMemberPort: QueryMemberPort
) : GetCurrentMemberService{
    override fun getCurrentMember(): Member {
        val currentUserId = securityPort.getCurrentUserId()
        return queryMemberPort.findByMemberId(currentUserId)
            ?: throw MemberNotFoundException()
    }

}