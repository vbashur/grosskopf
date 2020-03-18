package com.vbashur.purchaser.controller
import org.jetbrains.exposed.sql.*

import com.vbashur.purchaser.domain.Merchant
import com.vbashur.purchaser.payload.PurchasePayload
import org.jetbrains.exposed.sql.transactions.transaction
import org.joda.time.DateTime
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.*
import kotlin.random.Random

@RestController
class MerchantController {

    @GetMapping("/merchants")
    fun getMerchants(@RequestParam(value = "name", defaultValue = "World") name: String) {
        var connection = Database.connect("jdbc:h2:mem:test", driver = "org.h2.Driver", user = "sa", password = "")
        transaction {
            addLogger(StdOutSqlLogger)
            SchemaUtils.create (Merchant)
            Merchant.insert {
                it[id] = UUID.randomUUID()
                it[registeredOn] = DateTime.now()
                it[firstName] = name
                it[lastName] = name
                it[companyName] = "company " + name
                it[email] = "email@mail.com"
            }
        }
        PurchasePayload(Random(100).nextLong(), "Hello, $name")
    }

}

