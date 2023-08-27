package multimodule.hexagonal.domain.posting.data

import multimodule.hexagonal.domain.posting.data.extension.toData
import multimodule.hexagonal.domain.posting.data.extension.toResponse
import multimodule.hexagonal.domain.posting.data.request.CreatePostingRequest
import multimodule.hexagonal.domain.posting.data.request.GetAllPostingRequest
import multimodule.hexagonal.domain.posting.data.request.UpdatePostingRequest
import multimodule.hexagonal.domain.posting.data.response.PostingListResponse
import multimodule.hexagonal.domain.posting.data.response.PostingResponse
import multimodule.hexagonal.domain.posting.usecase.*
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/postings")
class PostingWebAdapter(
    private val createPostingUseCase: CreatePostingUseCase,
    private val deletePostingUseCase: DeletePostingUseCase,
    private val getAllPostingUseCase: GetAllPostingUseCase,
    private val getOnePostingUseCase: GetOnePostingUseCase,
    private val updatePostingUseCase: UpdatePostingUseCase,
    private val createPostingLikeUseCase: CreatePostingLikeUseCase,
    private val deletePostingLikeUseCase: DeletePostingLikeUseCase
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

    @GetMapping("/{id}")
    fun getOnePosting(@PathVariable id: Long): ResponseEntity<PostingResponse> =
        getOnePostingUseCase.execute(id)
            .run { ResponseEntity.ok(this.toResponse()) }

    @PatchMapping("/{id}")
    fun updatePosting(
        @PathVariable id: Long,
        @RequestBody request: UpdatePostingRequest
    ): ResponseEntity<Void> =
        updatePostingUseCase.execute(id, request.toData())
            .run { ResponseEntity.ok().build() }

    @PatchMapping("/{id}/likes")
    fun updatePostingLike(@PathVariable id: Long): ResponseEntity<Void> =
        createPostingLikeUseCase.execute(id)
            .run { ResponseEntity.ok().build() }

    @DeleteMapping("/{id}/likes")
    fun deletePostingLike(@PathVariable id: Long): ResponseEntity<Void> =
        deletePostingLikeUseCase.execute(id)
            .run { ResponseEntity.ok().build() }
}