package multimodule.hexagonal.domain.posting.data

import multimodule.hexagonal.domain.posting.data.extension.toData
import multimodule.hexagonal.domain.posting.data.request.CreatePostingRequest
import multimodule.hexagonal.domain.posting.usecase.CreatePostingUseCase
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/postings")
class PostingWebAdapter(
    private val createPostingUseCase: CreatePostingUseCase,
) {
    @PostMapping
    fun createPosting(@RequestBody postingRequest: CreatePostingRequest): ResponseEntity<Void> =
        createPostingUseCase.execute(postingRequest.toData())
            .run { ResponseEntity(HttpStatus.CREATED) }
}