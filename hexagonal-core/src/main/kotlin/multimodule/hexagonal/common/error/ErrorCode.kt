package multimodule.hexagonal.common.error

enum class ErrorCode(
    val message: String,
    val code: Int
) {
    BAD_REQUEST("잘못된 요청", 400),
    INVALID_ROLE("유효하지않은 권한", 400),
    SAME_USER_EXIST("같은 유저가 존재함", 400),
    PASSWORD_NOT_CORRECT("패스워드가 올바르지 않음", 400),
    ALREADY_LIKE_POSTING("이미 좋아요한 게시물", 400),

    UNAUTHORIZED("권한이 없음", 401),
    EXPIRED_TOKEN("만료된 토큰임", 401),

    FORBIDDEN("금지된 요청", 403),
    NOT_VALID_TOKEN("토큰이 유효하지 않음", 403),
    NOT_SAME_WRITER("작성자가 같지 않음", 403),

    NOT_FOUND("해당 리소스를 찾을 수 없음", 404),
    MEMBER_NOT_FOUND("해당 사용자를 찾을 수 없음", 404),
    POSTING_NOT_FOUND("해당 게시물을 찾을 수 없음", 404),

    INTERNAL_ERROR("서버 내부 에러", 500),
}