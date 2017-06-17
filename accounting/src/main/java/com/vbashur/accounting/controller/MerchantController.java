package com.vbashur.accounting.controller;

import com.vbashur.accounting.model.ImmutableMerchant;
import com.vbashur.accounting.model.Merchant;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class MerchantController {

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Merchant getMerchant(@PathVariable Integer id, Principal principal) {
        return ImmutableMerchant.builder()
                .id(id)
                .name(principal.getName())
                .address(principal.toString())
                .build();

    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getTestMessage() {
        return "Test message";

    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String getTestPostMessage() {
        return "Test Post message";

    }
}
