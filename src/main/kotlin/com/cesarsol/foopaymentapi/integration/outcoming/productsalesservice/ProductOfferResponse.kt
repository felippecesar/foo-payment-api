package com.cesarsol.foopaymentapi.integration.outcoming.productsalesservice

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming
import java.math.BigDecimal

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class ProductOfferResponse(
    val productName: String,
    val amountPercentReduction: Double,
    val maxAmountReduction: BigDecimal
)

