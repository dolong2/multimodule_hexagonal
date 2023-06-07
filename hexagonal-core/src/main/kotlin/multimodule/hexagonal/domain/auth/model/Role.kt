package multimodule.hexagonal.domain.auth.model

enum class Role(description: String) {
    ROLE_ADMIN("관리자"),
    ROLE_MEMBER("일반 유저")
}