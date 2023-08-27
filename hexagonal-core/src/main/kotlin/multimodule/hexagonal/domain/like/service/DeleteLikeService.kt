package multimodule.hexagonal.domain.like.service

import multimodule.hexagonal.domain.member.model.Member
import multimodule.hexagonal.domain.posting.model.Posting

interface DeleteLikeService {
    fun deleteByPostingAndMember(posting: Posting, member: Member)
}