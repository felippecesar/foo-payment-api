package com.cesarsol.foopaymentapi.integration.outcoming.parameterapi

import com.cesarsol.foopaymentapi.integration.BaseIntegrationTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

class ParameterApiClientITest: BaseIntegrationTest() {

    @Autowired
    private lateinit var parameterApiClient: ParameterApiClient

    @Test
    fun shouldGetParameter_whenServiceCalled(){
        val response = parameterApiClient.getParameter(ParameterName.MAX_DEBIT_AMOUNT_REDUCTION.name)
        Assertions.assertNotNull(response)
    }
}