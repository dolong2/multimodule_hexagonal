package multimodule.hexagonal.domain.auth.dto.request

data class SignInData(
    val email: String,
    val password: String
)