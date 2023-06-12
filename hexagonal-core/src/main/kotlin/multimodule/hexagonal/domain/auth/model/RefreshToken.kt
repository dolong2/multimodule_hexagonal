package multimodule.hexagonal.domain.auth.model

import java.util.*

data class RefreshToken(
    val token: String,
    val userId: String
)