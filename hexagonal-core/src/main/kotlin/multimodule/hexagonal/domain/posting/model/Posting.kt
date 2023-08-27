package multimodule.hexagonal.domain.posting.model

import multimodule.hexagonal.domain.member.model.Member

data class Posting(
    val id: Long,
    val title: String,
    val content: String,
    val writer: Member
)
