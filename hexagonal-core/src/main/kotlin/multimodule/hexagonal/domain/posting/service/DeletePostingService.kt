package multimodule.hexagonal.domain.posting.service

import multimodule.hexagonal.domain.member.model.Member

interface DeletePostingService {
    fun deleteByMember(member: Member)
}