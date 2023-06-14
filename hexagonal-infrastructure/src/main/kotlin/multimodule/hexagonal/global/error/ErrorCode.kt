package multimodule.hexagonal.global.error

enum class ErrorCode(
    val message: String,
    val code: Int
) {
    BAD_REQUEST("잘못된 요청", 400),

    UNAUTHORIZED("권한이 없음", 401),
    EXPIRED_TOKEN("만료된 토큰임", 401),

    FORBIDDEN("금지된 요청", 403),
    NOT_VALID_TOKEN("토큰이 유효하지 않음", 403),

    NOT_FOUND("해당 리소스를 찾을 수 없음", 404),

    INTERNAL_ERROR("서버 내부 에러", 500),
}