package com.cesarsol.foopaymentapi.business.context

import com.cesarsol.foopaymentapi.domain.database.entity.CustomerDebitEntity
import com.cesarsol.foopaymentapi.domain.enums.MetricName
import com.cesarsol.foopaymentapi.integration.incomming.response.CustomerDebitsResponse

data class CustomerDebitsListContext(
    val customerId: Long,
    var creditorDocument: String? = null
) : Metrifiable {

    var customerDebits: List<CustomerDebitEntity>? = null
    var response: CustomerDebitsResponse? = null

    override fun metricName(success: Boolean): String {
        return MetricName.GET_CUSTOMER_DEBITS.identifier
    }

    override fun metricData(exception: Throwable?): Map<String, Any?> {
        return mutableMapOf(
            "CDEBS_CUSTOMER_ID" to customerId,
            "CDEBS_CREDITOR_ID" to creditorDocument,
            "CDEBS_ERROR" to exception?.toString()
        )
    }

}
