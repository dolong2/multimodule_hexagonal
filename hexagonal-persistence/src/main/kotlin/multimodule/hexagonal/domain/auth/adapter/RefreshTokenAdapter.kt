package multimodule.hexagonal.domain.auth.adapter

import multimodule.hexagonal.domain.auth.entity.RefreshTokenEntity
import multimodule.hexagonal.domain.auth.model.RefreshToken

fun RefreshToken.toEntity(): RefreshTokenEntity =
    RefreshTokenEntity(
        token = this.token,
        userId = this.userId
    )

fun RefreshTokenEntity.toDomain(): RefreshToken =
    RefreshToken(
        token = this.token,
        userId = this.userId
    )