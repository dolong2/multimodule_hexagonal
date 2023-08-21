package multimodule.hexagonal.domain.posting.data.request

import org.springframework.web.bind.annotation.RequestParam

data class GetAllPostingRequest(
    @RequestParam
    val page: Int,
    @RequestParam
    val size: Int
)