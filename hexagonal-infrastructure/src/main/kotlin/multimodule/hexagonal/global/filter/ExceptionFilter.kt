package multimodule.hexagonal.global.filter

import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import multimodule.hexagonal.global.error.ErrorCode
import multimodule.hexagonal.global.error.exception.BasicException
import multimodule.hexagonal.global.error.response.ErrorResponse
import org.springframework.web.filter.OncePerRequestFilter

class ExceptionFilter(
    private val objectMapper: ObjectMapper
) : OncePerRequestFilter() {
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain,
    ) {
        try {
            filterChain.doFilter(request, response)
        } catch (ex: Exception) {
            when (ex) {
                is BasicException -> {
                    writeErrorResponse(response, ex)
                }
                else -> {
                    writeErrorResponse(response, BasicException(ErrorCode.INTERNAL_ERROR))
                }
            }
        }
    }

    private fun writeErrorResponse(response: HttpServletResponse, exception: BasicException) {
        val errorCode = exception.errorCode
        val responseBody = objectMapper.writeValueAsString(ErrorResponse(errorCode))
        response.status = errorCode.code
        response.characterEncoding = Charsets.UTF_8.name()
        response.contentType = "application/json"
        response.writer.write(responseBody)
    }
}