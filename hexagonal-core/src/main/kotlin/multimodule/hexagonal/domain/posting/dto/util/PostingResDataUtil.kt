package multimodule.hexagonal.domain.posting.dto.util

import multimodule.hexagonal.domain.posting.dto.response.PostingResData
import multimodule.hexagonal.domain.posting.model.Posting

fun Posting.toResponse(): PostingResData =
    PostingResData(
        id = this.id,
        title = this.title,
        content = this.content,
        likes = this.likes,
        writer = this.writer.id
    )