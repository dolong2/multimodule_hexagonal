package multimodule.hexagonal.domain.auth.exception

import multimodule.hexagonal.common.error.BasicException
import multimodule.hexagonal.common.error.ErrorCode

class RefreshTokenExpiredException : BasicException(ErrorCode.EXPIRED_TOKEN){
}