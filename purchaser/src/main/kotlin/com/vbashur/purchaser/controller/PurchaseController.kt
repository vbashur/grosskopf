package com.vbashur.purchaser.controller

import com.vbashur.purchaser.payload.PurchasePayload
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import kotlin.random.Random

@RestController
class PurchaseController {

    @GetMapping("/greeting")
    fun greeting(@RequestParam(value = "name", defaultValue = "World") name: String) =
            PurchasePayload(Random(100).nextLong(), "Hello, $name")

}