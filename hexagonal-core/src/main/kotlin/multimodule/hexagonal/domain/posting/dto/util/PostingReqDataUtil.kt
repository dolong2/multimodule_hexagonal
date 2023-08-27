package multimodule.hexagonal.domain.posting.dto.util

import multimodule.hexagonal.domain.member.model.Member
import multimodule.hexagonal.domain.posting.dto.request.CreatePostingReqData
import multimodule.hexagonal.domain.posting.model.Posting

fun CreatePostingReqData.toPosting(member: Member): Posting =
    Posting(
        id = 0,
        title = this.title,
        content = this.content,
        writer = member
    )