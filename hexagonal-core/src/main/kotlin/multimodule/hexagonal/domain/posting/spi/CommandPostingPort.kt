package multimodule.hexagonal.domain.posting.spi

import multimodule.hexagonal.domain.posting.model.Posting

interface CommandPostingPort {
    fun save(posting: Posting): Posting
}