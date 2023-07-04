package multimodule.hexagonal.domain.auth.dto.request

data class SignUpData(
    val email: String,
    val name: String,
    val password: String
)
