package com.cesarsol.foopaymentapi.domain.database

import com.cesarsol.foopaymentapi.domain.database.entity.CustomerDebitEntity
import com.cesarsol.foopaymentapi.domain.enums.DebitStatus
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerDebitRepository : JpaRepository<CustomerDebitEntity, Long> {

    fun findByCustomerId(id: Long) : List<CustomerDebitEntity>

    fun findByCustomerIdAndStatus(id: Long, status: DebitStatus) : List<CustomerDebitEntity>

    fun findByCustomerIdAndCreditorDocumentAndStatusOrderByCreditorDocument(id: Long, creditorDocument: String, status: DebitStatus) : List<CustomerDebitEntity>

    fun countByCustomerIdAndStatus(id: Long, status: DebitStatus): Int
}