package multimodule.hexagonal.domain.posting.usecase

import multimodule.hexagonal.common.annotation.ReadOnlyUseCase
import multimodule.hexagonal.common.annotation.UseCase
import multimodule.hexagonal.domain.like.service.GetLikeService
import multimodule.hexagonal.domain.posting.dto.response.PostingResData
import multimodule.hexagonal.domain.posting.dto.util.toResponse
import multimodule.hexagonal.domain.posting.exception.PostingNotFoundException
import multimodule.hexagonal.domain.posting.spi.QueryPostingPort

@ReadOnlyUseCase
class GetOnePostingUseCase(
    private val queryPostingPort: QueryPostingPort,
    private val getLikeService: GetLikeService

) {
    fun execute(postingId: Long): PostingResData {
        val posting = (queryPostingPort.findByPostingId(postingId)
            ?: throw PostingNotFoundException())
        return posting.toResponse(getLikeService.countByPosting(posting))
    }
}