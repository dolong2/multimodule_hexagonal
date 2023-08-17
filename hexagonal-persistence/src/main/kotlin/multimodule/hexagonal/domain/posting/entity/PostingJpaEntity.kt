package multimodule.hexagonal.domain.posting.entity

import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import multimodule.hexagonal.domain.member.entity.MemberJpaEntity

class PostingJpaEntity(
    @Id
    @GeneratedValue
    val id: Long,
    val title: String,
    val content: String,
    val likes: Long,
    @ManyToOne
    @JoinColumn(name = "writer_id", nullable = false)
    val writer: MemberJpaEntity
)