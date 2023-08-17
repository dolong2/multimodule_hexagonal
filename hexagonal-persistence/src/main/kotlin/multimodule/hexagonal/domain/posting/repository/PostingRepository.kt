package multimodule.hexagonal.domain.posting.repository

import multimodule.hexagonal.domain.posting.entity.PostingJpaEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PostingRepository : JpaRepository<PostingJpaEntity, Long> {
}