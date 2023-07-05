package multimodule.hexagonal.common.error

import multimodule.hexagonal.common.error.ErrorCode

open class BasicException(
    val errorCode: ErrorCode
) : RuntimeException()