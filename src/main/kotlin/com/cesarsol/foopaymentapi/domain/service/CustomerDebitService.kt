package com.cesarsol.foopaymentapi.domain.service

import com.cesarsol.foopaymentapi.domain.database.CustomerDebitRepository
import com.cesarsol.foopaymentapi.domain.database.entity.CustomerDebitEntity
import com.cesarsol.foopaymentapi.domain.enums.DebitStatus
import org.springframework.stereotype.Service

@Service
class CustomerDebitService(val repository: CustomerDebitRepository) {

    fun findByCustomerId(customerId: Long): List<CustomerDebitEntity?> =
        repository.findByCustomerId(customerId)

    fun findUnpaidByCustomerId(customerId: Long) = repository.findByCustomerIdAndStatus(customerId, DebitStatus.UNPAID)

    fun findUnpaid(customerId: Long, creditorDocument: String? = null): List<CustomerDebitEntity> {
        return if (creditorDocument.isNullOrBlank())
            repository.findByCustomerIdAndStatus(customerId, DebitStatus.UNPAID)
        else  repository.findByCustomerIdAndCreditorDocumentAndStatusOrderByCreditorDocument(customerId, creditorDocument, DebitStatus.UNPAID)
    }
}