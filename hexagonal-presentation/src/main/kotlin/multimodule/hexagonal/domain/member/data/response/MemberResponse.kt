package multimodule.hexagonal.domain.member.data.response

import multimodule.hexagonal.domain.posting.data.response.PostingResponse

data class MemberResponse(
    val id: String,
    val name: String,
    val postings: List<PostingResponse>
)