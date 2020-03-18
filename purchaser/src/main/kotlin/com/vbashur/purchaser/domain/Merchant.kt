package com.vbashur.purchaser.domain


import org.jetbrains.exposed.sql.Table
import java.util.*

object Merchant : Table() {
    val id = uuid("id").primaryKey()
    val registeredOn = datetime("registered_on")
    val firstName = varchar("first_name", 250)
    val lastName = varchar("last_name", 250)
    val companyName = varchar("company_name", 250)
    val email = varchar("email", 250)
}

data class Merch(
        val id: UUID,
        val name: String,
        val registeredOn: Date,
        val firstName: String,
        val lastName: String,
        val companyName: String,
        val email: String
)