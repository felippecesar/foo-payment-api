package com.cesarsol.foopaymentapi.integration.incomming.response

enum class ErrorDescription(val code: String, val description: String){
    DEFAULT_ERROR("9999", "Erro ao executar requisicao")
}

data class ErrorResponse(val code: String, val description: String) {
    constructor(errorDescription: ErrorDescription): this(errorDescription.code, errorDescription.description)
}