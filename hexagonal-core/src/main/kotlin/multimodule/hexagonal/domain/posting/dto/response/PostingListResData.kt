package multimodule.hexagonal.domain.posting.dto.response

import multimodule.hexagonal.common.dto.response.PageInfoResData

data class PostingListResData(
    val data: List<PostingResData>,
    val pageInfo: PageInfoResData
)