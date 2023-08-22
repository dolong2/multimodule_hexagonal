package multimodule.hexagonal.domain.posting.data.extension

import multimodule.hexagonal.common.data.extension.toResponse
import multimodule.hexagonal.domain.posting.data.request.CreatePostingRequest
import multimodule.hexagonal.domain.posting.data.request.UpdatePostingRequest
import multimodule.hexagonal.domain.posting.data.response.PostingListResponse
import multimodule.hexagonal.domain.posting.data.response.PostingResponse
import multimodule.hexagonal.domain.posting.dto.request.CreatePostingReqData
import multimodule.hexagonal.domain.posting.dto.request.UpdatePostingReqData
import multimodule.hexagonal.domain.posting.dto.response.PostingListResData
import multimodule.hexagonal.domain.posting.dto.response.PostingResData

fun CreatePostingRequest.toData(): CreatePostingReqData =
    CreatePostingReqData(title, content)

fun PostingResData.toResponse(): PostingResponse =
    PostingResponse(id, title, content, likes, writer)

fun PostingListResData.toResponse(): PostingListResponse =
    PostingListResponse(
        data = this.data.map { it.toResponse() },
        pageInfo = this.pageInfo.toResponse()
    )

fun UpdatePostingRequest.toData(): UpdatePostingReqData =
    UpdatePostingReqData(
        title = this.title,
        content = this.content
    )