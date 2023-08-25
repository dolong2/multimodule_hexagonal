package multimodule.hexagonal.domain.member.dto.util

import multimodule.hexagonal.domain.member.dto.response.MemberResData
import multimodule.hexagonal.domain.member.model.Member
import multimodule.hexagonal.domain.posting.dto.response.PostingResData

fun Member.toResponse(postings: List<PostingResData>): MemberResData =
    MemberResData(
        id = this.id,
        name = this.name,
        postings = postings
    )