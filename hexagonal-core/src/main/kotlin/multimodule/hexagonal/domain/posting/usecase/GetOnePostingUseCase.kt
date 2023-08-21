package multimodule.hexagonal.domain.posting.usecase

import multimodule.hexagonal.common.annotation.UseCase
import multimodule.hexagonal.domain.posting.dto.response.PostingResData
import multimodule.hexagonal.domain.posting.dto.util.toResponse
import multimodule.hexagonal.domain.posting.exception.PostingNotFoundException
import multimodule.hexagonal.domain.posting.spi.QueryPostingPort

@UseCase
class GetOnePostingUseCase(
    private val queryPostingPort: QueryPostingPort
) {
    fun execute(postingId: Long): PostingResData {
        val posting = (queryPostingPort.findByPostingId(postingId)
            ?: throw PostingNotFoundException())
        return posting.toResponse()
    }
}