package com.cesarsol.foopaymentapi

import com.cesarsol.foopaymentapi.integration.outcoming.productsalesservice.ProductSalesServiceClient
import org.junit.jupiter.api.Test
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.transaction.annotation.EnableTransactionManagement

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("com.cesarsol.foopaymentapi.domain.database")
@EntityScan("com.cesarsol.foopaymentapi.domain.database.entity")
@EnableFeignClients(
	clients = [ProductSalesServiceClient::class]
)
class FooPaymentApiApplicationTests {

	@Test
	fun contextLoads() {
	}

}
