package com.cesarsol.foopaymentapi

import org.junit.jupiter.api.Test
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.transaction.annotation.EnableTransactionManagement

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("com.cesarsol.foopaymentapi.domain.database")
@EntityScan("com.cesarsol.foopaymentapi.domain.database.entity")
class FooPaymentApiApplicationTests {

	@Test
	fun contextLoads() {
	}

}
