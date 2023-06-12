package multimodule.hexagonal.domain.member.spi

import multimodule.hexagonal.domain.member.model.Member

interface CommandMemberPort {
    fun save(member: Member): Member
}