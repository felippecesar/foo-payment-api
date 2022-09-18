package com.cesarsol.foopaymentapi.business.command

import com.cesarsol.foopaymentapi.business.context.CustomerDebitsListContext
import com.cesarsol.foopaymentapi.domain.service.CustomerDebitService
import com.cesarsol.foopaymentapi.integration.outcoming.productsalesservice.ProductSalesServiceClient
import mu.KLogger
import mu.KotlinLogging
import org.springframework.stereotype.Component

@Component
class ProductSalesGetCommand(
    private val productSalesServiceClient: ProductSalesServiceClient
) : BaseCommand<CustomerDebitsListContext> {

    private val log: KLogger = KotlinLogging.logger { }

    override fun execute(context: CustomerDebitsListContext): CustomerDebitsListContext {
        log.info { "m=execute, step=BEGIN, context=$context" }
        context.productList = try {
            if (!context.customerDebits.isNullOrEmpty()) {
                productSalesServiceClient.getProducts(
                    context.customerId,
                    context.customerDebits!!.first().customer.profileScore
                )
            } else emptyList()
        } catch (e: Exception){
            log.error(e) { "m=execute, step=ERROR, context=$context" }
            emptyList()
        }
        log.info { "m=execute, step=SUCCESS, response=${context.productList}"}
        return context
    }

}