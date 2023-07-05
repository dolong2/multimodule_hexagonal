package multimodule.hexagonal.global.security.exception

import multimodule.hexagonal.common.error.ErrorCode
import multimodule.hexagonal.common.error.BasicException

class TokenNotValidException : BasicException(ErrorCode.NOT_VALID_TOKEN) {
}