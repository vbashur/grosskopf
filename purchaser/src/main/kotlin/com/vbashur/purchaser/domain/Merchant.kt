package com.vbashur.purchaser.domain

import org.jetbrains.exposed.sql.Table
import java.util.*

object Merchants : Table() {
    val id = uuid("id").primaryKey()
    val name = varchar("name", 70)
    val registrationDate = date("registrationDate")
}

data class Merchant(
        val id: UUID,
        val name: String,
        val registrationDate: Date
)