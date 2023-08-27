package multimodule.hexagonal.domain.like.model

import multimodule.hexagonal.domain.member.model.Member
import multimodule.hexagonal.domain.posting.model.Posting

data class Like(
    val id: String = "",
    val participant: Member,
    val posting: Posting
)
