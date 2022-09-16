package com.cesarsol.foopaymentapi.business.command

import com.cesarsol.foopaymentapi.business.context.CustomerDebitsListContext
import com.cesarsol.foopaymentapi.domain.service.CustomerDebitService
import mu.KLogger
import mu.KotlinLogging
import org.springframework.stereotype.Component

@Component
class GetCustomerDebitsCommand(private val customerDebitService: CustomerDebitService) : BaseCommand<CustomerDebitsListContext> {

    private val log: KLogger = KotlinLogging.logger { }

    override fun execute(context: CustomerDebitsListContext): CustomerDebitsListContext {
        log.info { "m=execute, step=BEGIN, context=$context" }
        context.customerDebits = customerDebitService.findUnpaid(context.customerId, context.creditorDocument)
        return context
    }

}