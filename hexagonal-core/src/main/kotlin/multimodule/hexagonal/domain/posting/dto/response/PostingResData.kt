package multimodule.hexagonal.domain.posting.dto.response

data class PostingResData(
    val id: Long,
    val title: String,
    val content: String,
    val likes: Long,
    val writer: String
)