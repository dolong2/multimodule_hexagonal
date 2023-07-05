package multimodule.hexagonal.domain.auth.exception

import multimodule.hexagonal.common.error.BasicException
import multimodule.hexagonal.common.error.ErrorCode

class SameUserExistsException : BasicException(ErrorCode.SAME_USER_EXIST) {
}