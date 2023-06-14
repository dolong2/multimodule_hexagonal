package multimodule.hexagonal.global.error.response

import multimodule.hexagonal.global.error.ErrorCode

class ErrorResponse(
    val status: Int,
    val message: String
) {
    constructor(errorCode: ErrorCode) : this(errorCode.code, errorCode.message)
}