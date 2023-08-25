package multimodule.hexagonal.domain.member.dto.response

import multimodule.hexagonal.domain.posting.dto.response.PostingResData

data class MemberResData(
    val id: String,
    val name: String,
    val postings: List<PostingResData>
)