package multimodule.hexagonal.domain.posting.usecase

import multimodule.hexagonal.common.annotation.ReadOnlyUseCase
import multimodule.hexagonal.common.annotation.UseCase
import multimodule.hexagonal.common.dto.response.PageInfoResData
import multimodule.hexagonal.domain.like.service.GetLikeService
import multimodule.hexagonal.domain.posting.dto.response.PostingListResData
import multimodule.hexagonal.domain.posting.dto.util.toResponse
import multimodule.hexagonal.domain.posting.spi.QueryPostingPort

@ReadOnlyUseCase
class GetAllPostingUseCase(
    private val queryPostingPort: QueryPostingPort,
    private val getLikeService: GetLikeService
) {
    fun execute(page: Int, size: Int): PostingListResData {
        val page = page - 1
        val postingPageDao = queryPostingPort.findAll(page, size)

        val postingList = postingPageDao.postingList
        val resDataList = postingList.map { it.toResponse(getLikeService.countByPosting(it)) }

        val totalPages = postingPageDao.totalPages
        val totalElements = postingPageDao.totalElements
        val pageInfoResData = PageInfoResData(page, size, totalElements, totalPages)


        return PostingListResData(
            data = resDataList,
            pageInfo = pageInfoResData
        )
    }
}