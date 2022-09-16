package com.cesarsol.foopaymentapi.business.command

import com.cesarsol.foopaymentapi.business.context.CustomerDebitsListContext
import com.cesarsol.foopaymentapi.domain.service.CustomerDebitService
import mu.KLogger
import mu.KotlinLogging
import org.springframework.stereotype.Component

@Component
class ProposalGeneratorCommand(private val customerDebitService: CustomerDebitService) : BaseCommand<CustomerDebitsListContext> {

    //TODO MOVE TO WIREMOCK
    companion object {
        const val MAX_TAX_REDUCTION = 0.4 //40%
    }

    private val log: KLogger = KotlinLogging.logger { }

    override fun execute(context: CustomerDebitsListContext): CustomerDebitsListContext {
        log.info { "m=execute, step=BEGIN, context=$context" }
        //TODO COUNT ALL HIS DEBITS,
        //TODO COMPARE WITH SELECTED (context.customerDebits) TO APPLY TAX REDUCTION,
        //TODO TAX REDUCTION = WILL INCREASE UNTIL HALF OF MAX TAX, DEPENDING ON HOW MANY DEBITS HE SELECT.
        //TODO APPLY PRODUCT TAX REDUCTIONS.
        return context
    }

}