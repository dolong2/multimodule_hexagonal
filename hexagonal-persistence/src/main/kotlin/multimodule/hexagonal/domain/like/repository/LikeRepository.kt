package multimodule.hexagonal.domain.like.repository

import multimodule.hexagonal.domain.like.entity.LikeJpaEntity
import multimodule.hexagonal.domain.member.entity.MemberJpaEntity
import multimodule.hexagonal.domain.posting.entity.PostingJpaEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LikeRepository : JpaRepository<LikeJpaEntity, String> {
    fun findByParticipantAndPosting(participant: MemberJpaEntity, posting: PostingJpaEntity): LikeJpaEntity?
    fun countByPosting(posting: PostingJpaEntity): Long
}