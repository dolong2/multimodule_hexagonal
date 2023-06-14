package multimodule.hexagonal.global.error.exception

import multimodule.hexagonal.global.error.ErrorCode

class BasicException(
    val errorCode: ErrorCode
) : RuntimeException()