package multimodule.hexagonal.domain.posting.exception

import multimodule.hexagonal.common.error.BasicException
import multimodule.hexagonal.common.error.ErrorCode

class WriterNotSameException : BasicException(ErrorCode.NOT_SAME_WRITER) {
}