package multimodule.hexagonal.domain.posting.data

import multimodule.hexagonal.domain.posting.data.extension.toData
import multimodule.hexagonal.domain.posting.data.extension.toResponse
import multimodule.hexagonal.domain.posting.data.request.CreatePostingRequest
import multimodule.hexagonal.domain.posting.data.request.GetAllPostingRequest
import multimodule.hexagonal.domain.posting.data.response.PostingListResponse
import multimodule.hexagonal.domain.posting.usecase.CreatePostingUseCase
import multimodule.hexagonal.domain.posting.usecase.DeletePostingUseCase
import multimodule.hexagonal.domain.posting.usecase.GetAllPostingUseCase
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/postings")
class PostingWebAdapter(
    private val createPostingUseCase: CreatePostingUseCase,
    private val deletePostingUseCase: DeletePostingUseCase,
    private val getAllPostingUseCase: GetAllPostingUseCase
) {
    @PostMapping
    fun createPosting(@RequestBody postingRequest: CreatePostingRequest): ResponseEntity<Void> =
        createPostingUseCase.execute(postingRequest.toData())
            .run { ResponseEntity(HttpStatus.CREATED) }

    @DeleteMapping("/{id}")
    fun deletePosting(@PathVariable id: Long): ResponseEntity<Void> =
        deletePostingUseCase.execute(id)
            .run { ResponseEntity.ok().build() }

    @GetMapping
    fun getAllPosting(request: GetAllPostingRequest): ResponseEntity<PostingListResponse> =
        getAllPostingUseCase.execute(request.page, request.size)
            .let { ResponseEntity.ok(it.toResponse()) }
}