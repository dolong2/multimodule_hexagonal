package multimodule.hexagonal.domain.posting.exception

import multimodule.hexagonal.common.error.BasicException
import multimodule.hexagonal.common.error.ErrorCode

class PostingNotFoundException : BasicException(ErrorCode.POSTING_NOT_FOUND) {
}