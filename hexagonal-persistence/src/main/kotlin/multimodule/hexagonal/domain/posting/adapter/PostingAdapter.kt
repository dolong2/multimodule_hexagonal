package multimodule.hexagonal.domain.posting.adapter

import multimodule.hexagonal.domain.member.adapter.toDomain
import multimodule.hexagonal.domain.member.adapter.toEntity
import multimodule.hexagonal.domain.posting.entity.PostingJpaEntity
import multimodule.hexagonal.domain.posting.model.Posting

fun Posting.toEntity(): PostingJpaEntity =
    PostingJpaEntity(
        id = this.id,
        title = this.title,
        content = this.content,
        likes = this.likes,
        writer = this.writer.toEntity()
    )

fun PostingJpaEntity.toDomain(): Posting =
    Posting(
        id = this.id,
        title = this.title,
        content = this.content,
        likes = this.likes,
        writer = this.writer.toDomain()
    )