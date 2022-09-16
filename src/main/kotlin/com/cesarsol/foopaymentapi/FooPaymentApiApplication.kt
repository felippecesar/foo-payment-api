package com.cesarsol.foopaymentapi

import com.cesarsol.foopaymentapi.integration.outcoming.productsalesservice.ProductSalesServiceClient
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.transaction.annotation.EnableTransactionManagement

@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories("com.cesarsol.foopaymentapi.domain.database")
@EntityScan("com.cesarsol.foopaymentapi.domain.database.entity")
@EnableFeignClients(
	clients = [ProductSalesServiceClient::class]
)
class FooPaymentApiApplication

fun main(args: Array<String>) {
	runApplication<FooPaymentApiApplication>(*args)
}
