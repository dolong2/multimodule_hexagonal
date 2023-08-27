package multimodule.hexagonal.domain.like.service

interface CreateLikeService {
    fun create(postingId: Long)
}