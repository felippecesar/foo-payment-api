package com.cesarsol.foopaymentapi.domain.service

import com.cesarsol.foopaymentapi.domain.database.CustomerDebitRepository
import com.cesarsol.foopaymentapi.domain.enums.DebitStatus
import com.cesarsol.foopaymentapi.mocks.entities.CustomerDebitEntityMockFactory.customerDebitEntityList
import com.cesarsol.foopaymentapi.mocks.entities.CustomerEntityMockFactory.customerEntity
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
class CustomerDebitServiceTest {

    @MockK
    private lateinit var repository: CustomerDebitRepository

    @InjectMockKs
    private lateinit var service: CustomerDebitService

    @BeforeEach
    fun setup(){
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun shouldFindAll_whenFindByCustomerId(){
        val debitList = customerDebitEntityList()
        every { repository.findByCustomerId(any()) } returns debitList

        val foundDebitList = service.findByCustomerId(123L)
        Assertions.assertEquals(foundDebitList, debitList)
    }

    @Test
    fun shouldFindAllUnpaid_whenFindUndpaidByCustomerId(){
        val debitList = customerDebitEntityList()
        every { repository.findByCustomerIdAndStatus(any(), any()) } returns debitList

        val foundDebitList = service.findUnpaidByCustomerId(123L)
        Assertions.assertEquals(foundDebitList, debitList)
    }

    @Test
    fun shouldFindUnpaid_whenFindUndpaidByCustomerIdAndCreditorDocumentNotNull(){
        val debitList = customerDebitEntityList()
        every { repository.findByCustomerIdAndCreditorDocumentAndStatusOrderByCreditorDocument(any(), any(), any()) } returns debitList

        val foundDebitList = service.findUnpaid(123L, "TEST")
        Assertions.assertEquals(foundDebitList, debitList)
        verify(exactly = 0) { repository.findByCustomerIdAndStatus(any(), any()) }
        verify(exactly = 1) { repository.findByCustomerIdAndCreditorDocumentAndStatusOrderByCreditorDocument(any(), any(), any()) }
    }

    @Test
    fun shouldFindUnpaid_whenFindUndpaidByCustomerIdAndCreditorDocumentNull(){
        val debitList = customerDebitEntityList()
        every { repository.findByCustomerIdAndStatus(any(), any()) } returns debitList

        val foundDebitList = service.findUnpaid(123L, null)
        Assertions.assertEquals(foundDebitList, debitList)
        verify(exactly = 1) { repository.findByCustomerIdAndStatus(any(), any())}
        verify(exactly = 0) { repository.findByCustomerIdAndCreditorDocumentAndStatusOrderByCreditorDocument(any(), any(), any()) }
    }

    @Test
    fun shouldFindUnpaid_whenFindUndpaidByCustomerIdAndCreditorDocumentBlank(){
        val debitList = customerDebitEntityList()
        every { repository.findByCustomerIdAndStatus(any(), any()) } returns debitList

        val foundDebitList = service.findUnpaid(123L, "   ")
        Assertions.assertEquals(foundDebitList, debitList)
        verify(exactly = 1) { repository.findByCustomerIdAndStatus(any(), any())}
        verify(exactly = 0) { repository.findByCustomerIdAndCreditorDocumentAndStatusOrderByCreditorDocument(any(), any(), any()) }
    }
}