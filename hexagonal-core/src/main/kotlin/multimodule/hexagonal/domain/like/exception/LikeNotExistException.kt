package multimodule.hexagonal.domain.like.exception

import multimodule.hexagonal.common.error.BasicException
import multimodule.hexagonal.common.error.ErrorCode

class LikeNotExistException : BasicException(ErrorCode.LIKE_NOT_EXIST) {
}