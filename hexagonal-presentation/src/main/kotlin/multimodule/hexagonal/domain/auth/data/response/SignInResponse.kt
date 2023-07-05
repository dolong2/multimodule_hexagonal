package multimodule.hexagonal.domain.auth.data.response

import java.time.LocalDateTime

class SignInResponse(
    val accessToken: String,
    val accessTokenExp: LocalDateTime,
    val refreshToken: String,
    val refreshTokenExp: LocalDateTime
)