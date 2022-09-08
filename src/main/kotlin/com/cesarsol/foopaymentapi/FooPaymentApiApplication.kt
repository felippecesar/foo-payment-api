package com.cesarsol.foopaymentapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FooPaymentApiApplication

fun main(args: Array<String>) {
	runApplication<FooPaymentApiApplication>(*args)
}
