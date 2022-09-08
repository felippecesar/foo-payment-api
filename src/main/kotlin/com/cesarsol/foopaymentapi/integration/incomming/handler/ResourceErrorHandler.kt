package com.cesarsol.foopaymentapi.integration.incomming.handler

import com.cesarsol.foopaymentapi.integration.incomming.response.ErrorDescription
import com.cesarsol.foopaymentapi.integration.incomming.response.ErrorResponse
import mu.KLogger
import mu.KotlinLogging
import org.springframework.http.HttpRequest
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
        return ErrorResponse(ErrorDescription.DEFAULT_ERROR)
    }
}