package multimodule.hexagonal.domain.posting

import multimodule.hexagonal.domain.member.adapter.toEntity
import multimodule.hexagonal.domain.member.model.Member
import multimodule.hexagonal.domain.posting.adapter.toDomain
import multimodule.hexagonal.domain.posting.adapter.toEntity
import multimodule.hexagonal.domain.posting.dao.PostingPageDao
import multimodule.hexagonal.domain.posting.model.Posting
import multimodule.hexagonal.domain.posting.repository.PostingRepository
import multimodule.hexagonal.domain.posting.spi.PostingPort
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class PostingPersistenceAdapter(
    private val postingRepository: PostingRepository
) : PostingPort {
    override fun save(posting: Posting): Posting =
        postingRepository.save(posting.toEntity())
            .toDomain()

    override fun delete(posting: Posting) {
        postingRepository.delete(posting.toEntity())
    }

    override fun deleteByWriter(member: Member) {
        postingRepository.deleteByWriter(member.toEntity())
    }

    override fun findByPostingId(id: Long): Posting? =
        postingRepository.findByIdOrNull(id)
            ?.toDomain()

    override fun existsByPostingId(id: Long): Boolean =
        postingRepository.existsById(id)

    override fun findByMember(member: Member): List<Posting> =
        postingRepository.findByWriter(member.toEntity())
            .map { it.toDomain() }

    override fun findAll(page: Int, size: Int): PostingPageDao {
        val pageRequest = PageRequest.of(page, size)
        val entityPage = postingRepository.findAll(pageRequest)

        val postingList = entityPage.content.map { it.toDomain() }
        val totalPages = entityPage.totalPages
        val totalElements = entityPage.totalElements

        return PostingPageDao(
            postingList = postingList,
            totalPages = totalPages,
            totalElements = totalElements
        )
    }
}