package multimodule.hexagonal.domain.posting.service

import multimodule.hexagonal.domain.member.model.Member
import multimodule.hexagonal.domain.posting.dto.response.PostingResData

interface GetPostingService {
    fun getPostingByMember(member: Member): List<PostingResData>
}