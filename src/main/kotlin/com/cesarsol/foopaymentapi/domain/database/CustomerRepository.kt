package com.cesarsol.foopaymentapi.domain.database

import com.cesarsol.foopaymentapi.domain.database.entity.CustomerEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepository : JpaRepository<CustomerEntity, Long> {
    fun findByDocument(document: String): CustomerEntity?
}