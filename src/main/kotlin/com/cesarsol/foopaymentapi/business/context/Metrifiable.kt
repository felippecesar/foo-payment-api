package com.cesarsol.foopaymentapi.business.context

interface Metrifiable {
    fun metricName(success: Boolean = true): String
    fun metricData(exception: Throwable? = null): Map<String, Any?>
}