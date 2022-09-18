package com.cesarsol.foopaymentapi.domain.service

import com.cesarsol.foopaymentapi.integration.outcoming.parameterapi.ParameterApiClient
import com.cesarsol.foopaymentapi.integration.outcoming.parameterapi.ParameterName
import com.cesarsol.foopaymentapi.integration.outcoming.parameterapi.ParameterResponse
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
class ParameterServiceTest {

    @MockK
    private lateinit var client: ParameterApiClient

    @InjectMockKs
    private lateinit var service: ParameterService

    @BeforeEach
    fun setup(){
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun shouldFindById(){
        every { client.getParameter(any()) } returns ParameterResponse("TEST", "1.23")

        val value = service.getDouble(ParameterName.MAX_DEBIT_AMOUNT_REDUCTION)
        Assertions.assertEquals(value, 1.23)
    }
}