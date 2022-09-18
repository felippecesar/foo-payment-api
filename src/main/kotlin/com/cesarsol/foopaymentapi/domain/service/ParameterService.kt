package com.cesarsol.foopaymentapi.domain.service

import com.cesarsol.foopaymentapi.integration.outcoming.parameterapi.ParameterApiClient
import com.cesarsol.foopaymentapi.integration.outcoming.parameterapi.ParameterName
import org.springframework.stereotype.Service

@Service
class ParameterService(val parameterApiClient: ParameterApiClient) {
    fun getDouble(parameterName: ParameterName) = parameterApiClient.getParameter(parameterName.name).value.toDouble()
}