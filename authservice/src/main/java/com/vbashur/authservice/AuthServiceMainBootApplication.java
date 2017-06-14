package com.vbashur.authservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@EnableAutoConfiguration
@SpringBootApplication
public class AuthServiceMainBootApplication {


    public static void main(String[] args) {
        SpringApplication.run(AuthServiceMainBootApplication.class, args);

    }

}
