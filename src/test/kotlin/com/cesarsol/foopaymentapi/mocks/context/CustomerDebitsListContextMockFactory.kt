package com.cesarsol.foopaymentapi.mocks.context

import com.cesarsol.foopaymentapi.business.context.CustomerDebitsListContext
import com.cesarsol.foopaymentapi.domain.database.entity.CustomerDebitEntity
import com.cesarsol.foopaymentapi.integration.outcoming.productsalesservice.ProductOfferResponse

object CustomerDebitsListContextMockFactory {

    fun customerDebitsListContext(
        customerId: Long = 123L,
        creditorDocument: String? = null,
        customerDebits: List<CustomerDebitEntity>? = null,
        productList: List<ProductOfferResponse>? = null,
    ): CustomerDebitsListContext {
        val context = CustomerDebitsListContext(
            customerId = customerId,
            creditorDocument = creditorDocument
        )
        context.customerDebits = customerDebits
        context.productList = productList
        return context
    }
}