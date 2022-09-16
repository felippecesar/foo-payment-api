package com.cesarsol.foopaymentapi.business.command

import com.cesarsol.foopaymentapi.business.context.CustomerDebitsListContext
import com.cesarsol.foopaymentapi.domain.service.CustomerDebitService
import com.cesarsol.foopaymentapi.integration.incomming.response.CustomerDebit
import com.cesarsol.foopaymentapi.integration.incomming.response.CustomerDebitsResponse
import com.cesarsol.foopaymentapi.integration.incomming.response.Proposal
import com.cesarsol.foopaymentapi.integration.outcoming.productsalesservice.ProductOfferResponse
import mu.KLogger
import mu.KotlinLogging
import org.springframework.stereotype.Component
import java.math.BigDecimal

@Component
class ProposalGeneratorCommand(private val customerDebitService: CustomerDebitService) :
    BaseCommand<CustomerDebitsListContext> {

    //TODO MOVE TO WIREMOCK
    companion object {
        const val MAX_AMOUNT_REDUCTION = 0.3 //30%
        const val DEFAULT_MONTHLY_TAX = 3.89 //3.89%
    }

    private val log: KLogger = KotlinLogging.logger { }

    override fun execute(context: CustomerDebitsListContext): CustomerDebitsListContext {
        log.info { "m=execute, step=BEGIN, context=$context" }
        val selectedDebitsPercent = getSelectedDebitsPercent(context)
        var maxMonthlyTax = getMaxMonthlyTax(context)
        var minMonthlyTax = getMinMonthlyTax(context)

        val totalDebitAmount = context.customerDebits!!.sumOf { it.amount }
        val proposedAmount =
            BigDecimal(totalDebitAmount.toDouble() * (1 - (MAX_AMOUNT_REDUCTION * selectedDebitsPercent)))
        context.response = CustomerDebitsResponse(
            customerId = context.customerId,
            customerName = context.customerDebits!!.first().customer.name,
            totalAmount = totalDebitAmount,
            proposedAmount = proposedAmount,
            maxMonthlyTax = maxMonthlyTax,
            maxYearlyTax = maxMonthlyTax * 12,
            minMonthlyTax = minMonthlyTax,
            minYearlyTax = minMonthlyTax * 12,
            proposedMonthlyTax = DEFAULT_MONTHLY_TAX,
            proposedYearlyTax = DEFAULT_MONTHLY_TAX * 12,
            debits = context.customerDebits!!.map { CustomerDebit(it) },
            proposals = context.productList!!.map { getProposal(it, proposedAmount) }
        )
        //TODO TAX REDUCTION = WILL INCREASE UNTIL MAX TAX, DEPENDING ON HOW MANY DEBITS HE SELECT.
        //TODO APPLY PRODUCT TAX REDUCTIONS.
        return context
    }

    private fun getSelectedDebitsPercent(context: CustomerDebitsListContext): Double {
        return if (context.creditorDocument.isNullOrBlank()) 1.0
        else context.customerDebits!!.size.toDouble() / customerDebitService.countUnpaid(context.customerId).toDouble()
    }

    private fun getMinMonthlyTax(context: CustomerDebitsListContext): Double {
        val minMonthlyTax = context.customerDebits!!.minOf { it.monthlyTax ?: 0.0 }
        return if (minMonthlyTax > 0.0) minMonthlyTax else DEFAULT_MONTHLY_TAX
    }

    private fun getMaxMonthlyTax(context: CustomerDebitsListContext): Double {
        val maxMonthlyTax = context.customerDebits!!.maxOf { it.monthlyTax ?: 0.0 }
        return if (maxMonthlyTax > 0.0) maxMonthlyTax else DEFAULT_MONTHLY_TAX
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
        return Proposal(
            product = productOfferResponse.productName,
            proposedAmount = proposedAmount - proposalAmountDeduction,
            minProposalAmount = proposedAmount - minAmountDeduction
        )
    }

}