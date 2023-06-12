package multimodule.hexagonal.domain.member.adapter

import multimodule.hexagonal.domain.member.entity.MemberJpaEntity
import multimodule.hexagonal.domain.member.model.Member

fun Member.toEntity(): MemberJpaEntity =
    MemberJpaEntity(
        id = this.id,
        email = this.email,
        password = this.password,
        name = this.name,
        roles = this.roles
    )

fun MemberJpaEntity.toDomain(): Member =
    Member(
        id = this.id,
        name = this.name,
        email = this.email,
        password = this.password,
        roles = this.roles
    )