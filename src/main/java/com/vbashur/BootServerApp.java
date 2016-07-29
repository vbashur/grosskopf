package com.vbashur;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class BootServerApp {

    @RequestMapping("/")
    String home() {
        return "Hello Epta!";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(BootServerApp.class, args);
    }

}
