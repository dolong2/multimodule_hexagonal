package multimodule.hexagonal.domain.like.spi

import multimodule.hexagonal.domain.like.model.Like
import multimodule.hexagonal.domain.member.model.Member
import multimodule.hexagonal.domain.posting.model.Posting

interface QueryLikePort {
    fun countByPosting(posting: Posting): Long
    fun findByPostingAndParticipant(posting: Posting, participant: Member): Like?
}