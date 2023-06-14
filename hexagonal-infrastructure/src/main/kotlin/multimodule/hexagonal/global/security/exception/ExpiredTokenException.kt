package multimodule.hexagonal.global.security.exception

import multimodule.hexagonal.global.error.ErrorCode
import multimodule.hexagonal.global.error.exception.BasicException

class ExpiredTokenException : BasicException(ErrorCode.EXPIRED_TOKEN) {
}