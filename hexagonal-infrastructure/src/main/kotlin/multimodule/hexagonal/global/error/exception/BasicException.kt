package multimodule.hexagonal.global.error.exception

import multimodule.hexagonal.global.error.ErrorCode

open class BasicException(
    val errorCode: ErrorCode
) : RuntimeException()