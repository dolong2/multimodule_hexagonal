package multimodule.hexagonal.common.service.exception

import multimodule.hexagonal.common.error.BasicException
import multimodule.hexagonal.common.error.ErrorCode

class PasswordNotCorrectException : BasicException(ErrorCode.PASSWORD_NOT_CORRECT) {
}