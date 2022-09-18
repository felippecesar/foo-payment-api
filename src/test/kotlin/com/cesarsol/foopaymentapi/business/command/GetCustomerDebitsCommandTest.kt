package com.cesarsol.foopaymentapi.business.command

import com.cesarsol.foopaymentapi.domain.exception.BusinessError
import com.cesarsol.foopaymentapi.domain.exception.BusinessException
import com.cesarsol.foopaymentapi.domain.service.CustomerDebitService
import com.cesarsol.foopaymentapi.mocks.context.CustomerDebitsListContextMockFactory.customerDebitsListContext
import com.cesarsol.foopaymentapi.mocks.entities.CustomerDebitEntityMockFactory.customerDebitEntityList
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.verify
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.MockitoAnnotations

@ExtendWith(MockKExtension::class)
class GetCustomerDebitsCommandTest {

    @MockK
    private lateinit var customerDebitService: CustomerDebitService

    @InjectMockKs
    private lateinit var command: GetCustomerDebitsCommand

    @BeforeEach
    fun setup() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun shouldRunOk_whenDebitsNotEmpty() {
        val context = customerDebitsListContext()
        every { customerDebitService.findUnpaid(any(), any()) } returns customerDebitEntityList()
        command.execute(context)
        Assertions.assertNotNull(context.customerDebits)
        verify(exactly = 1) { customerDebitService.findUnpaid(any(), any()) }
    }

    @Test
    fun shouldThrowError_whenDebitsIsEmpty() {
        val context = customerDebitsListContext()
        every { customerDebitService.findUnpaid(any(), any()) } returns emptyList()
        val expectedException = assertThrows<BusinessException> {
            command.execute(context)
        }
        Assertions.assertEquals(expectedException.businessError, BusinessError.NO_DEBITS_FOR_CREDITOR)
        verify(exactly = 1) { customerDebitService.findUnpaid(any(), any()) }
    }
}