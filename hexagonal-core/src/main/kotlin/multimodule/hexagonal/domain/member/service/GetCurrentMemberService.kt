package multimodule.hexagonal.domain.member.service

import multimodule.hexagonal.domain.member.model.Member

interface GetCurrentMemberService {
    fun getCurrentMember(): Member
}