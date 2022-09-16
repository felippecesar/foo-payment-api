package com.cesarsol.foopaymentapi.domain.exception

enum class BusinessError(val code: String, val message: String) {
    DEFAULT_ERROR("9999", "Erro ao executar requisicao"),
    USER_NOT_FOUND("0001", "Usuario nao encontrado na base")
}