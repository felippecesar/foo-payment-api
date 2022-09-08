package com.cesarsol.foopaymentapi.integration.incomming.request

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import java.math.BigDecimal

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class PaymentRequest (
    val userIdentifier: String,
    val totalAmount: BigDecimal
)