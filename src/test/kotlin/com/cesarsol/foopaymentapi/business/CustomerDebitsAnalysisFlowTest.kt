package com.cesarsol.foopaymentapi.business

import com.cesarsol.foopaymentapi.business.command.GetCustomerDebitsCommand
import com.cesarsol.foopaymentapi.business.command.ProductSalesGetCommand
import com.cesarsol.foopaymentapi.business.command.ProposalGeneratorCommand
import com.cesarsol.foopaymentapi.mocks.context.CustomerDebitsListContextMockFactory.customerDebitsListContext
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.MockitoAnnotations

@ExtendWith(MockKExtension::class)
class CustomerDebitsAnalysisFlowTest {

    @MockK
    private lateinit var getCustomerDebitsCommand: GetCustomerDebitsCommand

    @MockK
    private lateinit var productSalesGetCommand: ProductSalesGetCommand

    @MockK
    private lateinit var proposalGeneratorCommand: ProposalGeneratorCommand

    @InjectMockKs
    private lateinit var flow: CustomerDebitsAnalysisFlow

    @BeforeEach
    fun setup() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun shouldRunOk_whenDebitsNotEmpty() {
        val context = customerDebitsListContext()
        every { getCustomerDebitsCommand.execute(any()) } returns context
        every { productSalesGetCommand.execute(any()) } returns context
        every { proposalGeneratorCommand.execute(any()) } returns context
        val returnContext = flow.executeFlow(context)
        Assertions.assertEquals(returnContext, context)
    }

    @Test
    fun shouldThrowError_whenDebitsIsEmpty() {
        val context = customerDebitsListContext()
        val exception = Exception("TEST")
        every { getCustomerDebitsCommand.execute(any()) } throws exception
        val expectedException = assertThrows<Exception> {
            flow.executeFlow(context)
        }
        Assertions.assertEquals(expectedException, exception)
    }
}