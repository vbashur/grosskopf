package com.vbashur.authservice.controller;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.vbashur.authservice.model.TestData;
import org.immutables.value.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.security.Principal;

@SessionAttributes("authorizationRequest")
@RestController
public class TestController {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public TestData test() {

        return com.vbashur.authservice.model.ImmutableTestData.builder()
                .name("name")
                .value(Integer.valueOf(1))
                .build();

    }


}
