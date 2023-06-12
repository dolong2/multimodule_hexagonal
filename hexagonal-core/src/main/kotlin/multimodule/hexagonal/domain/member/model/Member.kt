package multimodule.hexagonal.domain.member.model

import multimodule.hexagonal.domain.auth.model.Role
import java.util.*

data class Member (
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val email: String,
    val password: String,
    val roles: MutableList<Role>
)