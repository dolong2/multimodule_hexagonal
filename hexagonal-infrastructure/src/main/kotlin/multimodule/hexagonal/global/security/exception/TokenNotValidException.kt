package multimodule.hexagonal.global.security.exception

import multimodule.hexagonal.global.error.ErrorCode
import multimodule.hexagonal.global.error.exception.BasicException

class TokenNotValidException : BasicException(ErrorCode.NOT_VALID_TOKEN) {
}