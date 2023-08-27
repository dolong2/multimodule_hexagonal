package multimodule.hexagonal.domain.like.adapter

import multimodule.hexagonal.domain.like.entity.LikeJpaEntity
import multimodule.hexagonal.domain.like.model.Like
import multimodule.hexagonal.domain.member.adapter.toDomain
import multimodule.hexagonal.domain.member.adapter.toEntity
import multimodule.hexagonal.domain.posting.adapter.toDomain
import multimodule.hexagonal.domain.posting.adapter.toEntity

fun Like.toEntity(): LikeJpaEntity =
    LikeJpaEntity(
        id = this.id,
        participant = this.participant.toEntity(),
        posting = this.posting.toEntity()
    )

fun LikeJpaEntity.toDomain(): Like =
    Like(
        id = this.id,
        participant = this.participant.toDomain(),
        posting = this.posting.toDomain()
    )