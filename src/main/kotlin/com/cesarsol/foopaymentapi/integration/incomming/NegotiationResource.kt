package com.cesarsol.foopaymentapi.integration.incomming

import com.cesarsol.foopaymentapi.domain.enums.PaymentStatus
import com.cesarsol.foopaymentapi.integration.incomming.request.PaymentRequest
import com.cesarsol.foopaymentapi.integration.incomming.response.OffersResponse
import com.cesarsol.foopaymentapi.integration.incomming.response.PaymentResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.Parameters
import io.swagger.v3.oas.annotations.enums.ParameterIn
import mu.KLogger
import mu.KotlinLogging
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/negotiation")
class NegotiationResource {

    private val log: KLogger = KotlinLogging.logger { }


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