package multimodule.hexagonal.domain.posting.data.request

data class CreatePostingRequest(
    val title: String,
    val content: String
)