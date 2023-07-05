package multimodule.hexagonal.domain.member.spi

import multimodule.hexagonal.domain.member.model.Member

interface QueryMemberPort {
    fun findByMemberId(id: String): Member?
    fun existsMemberId(id: String): Boolean
    fun existsMemberByEmail(email: String): Boolean
    fun findMemberByEmail(email: String): Member?
}