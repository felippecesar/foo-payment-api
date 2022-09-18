package com.cesarsol.foopaymentapi.integration.outcoming.productsaleservice

import com.cesarsol.foopaymentapi.integration.BaseIntegrationTest
import com.cesarsol.foopaymentapi.integration.outcoming.productsalesservice.ProductSalesServiceClient
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

class ProductSalesServiceClientITest: BaseIntegrationTest() {

    @Autowired
    private lateinit var productSalesServiceClient: ProductSalesServiceClient

    @Test
    fun shouldGetParameter_whenServiceCalled(){
        val response = productSalesServiceClient.getProducts(1, 200)
        Assertions.assertEquals(response.size, 2)
    }
}