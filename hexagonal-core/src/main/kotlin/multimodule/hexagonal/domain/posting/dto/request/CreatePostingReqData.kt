package multimodule.hexagonal.domain.posting.dto.request

data class CreatePostingReqData(
    val title: String,
    val content: String,
)