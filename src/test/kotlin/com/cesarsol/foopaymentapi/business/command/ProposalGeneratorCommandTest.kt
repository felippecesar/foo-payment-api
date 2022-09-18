package com.cesarsol.foopaymentapi.business.command

import com.cesarsol.foopaymentapi.domain.service.CustomerDebitService
import com.cesarsol.foopaymentapi.domain.service.ParameterService
import com.cesarsol.foopaymentapi.integration.outcoming.parameterapi.ParameterName
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
class ProposalGeneratorCommandTest {

    @MockK
    private lateinit var customerDebitService: CustomerDebitService

    @MockK
    private lateinit var parameterService: ParameterService

    @InjectMockKs
    private lateinit var command: ProposalGeneratorCommand

    @BeforeEach
    fun setup() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun shouldGetResponseWithProposalsAndDebits() {
        val context = customerDebitsListContext(customerDebits = customerDebitEntityList(), productList = productOfferResponse())
        val productOfferResponse = productOfferResponse()
        every { parameterService.getDouble(any()) } returns 0.5
        every { customerDebitService.countUnpaid(any()) } returns context.customerDebits!!.size
        command.execute(context)
        Assertions.assertNotNull(context.response)
        Assertions.assertEquals(context.response!!.proposals.size, productOfferResponse.size)
        Assertions.assertEquals(context.response!!.debits.size, context.customerDebits!!.size)
    }

}