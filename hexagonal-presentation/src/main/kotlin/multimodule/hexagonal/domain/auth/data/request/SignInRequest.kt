package multimodule.hexagonal.domain.auth.data.request

data class SignInRequest(
    val email: String,
    val password: String
)