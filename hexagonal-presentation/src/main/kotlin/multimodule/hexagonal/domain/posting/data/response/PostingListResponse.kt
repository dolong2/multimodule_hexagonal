package multimodule.hexagonal.domain.posting.data.response

import multimodule.hexagonal.common.data.response.PageInfoResponse

data class PostingListResponse(
    val data: List<PostingResponse>,
    val pageInfo: PageInfoResponse
) {
}