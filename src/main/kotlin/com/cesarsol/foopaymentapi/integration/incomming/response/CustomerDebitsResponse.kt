package com.cesarsol.foopaymentapi.integration.incomming.response

import com.cesarsol.foopaymentapi.domain.enums.DebitStatus
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import java.math.BigDecimal
import java.time.LocalDate

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class CustomerDebitsResponse (
    val customerId: String,
    val totalAmount: BigDecimal,
    val maxMonthlyTax: BigDecimal,
    val maxYearlyTax: BigDecimal,
    val minMonthlyTax: BigDecimal,
    val minYearlyTax: BigDecimal,

    val debits: List<CustomerDebit>,
    val proposals: List<Proposal>
)


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class CustomerDebit (
    val id: Long,
    val amount: BigDecimal,
    val monthlyTax: BigDecimal? = null,
    val dueDate: LocalDate? = null,
    val maxOverdueDays: String? = null,
    val lastNotificationDate: LocalDate? = null,
    val creditorDocument: String? = null,
    val negotiationTicketId: Long? = null,
    val status: DebitStatus,
)

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class Proposal(
    val identifier: String,
    val product: String? = null,
    val proposedMonthlyTax:BigDecimal,
    val proposedYearlyTax:BigDecimal,
    val minMonthlyTax: BigDecimal,
    val minYearlyTax: BigDecimal
)