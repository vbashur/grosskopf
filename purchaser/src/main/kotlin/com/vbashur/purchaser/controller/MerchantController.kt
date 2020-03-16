package com.vbashur.purchaser.controller

import com.vbashur.purchaser.domain.Merchant
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MerchantController {

    @GetMapping("/merchants")
    fun List<Merchant>.getMerchants() {
        setOf("")
    }

}

