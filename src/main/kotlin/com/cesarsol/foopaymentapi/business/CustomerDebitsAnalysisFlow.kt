package com.cesarsol.foopaymentapi.business

import com.cesarsol.foopaymentapi.business.command.GetCustomerDebitsCommand
import com.cesarsol.foopaymentapi.business.command.ProductSalesGetCommand
import com.cesarsol.foopaymentapi.business.command.ProposalGeneratorCommand
import com.cesarsol.foopaymentapi.business.context.CustomerDebitsListContext
import mu.KLogger
import mu.KotlinLogging
import org.springframework.stereotype.Component

@Component
class CustomerDebitsAnalysisFlow(
    private val getCustomerDebitsCommand: GetCustomerDebitsCommand,
    private val productSalesGetCommand: ProductSalesGetCommand,
    private val proposalGeneratorCommand: ProposalGeneratorCommand,
): BaseFlow<CustomerDebitsListContext> {

    private val log: KLogger = KotlinLogging.logger { }

    override fun executeFlow(context: CustomerDebitsListContext): CustomerDebitsListContext {
        log.info { "m=executeFlow, step=BEGIN context=$context" }
        //TODO TRY CATCH
        getCustomerDebitsCommand.execute(context)
        productSalesGetCommand.execute(context)
        proposalGeneratorCommand.execute(context)
        //TODO METRICS
        return context
    }
}