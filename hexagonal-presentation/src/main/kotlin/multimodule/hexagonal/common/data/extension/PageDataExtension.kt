package multimodule.hexagonal.common.data.extension

import multimodule.hexagonal.common.data.response.PageInfoResponse
import multimodule.hexagonal.common.dto.response.PageInfoResData

fun PageInfoResData.toResponse(): PageInfoResponse =
    PageInfoResponse(page, size, totalElements, totalPages)