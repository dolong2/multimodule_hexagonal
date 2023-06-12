package multimodule.hexagonal.domain.member.repository

import multimodule.hexagonal.domain.member.entity.MemberJpaEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MemberRepository : JpaRepository<MemberJpaEntity, String> {
}