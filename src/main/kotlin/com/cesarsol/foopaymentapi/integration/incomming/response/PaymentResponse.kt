package com.cesarsol.foopaymentapi.integration.incomming.response

import com.cesarsol.foopaymentapi.domain.enums.PaymentStatus
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import java.math.BigDecimal

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class PaymentResponse (
    val userIdentifier: String,
    val totalAmount: BigDecimal,
    val status: PaymentStatus
)