package multimodule.hexagonal.domain.posting.data.request

data class UpdatePostingRequest(
    val title: String,
    val content: String
)