package multimodule.hexagonal.domain.member.data.extension

import multimodule.hexagonal.domain.member.data.response.MemberResponse
import multimodule.hexagonal.domain.member.dto.response.MemberResData
import multimodule.hexagonal.domain.posting.data.extension.toResponse

fun MemberResData.toResponse(): MemberResponse =
    MemberResponse(
        id = this.id,
        name = this.name,
        postings = this.postings.map { it.toResponse() }
    )