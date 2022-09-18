package com.cesarsol.foopaymentapi.business.command

import com.cesarsol.foopaymentapi.business.context.CustomerDebitsListContext
import com.cesarsol.foopaymentapi.domain.service.CustomerDebitService
import com.cesarsol.foopaymentapi.domain.service.ParameterService
import com.cesarsol.foopaymentapi.integration.incomming.response.CustomerDebit
import com.cesarsol.foopaymentapi.integration.incomming.response.CustomerDebitsResponse
import com.cesarsol.foopaymentapi.integration.incomming.response.Proposal
import com.cesarsol.foopaymentapi.integration.outcoming.parameterapi.ParameterName
import com.cesarsol.foopaymentapi.integration.outcoming.productsalesservice.ProductOfferResponse
import mu.KLogger
import mu.KotlinLogging
import org.springframework.stereotype.Component
import java.math.BigDecimal

@Component
class ProposalGeneratorCommand(
    private val customerDebitService: CustomerDebitService,
    private val parameterService: ParameterService
) :
    BaseCommand<CustomerDebitsListContext> {

    private val log: KLogger = KotlinLogging.logger { }

    override fun execute(context: CustomerDebitsListContext): CustomerDebitsListContext {
        log.info { "m=execute, step=BEGIN, context=$context" }

        val maxAmountReduction = parameterService.getDouble(ParameterName.MAX_DEBIT_AMOUNT_REDUCTION)
        val defaultMonthlyTax = parameterService.getDouble(ParameterName.DEFAULT_DEBIT_MONTHLY_TAX)

        val selectedDebitsPercent = getSelectedDebitsPercent(context)
        var maxMonthlyTax = getMaxMonthlyTax(context, defaultMonthlyTax)
        var minMonthlyTax = getMinMonthlyTax(context, defaultMonthlyTax)

        val totalDebitAmount = context.customerDebits!!.sumOf { it.amount }
        val proposedAmount =
            BigDecimal(totalDebitAmount.toDouble() * (1 - (maxAmountReduction * selectedDebitsPercent)))
        context.response = CustomerDebitsResponse(
            customerId = context.customerId,
            customerName = context.customerDebits!!.first().customer.name,
            totalAmount = totalDebitAmount,
            proposedAmount = proposedAmount,
            maxMonthlyTax = maxMonthlyTax,
            maxYearlyTax = maxMonthlyTax * 12,
            minMonthlyTax = minMonthlyTax,
            minYearlyTax = minMonthlyTax * 12,
            proposedMonthlyTax = defaultMonthlyTax,
            proposedYearlyTax = defaultMonthlyTax * 12,
            debits = context.customerDebits!!.map { CustomerDebit(it) },
            proposals = context.productList!!.map { getProposal(it, proposedAmount) }
        )
        return context
    }

    private fun getSelectedDebitsPercent(context: CustomerDebitsListContext): Double {
        return if (context.creditorDocument.isNullOrBlank()) 1.0
        else context.customerDebits!!.size.toDouble() / customerDebitService.countUnpaid(context.customerId).toDouble()
    }

    private fun getMinMonthlyTax(context: CustomerDebitsListContext, defaultTax: Double): Double {
        val minMonthlyTax = context.customerDebits!!.minOf { it.monthlyTax ?: 0.0 }
        return if (minMonthlyTax > 0.0) minMonthlyTax else defaultTax
    }

    private fun getMaxMonthlyTax(context: CustomerDebitsListContext, defaultTax: Double): Double {
        val maxMonthlyTax = context.customerDebits!!.maxOf { it.monthlyTax ?: 0.0 }
        return if (maxMonthlyTax > 0.0) maxMonthlyTax else defaultTax
    }

    private fun getProposal(
        productOfferResponse: ProductOfferResponse,
        proposedAmount: BigDecimal
    ): Proposal {
        var proposalAmountDeduction = minOf(
            proposedAmount * BigDecimal(productOfferResponse.amountPercentReduction / 2),
            productOfferResponse.maxAmountReduction
        )
        var minAmountDeduction = minOf(
            proposedAmount * BigDecimal(productOfferResponse.amountPercentReduction),
            productOfferResponse.maxAmountReduction
        )
        log.info { "m=getProposal, proposedAmount=$proposedAmount, product=${productOfferResponse}, proposalDeduction=${proposalAmountDeduction}" }
        return Proposal(
            product = productOfferResponse.productName,
            proposedAmount = proposedAmount - proposalAmountDeduction,
            minProposalAmount = proposedAmount - minAmountDeduction
        )
    }

}