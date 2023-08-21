package multimodule.hexagonal.common.data.response

data class PageInfoResponse(
    val page: Int,
    val size: Int,
    val totalElements: Long,
    val totalPages: Int
)