package com.cesarsol.foopaymentapi.integration.outcoming.productsalesservice

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(
    name = "productSalesServiceClient",
    url = "\${integration.product-sale-service.url}"
)
interface ProductSalesServiceClient {

    @GetMapping("/offers/{customerId}/debit/{profileScore}")
    fun getProducts(
        @PathVariable customerId: Long,
        @PathVariable profileScore: Int,
    ): List<ProductOfferResponse>
}
