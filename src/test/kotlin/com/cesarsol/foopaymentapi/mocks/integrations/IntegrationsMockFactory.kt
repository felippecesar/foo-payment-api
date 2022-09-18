package com.cesarsol.foopaymentapi.mocks.integrations

import com.cesarsol.foopaymentapi.business.context.CustomerDebitsListContext
import com.cesarsol.foopaymentapi.domain.database.entity.CustomerDebitEntity
import com.cesarsol.foopaymentapi.integration.outcoming.productsalesservice.ProductOfferResponse
import com.cesarsol.foopaymentapi.mocks.entities.CustomerDebitEntityMockFactory.customerDebitEntityList
import java.math.BigDecimal

object IntegrationsMockFactory {

    fun productOfferResponse() = listOf(
        ProductOfferResponse(
            productName = "PRODUCT_TEST 1",
            amountPercentReduction = 0.1,
            maxAmountReduction = BigDecimal(2000)
        ),
        ProductOfferResponse(
            productName = "PRODUCT_TEST 2",
            amountPercentReduction = 0.2,
            maxAmountReduction = BigDecimal(1000)
        ),
        ProductOfferResponse(
            productName = "PRODUCT_TEST 3",
            amountPercentReduction = 0.3,
            maxAmountReduction = BigDecimal(32000)
        )
    )
}