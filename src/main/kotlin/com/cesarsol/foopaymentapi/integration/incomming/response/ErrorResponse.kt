package com.cesarsol.foopaymentapi.integration.incomming.response

import com.cesarsol.foopaymentapi.domain.exception.BusinessError

data class ErrorResponse(val code: String, val description: String) {
    constructor(errorDescription: BusinessError): this(errorDescription.code, errorDescription.message)
}