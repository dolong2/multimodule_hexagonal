package multimodule.hexagonal.global.error.handler

import jakarta.servlet.http.HttpServletRequest
import multimodule.hexagonal.common.error.BasicException
import multimodule.hexagonal.common.error.ErrorCode
import multimodule.hexagonal.global.error.response.ErrorResponse
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class BasicExceptionHandler {
    private val log: Logger = LoggerFactory.getLogger(this::class.simpleName)
    @ExceptionHandler(BasicException::class)
    fun handleBasicException(request: HttpServletRequest, ex: BasicException): ErrorResponse {
        log.error(request.method)
        log.error(request.requestURI)
        log.error(ex.errorCode.message)
        return ErrorResponse(ex.errorCode)
    }

    @ExceptionHandler(Exception::class)
    fun handleBasicException(request: HttpServletRequest, ex: Exception): ErrorResponse {
        log.error(request.method)
        log.error(request.requestURI)
        ex.printStackTrace()
        return ErrorResponse(ErrorCode.INTERNAL_ERROR)
    }

    @ExceptionHandler(HttpMessageNotReadableException::class)
    fun handleHttpMessageNotReadableException(request: HttpServletRequest, ex: HttpMessageNotReadableException): ErrorResponse {
        log.error(request.method)
        log.error(request.requestURI)
        ex.printStackTrace()
        return ErrorResponse(ErrorCode.BAD_REQUEST)
    }
}