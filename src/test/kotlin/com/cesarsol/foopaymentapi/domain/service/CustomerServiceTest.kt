package com.cesarsol.foopaymentapi.domain.service

import com.cesarsol.foopaymentapi.domain.database.CustomerRepository
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
class CustomerServiceTest {

    @MockK
    private lateinit var repository: CustomerRepository

    @InjectMockKs
    private lateinit var service: CustomerService

    @BeforeEach
    fun setup(){
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun shouldFindById(){
        val customerEntity = customerEntity()
        every { repository.findByDocument(any()) } returns customerEntity

        val customer = service.findByDocument("TEST")
        Assertions.assertEquals(customer, customerEntity)
    }
}