package com.cesarsol.foopaymentapi.integration.incomming

import com.cesarsol.foopaymentapi.business.CustomerDebitsAnalysisFlow
import com.cesarsol.foopaymentapi.business.context.CustomerDebitsListContext
import com.cesarsol.foopaymentapi.integration.incomming.response.CustomerDebitsResponse
import com.cesarsol.foopaymentapi.integration.incomming.response.OffersResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.Parameters
import io.swagger.v3.oas.annotations.enums.ParameterIn
import mu.KLogger
import mu.KotlinLogging
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/debits")
class DebitsResource(val customerDebitsAnalysisFlow: CustomerDebitsAnalysisFlow) {

    private val log: KLogger = KotlinLogging.logger { }

    @GetMapping("/customer/{customerId}")
    @Operation(
        summary = "[FooPaymentApi] get all debits",
        description = "Get all debits by customer or/and customer + creditor",
        method = "GET"
    )
    fun getAll(
        @PathVariable customerId: Long
    ): ResponseEntity<CustomerDebitsResponse> {
        log.info { "m=getAll, customerId=$customerId" }
        return ResponseEntity.ok(
            customerDebitsAnalysisFlow.executeFlow(CustomerDebitsListContext(customerId, creditorDocument = null)).response!!
        )
    }

    @GetMapping("/customer/{customerId}/{creditorId}")
    @Operation(
        summary = "[FooPaymentApi] get all debits",
        description = "Get all debits by customer or/and customer + creditor",
        method = "GET"
    )
    fun getByCreditor(
        @PathVariable customerId: Long,
        @PathVariable creditorId: String
    ): ResponseEntity<CustomerDebitsResponse> {
        log.info { "m=getAll, customerId=$customerId, creditorId=$creditorId" }
        return ResponseEntity.ok(
            customerDebitsAnalysisFlow.executeFlow(CustomerDebitsListContext(customerId, creditorDocument = creditorId)).response!!
        )
    }

}