package multimodule.hexagonal.domain.like.service.impl

import multimodule.hexagonal.common.annotation.Service
import multimodule.hexagonal.domain.like.service.GetLikeService
import multimodule.hexagonal.domain.like.spi.QueryLikePort
import multimodule.hexagonal.domain.posting.model.Posting

@Service
class GetLikeServiceImpl(
    private val queryLikePort: QueryLikePort
) : GetLikeService {
    override fun countByPosting(posting: Posting): Long =
        queryLikePort.countByPosting(posting)
}