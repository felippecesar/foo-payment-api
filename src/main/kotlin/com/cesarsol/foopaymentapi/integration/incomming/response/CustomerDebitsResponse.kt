package com.cesarsol.foopaymentapi.integration.incomming.response

import com.cesarsol.foopaymentapi.domain.database.entity.CustomerDebitEntity
import com.cesarsol.foopaymentapi.domain.enums.DebitStatus
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import java.math.BigDecimal
import java.time.LocalDate

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class CustomerDebitsResponse (
    val customerId: Long,
    val customerName: String,
    val totalAmount: BigDecimal,
    val proposedAmount: BigDecimal,
    val maxMonthlyTax: Double,
    val maxYearlyTax: Double,
    val minMonthlyTax: Double,
    val minYearlyTax: Double,
    val proposedMonthlyTax:Double,
    val proposedYearlyTax:Double,
    val debits: List<CustomerDebit>,
    val proposals: List<Proposal>
)


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class CustomerDebit (
    val id: Long?,
    val amount: BigDecimal,
    val monthlyTax: Double? = null,
    val dueDate: LocalDate? = null,
    val maxOverdueDays: String? = null,
    val lastNotificationDate: LocalDate? = null,
    val creditorDocument: String? = null,
    val negotiationTicketId: Long? = null,
    val status: DebitStatus,
) {
    constructor(entity: CustomerDebitEntity): this(
        id = entity.id,
        amount = entity.amount,
        monthlyTax = entity.monthlyTax,
        dueDate = entity.dueDate,
        maxOverdueDays = entity.maxOverdueDays,
        lastNotificationDate = entity.lastNotificationDate,
        creditorDocument = entity.creditorDocument,
        negotiationTicketId = entity.negotiationTicketId,
        status = entity.status
    )
}

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class Proposal(
    val identifier: String? = null,
    val product: String? = null,
    val proposedAmount:BigDecimal,
    val minProposalAmount: BigDecimal,
)