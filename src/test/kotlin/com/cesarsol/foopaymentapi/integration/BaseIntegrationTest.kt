package com.cesarsol.foopaymentapi.integration

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock
import org.springframework.core.env.Environment
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWireMock(port = 0, stubs = ["classpath:/stubs/mappings"])
class BaseIntegrationTest {

    @Autowired
    protected lateinit var testRestTemplate: TestRestTemplate

    @Autowired
    private lateinit var environment: Environment

    fun getWiremockPort() = environment.getProperty("wiremock.server.port")

    @Test
    fun shouldPopulateEnvironmentWithWiremockPort() {
        Assertions.assertThat(environment.containsProperty("wiremock.server.port")).isTrue()
        Assertions.assertThat(environment.getProperty("wiremock.server.port")).matches("\\d+")
    }
}