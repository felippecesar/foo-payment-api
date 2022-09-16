package com.cesarsol.foopaymentapi.integration.incomming

import com.cesarsol.foopaymentapi.business.CustomerDebitsAnalysisFlow
import com.cesarsol.foopaymentapi.business.context.CustomerDebitsListContext
import com.cesarsol.foopaymentapi.domain.service.CustomerDebitService
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

    @GetMapping("/customer/{customerId}/{creditorId}")
    @Operation(
        summary = "[FooPaymentApi] get all debits",
        description = "Get all debits by customer or/and customer + creditor",
        method = "GET"
    )
    fun getAll(
        @PathVariable customerId: Long,
        @PathVariable(required = false) creditorId: String? = null
    ): ResponseEntity<CustomerDebitsResponse> {
        log.info { "m=getAll, customerId=$customerId, creditorId=$creditorId" }
        return ResponseEntity.ok(
            customerDebitsAnalysisFlow.executeFlow(CustomerDebitsListContext(customerId, creditorDocument = null)).response!!
        )
    }

    @GetMapping("/group/{debitorId}/{creditorId}") //TODO recebe uma lista de dívidas
    @Operation(
        summary = "[FooPaymentApi] negotiate offers",
        description = "Get possible negotiation offers and payment simulations",
        method = "GET"
    )
    @Parameters(
        Parameter(name = "TEST_HEADER", `in` = ParameterIn.HEADER, required = false)
    )
    fun group(
        @PathVariable debitorId: String,
        @PathVariable creditorId: String? = null
    ): ResponseEntity<OffersResponse?> {

        log.info { "m=group, debitorId=$debitorId, creditorId=$creditorId" }

        return ResponseEntity.ok(
            null
        )
    }

    @GetMapping("/offers/{debitorId}/{creditorId}")
    @Operation(
        summary = "[FooPaymentApi] negotiate offers",
        description = "Get possible negotiation offers and payment simulations",
        method = "GET"
    )
    @Parameters(
        Parameter(name = "TEST_HEADER", `in` = ParameterIn.HEADER, required = false)
    )
    fun offers(
        @PathVariable debitorId: String,
        @PathVariable creditorId: String? = null
    ): ResponseEntity<OffersResponse?> {

        log.info { "m=offers, debitorId=$debitorId" }

        return ResponseEntity.ok(
            null
        )
    }

}