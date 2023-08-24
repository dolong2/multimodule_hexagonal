package multimodule.hexagonal.domain.auth.entity

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.index.Indexed

@RedisHash(value = "refresh_token", timeToLive = 60L * 60 * 24 * 7)
class RefreshTokenEntity(
    @Id
    val token: String,
    @Indexed
    val userId: String
)