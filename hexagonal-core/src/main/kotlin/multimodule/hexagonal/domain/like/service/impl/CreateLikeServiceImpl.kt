package multimodule.hexagonal.domain.like.service.impl

import multimodule.hexagonal.common.annotation.Service
import multimodule.hexagonal.domain.like.exception.AlreadyLikePostingException
import multimodule.hexagonal.domain.like.model.Like
import multimodule.hexagonal.domain.like.service.CreateLikeService
import multimodule.hexagonal.domain.like.spi.CommandLikePort
import multimodule.hexagonal.domain.like.spi.QueryLikePort
import multimodule.hexagonal.domain.member.service.GetCurrentMemberService
import multimodule.hexagonal.domain.posting.exception.PostingNotFoundException
import multimodule.hexagonal.domain.posting.service.GetPostingService

@Service
class CreateLikeServiceImpl(
    private val commandLikePort: CommandLikePort,
    private val queryLikePort: QueryLikePort,
    private val getCurrentMemberService: GetCurrentMemberService,
    private val getPostingService: GetPostingService
) : CreateLikeService {
    override fun create(postingId: Long) {
        val posting = (getPostingService.getPostingById(postingId)
            ?: throw PostingNotFoundException())
        val member = getCurrentMemberService.getCurrentMember()
        queryLikePort.findByPostingAndParticipant(posting, member)
            ?.let { throw AlreadyLikePostingException() }
        commandLikePort.save(Like(participant = member, posting = posting))
    }
}