package multimodule.hexagonal.domain.member.spi

import multimodule.hexagonal.domain.member.model.Member

interface QueryMemberPort {
    fun findByMemberId(id: String): Member
    fun existsMemberId(id: String): Boolean
}