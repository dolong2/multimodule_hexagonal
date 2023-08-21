package multimodule.hexagonal.domain.posting.dao

import multimodule.hexagonal.domain.posting.model.Posting

data class PostingPageDao(
    val postingList: List<Posting>,
    val totalElements: Long,
    val totalPages: Int
)