package com.cesarsol.foopaymentapi.domain.database

import com.cesarsol.foopaymentapi.domain.database.entity.CustomerDebitEntity
import com.cesarsol.foopaymentapi.domain.database.entity.CustomerEntity
import com.cesarsol.foopaymentapi.domain.enums.DebitStatus
import com.cesarsol.foopaymentapi.mocks.entities.CustomerDebitEntityMockFactory.customerDebitEntityList
import com.cesarsol.foopaymentapi.mocks.entities.CustomerEntityMockFactory.customerEntity
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.MockitoAnnotations
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.test.context.TestPropertySource

@ExtendWith(MockKExtension::class)
@TestPropertySource(properties = ["wiremock.server.port=0"])
@DataJpaTest
class CustomerDebitRepositoryTest {

    @Autowired
    lateinit var entityManager: TestEntityManager

    @Autowired
    lateinit var customerDebitRepository: CustomerDebitRepository

    @BeforeEach
    fun setup() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun shouldFindAll_whenFindByCustomerId() {
        var savedCustomerDebitEntityList = createDebits()
        val found = customerDebitRepository.findByCustomerId(savedCustomerDebitEntityList[0].customer.id!!)
        Assertions.assertEquals(found.size, 2)
        customerDebitRepository.deleteAll(found)
    }

    @Test
    fun shouldFindOne_whenFindCustomerIdAndStatus() {
        var savedCustomerDebitEntityList = createDebits()
        val found = customerDebitRepository.findByCustomerIdAndStatus(savedCustomerDebitEntityList[0].customer.id!!, DebitStatus.UNPAID)
        Assertions.assertEquals(found.size, 1)
        customerDebitRepository.deleteAll(found)
    }

    private fun createDebits(): List<CustomerDebitEntity> {
        var customerEntity = createCustomer()
        var savedCustomerDebitEntityList = customerDebitEntityList(customerEntity)
        savedCustomerDebitEntityList.forEach { customerDebitRepository.save(it) }
        return savedCustomerDebitEntityList
    }

    private fun createCustomer(): CustomerEntity {
        var customerEntity = customerEntity()
        customerEntity = entityManager.persist(customerEntity)
        entityManager.flush()
        return customerEntity
    }

}