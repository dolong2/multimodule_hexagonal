package multimodule.hexagonal.domain.like

import multimodule.hexagonal.domain.like.adapter.toDomain
import multimodule.hexagonal.domain.like.adapter.toEntity
import multimodule.hexagonal.domain.like.model.Like
import multimodule.hexagonal.domain.like.repository.LikeRepository
import multimodule.hexagonal.domain.like.spi.LikePort
import multimodule.hexagonal.domain.member.adapter.toEntity
import multimodule.hexagonal.domain.member.model.Member
import multimodule.hexagonal.domain.posting.adapter.toEntity
import multimodule.hexagonal.domain.posting.model.Posting
import org.springframework.stereotype.Component

@Component
class LikePersistenceAdapter(
    private val likeRepository: LikeRepository
) : LikePort {
    override fun save(like: Like) {
        likeRepository.save(like.toEntity())
    }

    override fun delete(like: Like) {
        likeRepository.delete(like.toEntity())
    }

    override fun countByPosting(posting: Posting): Long =
        likeRepository.countByPosting(posting.toEntity())

    override fun findByPostingAndParticipant(posting: Posting, participant: Member): Like? =
        likeRepository
            .findByParticipantAndPosting(participant.toEntity(), posting.toEntity())
            ?.toDomain()
}