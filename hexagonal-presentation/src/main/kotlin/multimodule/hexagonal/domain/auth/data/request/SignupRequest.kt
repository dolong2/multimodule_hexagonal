package multimodule.hexagonal.domain.auth.data.request

data class SignupRequest(
    val email: String,
    val password: String,
    val name: String
)