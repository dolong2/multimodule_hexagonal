package multimodule.hexagonal.global.security.exception

import multimodule.hexagonal.common.error.ErrorCode
import multimodule.hexagonal.common.error.BasicException

class InvalidRoleException : BasicException(ErrorCode.INVALID_ROLE) {
}