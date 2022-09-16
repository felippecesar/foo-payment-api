package com.cesarsol.foopaymentapi.business.command

interface BaseCommand<T> {

    fun execute(context: T): T
}