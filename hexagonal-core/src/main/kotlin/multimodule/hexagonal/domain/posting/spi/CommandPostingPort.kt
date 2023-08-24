package multimodule.hexagonal.domain.posting.spi

import multimodule.hexagonal.domain.member.model.Member
import multimodule.hexagonal.domain.posting.model.Posting

interface CommandPostingPort {
    fun save(posting: Posting): Posting
    fun delete(posting: Posting)
    fun deleteByWriter(member: Member)
}