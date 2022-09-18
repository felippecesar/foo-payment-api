package com.cesarsol.foopaymentapi.integration.outcoming.parameterapi

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(
    name = "parameterApiClient",
    url = "\${integration.parameter-api.url}"
)
interface ParameterApiClient {

    @GetMapping("/parameter/{parameterName}")
    fun getParameter(
        @PathVariable parameterName: String
    ): ParameterResponse
}
