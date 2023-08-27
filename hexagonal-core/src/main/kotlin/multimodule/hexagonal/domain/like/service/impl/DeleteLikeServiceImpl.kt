package multimodule.hexagonal.domain.like.service.impl

import multimodule.hexagonal.common.annotation.Service
import multimodule.hexagonal.domain.like.exception.LikeNotExistException
import multimodule.hexagonal.domain.like.service.DeleteLikeService
import multimodule.hexagonal.domain.like.spi.CommandLikePort
import multimodule.hexagonal.domain.like.spi.QueryLikePort
import multimodule.hexagonal.domain.member.model.Member
import multimodule.hexagonal.domain.posting.model.Posting

@Service
class DeleteLikeServiceImpl(
    private val commandLikePort: CommandLikePort,
    private val queryLikePort: QueryLikePort
) : DeleteLikeService {
    override fun deleteByPostingAndMember(posting: Posting, member: Member) {
        val like = (queryLikePort.findByPostingAndParticipant(posting, member)
            ?: throw LikeNotExistException())
        commandLikePort.delete(like)
    }
}