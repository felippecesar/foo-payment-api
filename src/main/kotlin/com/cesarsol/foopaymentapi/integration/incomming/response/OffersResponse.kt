package com.cesarsol.foopaymentapi.integration.incomming.response

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import java.math.BigDecimal

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class OffersResponse (
    val debtAmount: BigDecimal,
    val monthlyTax: BigDecimal,
    val monthlyAmount: BigDecimal,
    val totalAmount: BigDecimal,
    val possibleInstalmentsQuantity: List<Int>, //score based
    val maxProductsQuantity: Int,
    val offerId: String
)