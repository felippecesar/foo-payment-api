package com.cesarsol.foopaymentapi.domain.database

import com.cesarsol.foopaymentapi.mocks.entities.CustomerEntityMockFactory.customerEntity
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.MockitoAnnotations
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.TestPropertySource

@ExtendWith(MockKExtension::class)
@TestPropertySource(properties = ["wiremock.server.port=0"])
@DataJpaTest
class CustomerRepositoryTest {

    @Autowired
    lateinit var customerRepository: CustomerRepository

    @BeforeEach
    fun setup() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun shouldFindById() {
        var customerEntity = customerEntity()
        customerEntity = customerRepository.save(customerEntity)
        val found = customerRepository.findById(customerEntity.id!!).get()
        Assertions.assertEquals(customerEntity, found)
    }
}