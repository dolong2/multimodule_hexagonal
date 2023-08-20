package multimodule.hexagonal.domain.posting.data

import multimodule.hexagonal.domain.posting.data.extension.toData
import multimodule.hexagonal.domain.posting.data.request.CreatePostingRequest
import multimodule.hexagonal.domain.posting.usecase.CreatePostingUseCase
import multimodule.hexagonal.domain.posting.usecase.DeletePostingUseCase
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/postings")
class PostingWebAdapter(
    private val createPostingUseCase: CreatePostingUseCase,
    private val deletePostingUseCase: DeletePostingUseCase
) {
    @PostMapping
    fun createPosting(@RequestBody postingRequest: CreatePostingRequest): ResponseEntity<Void> =
        createPostingUseCase.execute(postingRequest.toData())
            .run { ResponseEntity(HttpStatus.CREATED) }

    @DeleteMapping("/{id}")
    fun deletePosting(@PathVariable id: Long): ResponseEntity<Void> =
        deletePostingUseCase.execute(id)
            .run { ResponseEntity.ok().build() }
}