package multimodule.hexagonal.domain.member

import multimodule.hexagonal.domain.member.adapter.toDomain
import multimodule.hexagonal.domain.member.adapter.toEntity
import multimodule.hexagonal.domain.member.model.Member
import multimodule.hexagonal.domain.member.repository.MemberRepository
import multimodule.hexagonal.domain.member.spi.MemberPort
import org.springframework.stereotype.Component

@Component
class MemberPersistenceAdapter(
    private val memberRepository: MemberRepository
) : MemberPort{
    override fun save(member: Member): Member =
        memberRepository.save(member.toEntity())
            .toDomain()

    override fun findByMemberId(id: String): Member =
        memberRepository
            .findById(id)
            .orElseThrow { throw RuntimeException() } // TODO 유저를 찾을 수 없음
            .toDomain()

    override fun existsMemberId(id: String): Boolean =
        memberRepository.existsById(id)
}