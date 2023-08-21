package multimodule.hexagonal.common.dto.response

data class PageInfoResData(
    val page: Int,
    val size: Int,
    val totalElements: Long,
    val totalPages: Int
)