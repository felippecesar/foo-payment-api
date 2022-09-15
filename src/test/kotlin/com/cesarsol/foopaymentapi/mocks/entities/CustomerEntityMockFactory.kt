package com.cesarsol.foopaymentapi.mocks.entities

import com.cesarsol.foopaymentapi.domain.database.entity.CustomerEntity
import com.cesarsol.foopaymentapi.domain.enums.NotificationWay

object CustomerEntityMockFactory {

    fun customerEntity(
        name: String = "NAME TEST",
        document: String = "12345678900",
        priorityNotificationWay: NotificationWay = NotificationWay.PUSH,
        email: String? = null,
        phone: String? = null,
        address: String? = null,
        profileScore: Int = 500
    ) = CustomerEntity(
        name = name,
        document = document,
        priorityNotificationWay = priorityNotificationWay,
        email = email,
        phone = phone,
        address = address,
        profileScore = profileScore
    )

}