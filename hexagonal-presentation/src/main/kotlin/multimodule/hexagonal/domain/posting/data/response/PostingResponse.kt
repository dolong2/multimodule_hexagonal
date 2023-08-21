package multimodule.hexagonal.domain.posting.data.response

data class PostingResponse(
    val id: Long,
    val title: String,
    val content: String,
    val likes: Long,
    val writer: String
)