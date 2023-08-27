package multimodule.hexagonal.domain.like.spi

import multimodule.hexagonal.domain.like.model.Like

interface CommandLikePort {
    fun save(like: Like)
}