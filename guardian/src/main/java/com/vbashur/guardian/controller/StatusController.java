package com.vbashur.guardian.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class StatusController {

    @GetMapping("/status")
    public String status() {
        return new Date().toString();
    }
}
