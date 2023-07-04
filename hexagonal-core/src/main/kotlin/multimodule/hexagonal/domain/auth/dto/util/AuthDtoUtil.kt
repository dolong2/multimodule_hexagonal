package multimodule.hexagonal.domain.auth.dto.util

import multimodule.hexagonal.domain.auth.dto.request.SignUpData
import multimodule.hexagonal.domain.auth.model.Role
import multimodule.hexagonal.domain.member.model.Member


fun SignUpData.toMember(encodedPassword: String): Member =
    Member(
        email = this.email,
        name = this.name,
        password = encodedPassword,
        roles = mutableListOf(Role.ROLE_MEMBER)
    )