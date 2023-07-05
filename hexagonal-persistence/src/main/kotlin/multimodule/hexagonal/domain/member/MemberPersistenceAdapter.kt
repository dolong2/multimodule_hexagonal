package multimodule.hexagonal.domain.member

import multimodule.hexagonal.domain.member.adapter.toDomain
import multimodule.hexagonal.domain.member.adapter.toEntity
import multimodule.hexagonal.domain.member.model.Member
import multimodule.hexagonal.domain.member.repository.MemberRepository
import multimodule.hexagonal.domain.member.spi.MemberPort
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class MemberPersistenceAdapter(
    private val memberRepository: MemberRepository
) : MemberPort{
    override fun save(member: Member): Member =
        memberRepository.save(member.toEntity())
            .toDomain()

    override fun findByMemberId(id: String): Member? =
        memberRepository
            .findByIdOrNull(id)
            ?.toDomain()

    override fun existsMemberId(id: String): Boolean =
        memberRepository.existsById(id)

    override fun existsMemberByEmail(email: String): Boolean =
        memberRepository.existsByEmail(email)
    override fun findMemberByEmail(email: String): Member? {
        val entity = (memberRepository.findByEmail(email)
            ?: return null)
        return entity.toDomain()
    }
}