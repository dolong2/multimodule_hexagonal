package multimodule.hexagonal.domain.auth.data.response

import java.time.LocalDateTime

class ReissueTokenResponse(
    val accessToken: String,
    val accessTokenExp: LocalDateTime,
    val refreshToken: String,
    val refreshTokenExp: LocalDateTime
)