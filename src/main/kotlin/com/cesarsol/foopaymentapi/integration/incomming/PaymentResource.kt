package com.cesarsol.foopaymentapi.integration.incomming

import com.cesarsol.foopaymentapi.domain.enums.PaymentStatus
import com.cesarsol.foopaymentapi.integration.incomming.request.PaymentRequest
import com.cesarsol.foopaymentapi.integration.incomming.response.PaymentResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.Parameters
import io.swagger.v3.oas.annotations.enums.ParameterIn
import mu.KLogger
import mu.KotlinLogging
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/payment")
class PaymentResource {

    private val log: KLogger = KotlinLogging.logger { }


    @PostMapping
    @Operation(
        summary = "[FooPaymentApi] execute payment",
        description = "Validates user info and execute payment",
        method = "POST"
    )
    @Parameters(
        Parameter(name = "TEST_HEADER", `in` = ParameterIn.HEADER, required = false)
    )
    fun pay(
        @RequestHeader(value = "TEST_HEADER", required = false) testHeader: String? = null,
        @RequestBody paymentRequest: PaymentRequest
    ): ResponseEntity<PaymentResponse> {

        log.info { "m=pay, request=$paymentRequest" }

        return ResponseEntity.ok(
            PaymentResponse(
                userIdentifier = paymentRequest.userIdentifier,
                totalAmount = paymentRequest.totalAmount,
                status = PaymentStatus.PENDING
            )
        )
    }

}