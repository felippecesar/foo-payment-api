package com.cesarsol.foopaymentapi.integration.incoming

import com.cesarsol.foopaymentapi.domain.database.CustomerDebitRepository
import com.cesarsol.foopaymentapi.domain.exception.BusinessError
import com.cesarsol.foopaymentapi.integration.BaseIntegrationTest
import com.cesarsol.foopaymentapi.integration.incomming.response.CustomerDebitsResponse
import com.cesarsol.foopaymentapi.integration.incomming.response.ErrorResponse
import com.cesarsol.foopaymentapi.mocks.entities.CustomerDebitEntityMockFactory.customerDebitEntityList
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus
import org.springframework.http.RequestEntity
import org.springframework.util.LinkedMultiValueMap
import org.springframework.web.util.UriComponentsBuilder

class DebitsResourceITest : BaseIntegrationTest() {

    @MockkBean
    private lateinit var customerDebitRepository: CustomerDebitRepository

    @Test
    fun shouldGetDebits_whenValidRequest() {

        every {
            customerDebitRepository.findByCustomerIdAndCreditorDocumentAndStatusOrderByCreditorDocument(
                any(),any(),any()
            )
        } returns customerDebitEntityList()

        every {customerDebitRepository.countByCustomerIdAndStatus(any(), any()) } returns 10
        val uri = UriComponentsBuilder.fromPath("/debits/customer/1/12345678").build().toUri()

        val response = testRestTemplate.exchange(
            RequestEntity<String>(LinkedMultiValueMap(), HttpMethod.GET, uri),
            CustomerDebitsResponse::class.java
        )
        Assertions.assertEquals(response.statusCode, HttpStatus.OK)
    }

    @Test
    fun shouldGetError_whenCustomerHasNoDebits() {

        every {
            customerDebitRepository.findByCustomerIdAndCreditorDocumentAndStatusOrderByCreditorDocument(
                any(),any(),any()
            )
        } returns emptyList()

        val uri = UriComponentsBuilder.fromPath("/debits/customer/1/12345678").build().toUri()

        val response = testRestTemplate.exchange(
            RequestEntity<String>(LinkedMultiValueMap(), HttpMethod.GET, uri),
            ErrorResponse::class.java
        )
        Assertions.assertEquals(response.statusCode, HttpStatus.BAD_REQUEST)
        Assertions.assertEquals(response.body!!.code, BusinessError.NO_DEBITS_FOR_CREDITOR.code)
        Assertions.assertEquals(response.body!!.description, BusinessError.NO_DEBITS_FOR_CREDITOR.message)
    }
}