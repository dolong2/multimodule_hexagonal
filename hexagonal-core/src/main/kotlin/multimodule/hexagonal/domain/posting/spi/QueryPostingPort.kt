package multimodule.hexagonal.domain.posting.spi

import multimodule.hexagonal.domain.posting.dao.PostingPageDao
import multimodule.hexagonal.domain.posting.model.Posting

interface QueryPostingPort {
    fun findByPostingId(id: Long): Posting?
    fun existsByPostingId(id: Long): Boolean

    fun findAll(page: Int, size: Int): PostingPageDao
}