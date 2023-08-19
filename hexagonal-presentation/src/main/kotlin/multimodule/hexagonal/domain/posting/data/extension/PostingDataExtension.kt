package multimodule.hexagonal.domain.posting.data.extension

import multimodule.hexagonal.domain.posting.data.request.CreatePostingRequest
import multimodule.hexagonal.domain.posting.dto.request.CreatePostingReqData

fun CreatePostingRequest.toData(): CreatePostingReqData =
    CreatePostingReqData(title, content)