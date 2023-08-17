package multimodule.hexagonal.domain.posting.entity

import jakarta.persistence.*
import multimodule.hexagonal.domain.member.entity.MemberJpaEntity

@Entity
class PostingJpaEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val title: String,
    val content: String,
    val likes: Long,
    @ManyToOne
    @JoinColumn(name = "writer_id", nullable = false)
    val writer: MemberJpaEntity
)