package com.cesarsol.foopaymentapi.integration.incomming

import com.cesarsol.foopaymentapi.domain.database.CustomerRepository
import com.cesarsol.foopaymentapi.domain.database.entity.CustomerEntity
import io.swagger.v3.oas.annotations.Operation
import mu.KLogger
import mu.KotlinLogging
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/customer")
class CustomerResource(
    val repository: CustomerRepository
) {

    private val log: KLogger = KotlinLogging.logger { }

    @GetMapping("/{customerId}")
    @Operation(
        summary = "[FooPaymentApi] get customers",
        description = "Get customers by id or all",
        method = "GET"
    )
    fun find(
        @PathVariable(required = false) customerId: Long?,
    ): ResponseEntity<List<CustomerEntity>> {
        log.info { "m=find, customerId=$customerId" }
        return ResponseEntity.ok(
            if (customerId != null) listOf(repository.findById(customerId).get()) else repository.findAll()
        )
    }

    @GetMapping("/document/{document}")
    @Operation(
        summary = "[FooPaymentApi] get customer by doc",
        description = "Get customers by document number",
        method = "GET"
    )
    fun findByDocument(
        @PathVariable document: String,
    ): ResponseEntity<CustomerEntity> {
        log.info { "m=findByDocument, document=$document" }
        return ResponseEntity.ok(
            repository.findByDocument(document)
        )
    }

}