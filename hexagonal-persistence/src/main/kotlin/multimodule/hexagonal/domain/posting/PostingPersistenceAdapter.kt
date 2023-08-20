package multimodule.hexagonal.domain.posting

import multimodule.hexagonal.domain.posting.adapter.toDomain
import multimodule.hexagonal.domain.posting.adapter.toEntity
import multimodule.hexagonal.domain.posting.model.Posting
import multimodule.hexagonal.domain.posting.repository.PostingRepository
import multimodule.hexagonal.domain.posting.spi.PostingPort
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

    override fun findByPostingId(id: Long): Posting? =
        postingRepository.findByIdOrNull(id)
            ?.toDomain()

    override fun existsByPostingId(id: Long): Boolean =
        postingRepository.existsById(id)
}