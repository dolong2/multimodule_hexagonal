package multimodule.hexagonal.domain.like.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import multimodule.hexagonal.domain.member.entity.MemberJpaEntity
import multimodule.hexagonal.domain.posting.entity.PostingJpaEntity
import java.util.UUID

@Entity
class LikeJpaEntity(
    @Id
    val id: String = UUID.randomUUID().toString(),
    @ManyToOne
    @JoinColumn(name = "participant_id")
    val participant: MemberJpaEntity,
    @ManyToOne
    @JoinColumn(name = "posting_id")
    val posting: PostingJpaEntity,
)