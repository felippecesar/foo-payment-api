package com.cesarsol.foopaymentapi.domain.database.entity

import com.cesarsol.foopaymentapi.domain.enums.NotificationWay
import java.io.Serializable
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "TB_CUSTOMER")
data class CustomerEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_ID")
    var id: Long? = null,
    @Column(name = "NAM_NAME")
    var name: String,
    @Column(name = "COD_DOCUMENT")
    var document: String,
    @Column(name = "DES_PRIORITY_NOTIF_WAY")
    @Enumerated(EnumType.STRING)
    var priorityNotificationWay: NotificationWay,
    @Column(name = "NAM_MAIL")
    var email: String? = null,
    @Column(name = "COD_PHONE")
    var phone: String? = null,
    @Column(name = "DES_ADDRESS")
    var address: String? = null,
    @Column(name = "NUM_PROFILE_SCORE")
    var profileScore: Int,
    @Column(name = "DAT_CREATION")
    var createdAt: LocalDateTime = LocalDateTime.now()

) : Serializable

