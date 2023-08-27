package multimodule.hexagonal.domain.like.service

import multimodule.hexagonal.domain.posting.model.Posting

interface GetLikeService {
    fun countByPosting(posting: Posting): Long
}