package com.cesarsol.foopaymentapi.domain.service

import com.cesarsol.foopaymentapi.domain.database.CustomerDebitRepository
import com.cesarsol.foopaymentapi.mocks.entities.CustomerDebitEntityMockFactory.customerDebitEntityList
import com.cesarsol.foopaymentapi.mocks.entities.CustomerEntityMockFactory.customerEntity
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
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
    fun shouldFindAll_whenFindUndpaidByCustomerId(){
        val debitList = customerDebitEntityList()
        every { repository.findByCustomerIdAndStatus(any(), any()) } returns debitList

        val foundDebitList = service.findUnpaidByCustomerId(123L)
        Assertions.assertEquals(foundDebitList, debitList)
    }
}