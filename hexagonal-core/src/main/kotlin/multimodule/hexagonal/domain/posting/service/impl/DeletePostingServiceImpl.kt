package multimodule.hexagonal.domain.posting.service.impl

import multimodule.hexagonal.domain.member.model.Member
import multimodule.hexagonal.domain.posting.service.DeletePostingService
import multimodule.hexagonal.domain.posting.spi.CommandPostingPort
import org.springframework.stereotype.Service

@Service
class DeletePostingServiceImpl(
    private val commandPostingPort: CommandPostingPort
) : DeletePostingService {
    override fun deleteByMember(member: Member) {
        commandPostingPort.deleteByWriter(member)
    }
}