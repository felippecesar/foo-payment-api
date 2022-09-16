package com.cesarsol.foopaymentapi.domain.database.entity

import com.cesarsol.foopaymentapi.domain.enums.DebitStatus
import com.cesarsol.foopaymentapi.domain.enums.NotificationWay
import java.io.Serializable
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime
import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.OneToOne
import javax.persistence.PreUpdate
import javax.persistence.Table

@Entity
@Table(name = "TB_CUSTOMER_DEBT")
data class CustomerDebitEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_ID")
    var id: Long? = null,
    @OneToOne(cascade = [CascadeType.MERGE], fetch = FetchType.EAGER)
    @JoinColumn(name = "COD_CUSTOMER_ID")
    var customer: CustomerEntity,
    @Column(name = "NUM_AMOUNT")
    var amount: BigDecimal,
    @Column(name = "NUM_MONTHLY_TAX")
    var monthlyTax: Double? = null,
    @Column(name = "DAT_DUE_DATE")
    var dueDate: LocalDate? = null,
    @Column(name = "NUM_MAX_OVERDUE_DAYS")
    var maxOverdueDays: String? = null,
    @Column(name = "DAT_LAST_NOTIFICATION_DATE")
    var lastNotificationDate: LocalDate? = null,
    @Column(name = "COD_CREDITOR_DOCUMENT")
    var creditorDocument: String? = null,
    @Column(name = "COD_NEGOTIATION_TICKET_ID")
    var negotiationTicketId: Long? = null,
    @Column(name = "DES_STATUS")
    @Enumerated(EnumType.STRING)
    var status: DebitStatus = DebitStatus.UNPAID,
    @Column(name = "DAT_CREATION")
    var createdAt: LocalDateTime = LocalDateTime.now(),
    @Column(name = "DAT_UPDATE")
    var updatedAt: LocalDateTime? = null

) : Serializable {
    @PreUpdate
    fun preUpdate() {
        this.updatedAt = LocalDateTime.now()
    }
}

