package com.vbashur.maingateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class EntryPointApplication {

    public static void main(String[] args) {
        SpringApplication.run(EntryPointApplication.class, args);
    }

}
