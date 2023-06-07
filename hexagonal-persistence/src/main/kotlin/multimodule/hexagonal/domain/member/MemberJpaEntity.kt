package multimodule.hexagonal.domain.member

import jakarta.persistence.*
import multimodule.hexagonal.domain.auth.model.Role
import java.util.*

class MemberJpaEntity(
    @Id
    val id: String = UUID.randomUUID().toString(),
    val email: String,
    val password: String,
    val name: String,
    @Enumerated(EnumType.STRING)
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "Role", joinColumns = [JoinColumn(name = "user_id")])
    val roles: MutableList<Role> = mutableListOf()
) {
}