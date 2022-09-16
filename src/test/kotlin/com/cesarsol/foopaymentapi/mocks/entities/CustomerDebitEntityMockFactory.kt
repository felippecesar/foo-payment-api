package com.cesarsol.foopaymentapi.mocks.entities

import com.cesarsol.foopaymentapi.domain.database.entity.CustomerDebitEntity
import com.cesarsol.foopaymentapi.domain.database.entity.CustomerEntity
import com.cesarsol.foopaymentapi.domain.enums.DebitStatus
import com.cesarsol.foopaymentapi.domain.enums.NotificationWay
import com.cesarsol.foopaymentapi.mocks.entities.CustomerEntityMockFactory.customerEntity
import java.math.BigDecimal
import java.time.LocalDate
import javax.persistence.Column
import javax.persistence.EnumType
import javax.persistence.Enumerated

object CustomerDebitEntityMockFactory {

    fun customerDebitEntity(
        customer: CustomerEntity = customerEntity(),
        amount: BigDecimal = BigDecimal.TEN,
        monthlyTax: Double? = 1.23,
        dueDate: LocalDate? = null,
        maxOverdueDays: String? = null,
        lastNotificationDate: LocalDate? = null,
        creditorDocument: String? = null,
        negotiationTicketId: Long? = null,
        status: DebitStatus = DebitStatus.UNPAID,
    ) = CustomerDebitEntity(
        customer = customer,
        amount = amount,
        monthlyTax = monthlyTax,
        dueDate = dueDate,
        maxOverdueDays = maxOverdueDays,
        lastNotificationDate = lastNotificationDate,
        creditorDocument = creditorDocument,
        negotiationTicketId = negotiationTicketId,
        status = status
    )

    fun customerDebitEntityList(
        customer: CustomerEntity = customerEntity(),
        statusList: List<DebitStatus> = listOf(
            DebitStatus.UNPAID,
            DebitStatus.ACCEPTED_OFFER
        )
    ) : List<CustomerDebitEntity> {
        return statusList.map { debitStatus -> customerDebitEntity(customer = customer, status = debitStatus) }
    }

}