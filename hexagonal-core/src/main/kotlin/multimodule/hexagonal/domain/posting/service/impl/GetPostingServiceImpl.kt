package multimodule.hexagonal.domain.posting.service.impl

import multimodule.hexagonal.common.annotation.Service
import multimodule.hexagonal.domain.member.model.Member
import multimodule.hexagonal.domain.posting.dto.response.PostingResData
import multimodule.hexagonal.domain.posting.dto.util.toResponse
import multimodule.hexagonal.domain.posting.service.GetPostingService
import multimodule.hexagonal.domain.posting.spi.QueryPostingPort

@Service
class GetPostingServiceImpl(
    private val queryPostingPort: QueryPostingPort
) : GetPostingService {
    override fun getPostingByMember(member: Member): List<PostingResData> =
        queryPostingPort.findByMember(member)
            .map { it.toResponse() }
}