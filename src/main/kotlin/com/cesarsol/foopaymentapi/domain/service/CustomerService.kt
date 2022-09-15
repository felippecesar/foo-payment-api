package com.cesarsol.foopaymentapi.domain.service

import com.cesarsol.foopaymentapi.domain.database.CustomerRepository
import com.cesarsol.foopaymentapi.domain.enums.DebitStatus
import org.springframework.stereotype.Service

@Service
class CustomerService(val repository: CustomerRepository) {
    fun findByDocument(document: String) = repository.findByDocument(document)
}