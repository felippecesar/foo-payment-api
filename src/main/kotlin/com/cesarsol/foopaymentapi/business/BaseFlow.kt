package com.cesarsol.foopaymentapi.business

import com.cesarsol.foopaymentapi.business.context.Metrifiable

interface BaseFlow<T: Metrifiable> {
    fun executeFlow(context: T): T
}