package multimodule.hexagonal.domain.like.exception

import multimodule.hexagonal.common.error.BasicException
import multimodule.hexagonal.common.error.ErrorCode

class AlreadyLikePostingException : BasicException(ErrorCode.ALREADY_LIKE_POSTING) {
}