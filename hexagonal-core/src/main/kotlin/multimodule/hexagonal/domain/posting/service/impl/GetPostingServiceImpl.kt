package multimodule.hexagonal.domain.posting.service.impl

import multimodule.hexagonal.common.annotation.Service
import multimodule.hexagonal.domain.like.service.GetLikeService
import multimodule.hexagonal.domain.member.model.Member
import multimodule.hexagonal.domain.posting.dto.response.PostingResData
import multimodule.hexagonal.domain.posting.dto.util.toResponse
import multimodule.hexagonal.domain.posting.model.Posting
import multimodule.hexagonal.domain.posting.service.GetPostingService
import multimodule.hexagonal.domain.posting.spi.QueryPostingPort

@Service
class GetPostingServiceImpl(
    private val queryPostingPort: QueryPostingPort,
    private val getLikeService: GetLikeService
) : GetPostingService {
    override fun getPostingByMember(member: Member): List<PostingResData> =
        queryPostingPort.findByMember(member)
            .map { it.toResponse(getLikeService.countByPosting(it)) }

    override fun getPostingById(id: Long): Posting? =
        queryPostingPort.findByPostingId(id)
}