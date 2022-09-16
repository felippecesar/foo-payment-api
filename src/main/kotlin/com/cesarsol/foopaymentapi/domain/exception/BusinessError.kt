package com.cesarsol.foopaymentapi.domain.exception

enum class BusinessError(val code: String, val message: String) {
    DEFAULT_ERROR("9999", "Erro ao executar requisicao"),
    USER_NOT_FOUND("0001", "Usuario nao encontrado na base"),
    NO_DEBITS_FOR_CREDITOR("0002", "Usuario nao tem pendencias com este fornecedor.")
}