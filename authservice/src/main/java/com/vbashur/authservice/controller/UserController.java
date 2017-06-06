package com.vbashur.authservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.security.Principal;

@SessionAttributes("authorizationRequest")
@RestController
public class UserController {

    @RequestMapping("/")
    public String sayHi() {
        return "Hi!";
    }


    @RequestMapping("/user")
    @ResponseBody
    public Principal user(Principal user) {
        return user;
    }

}
