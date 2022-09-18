package com.cesarsol.foopaymentapi.domain.exception

import java.lang.Exception

class BusinessException(
    val businessError: BusinessError,
    override val message: String? = businessError.message,
    exception: Exception?
) : RuntimeException(businessError.name, exception) {
    constructor(businessError: BusinessError) : this(businessError, businessError.message, null)
    constructor(businessError: BusinessError, exception: Exception) : this(businessError, businessError.message, exception)
}