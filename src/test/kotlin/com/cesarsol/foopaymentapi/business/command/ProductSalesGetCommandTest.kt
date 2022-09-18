package com.cesarsol.foopaymentapi.business.command

import com.cesarsol.foopaymentapi.integration.outcoming.productsalesservice.ProductSalesServiceClient
import com.cesarsol.foopaymentapi.mocks.context.CustomerDebitsListContextMockFactory.customerDebitsListContext
import com.cesarsol.foopaymentapi.mocks.entities.CustomerDebitEntityMockFactory.customerDebitEntityList
import com.cesarsol.foopaymentapi.mocks.integrations.IntegrationsMockFactory.productOfferResponse
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.verify
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.MockitoAnnotations

@ExtendWith(MockKExtension::class)
class ProductSalesGetCommandTest {

    @MockK
    private lateinit var productSalesServiceClient: ProductSalesServiceClient

    @InjectMockKs
    private lateinit var command: ProductSalesGetCommand

    @BeforeEach
    fun setup() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun shouldGetList_whenProductsNoError() {
        val context = customerDebitsListContext(customerDebits = customerDebitEntityList())
        val productOfferResponse = productOfferResponse()
        every { productSalesServiceClient.getProducts(any(), any()) } returns productOfferResponse
        command.execute(context)
        Assertions.assertEquals(context.productList, productOfferResponse)
        verify(exactly = 1) { productSalesServiceClient.getProducts(any(), any()) }
    }

    @Test
    fun shouldReturnEmptyList_whenProductsError() {
        val context = customerDebitsListContext(customerDebits = customerDebitEntityList())
        every { productSalesServiceClient.getProducts(any(), any()) } throws RuntimeException("TEST")
        command.execute(context)
        Assertions.assertEquals(context.productList?.size, 0)
        verify(exactly = 1) { productSalesServiceClient.getProducts(any(), any()) }
    }
}