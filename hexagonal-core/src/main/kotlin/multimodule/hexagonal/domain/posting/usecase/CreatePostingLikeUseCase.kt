package multimodule.hexagonal.domain.posting.usecase

import multimodule.hexagonal.common.annotation.UseCase
import multimodule.hexagonal.domain.like.service.CreateLikeService

@UseCase
class CreatePostingLikeUseCase(
    private val createLikeService: CreateLikeService,
) {
    fun execute(postingId: Long) {
        createLikeService.create(postingId)
    }
}