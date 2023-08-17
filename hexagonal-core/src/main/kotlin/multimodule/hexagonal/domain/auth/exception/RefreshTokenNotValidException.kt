package multimodule.hexagonal.domain.auth.exception

import multimodule.hexagonal.common.error.BasicException
import multimodule.hexagonal.common.error.ErrorCode

class RefreshTokenNotValidException : BasicException(ErrorCode.NOT_VALID_TOKEN) {
}