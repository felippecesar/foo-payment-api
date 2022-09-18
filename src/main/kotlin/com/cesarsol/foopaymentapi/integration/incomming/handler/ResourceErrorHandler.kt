package com.cesarsol.foopaymentapi.integration.incomming.handler

import com.cesarsol.foopaymentapi.domain.exception.BusinessError
import com.cesarsol.foopaymentapi.domain.exception.BusinessException
import com.cesarsol.foopaymentapi.integration.incomming.response.ErrorResponse
import mu.KLogger
import mu.KotlinLogging
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.servlet.http.HttpServletRequest

@RestControllerAdvice
class ResourceErrorHandler {

    val log: KLogger = KotlinLogging.logger { }

    @ExceptionHandler(Exception::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleGeneralException(
        exception: Exception,
        httpRequest: HttpServletRequest
    ): ErrorResponse {
        log.error(exception) { "m=handleGeneralException, error=${exception.message}" }
        return ErrorResponse(BusinessError.DEFAULT_ERROR)
    }

    @ExceptionHandler(BusinessException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleBusinessException(
        exception: BusinessException,
        httpRequest: HttpServletRequest
    ): ErrorResponse {
        log.error(exception) { "m=handleGeneralException, error=${exception.message}" }
        return ErrorResponse(exception.businessError)
    }
}