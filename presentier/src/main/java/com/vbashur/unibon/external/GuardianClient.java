package com.vbashur.unibon.external;

import com.vbashur.unibon.model.AuthenticationResponse;
import com.vbashur.unibon.model.UserPassword;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "guardian", url = "${external.guardian.url}")
public interface GuardianClient {

    @RequestMapping(method = RequestMethod.POST, value = "/authenticate", consumes = MediaType.APPLICATION_JSON_VALUE)
    AuthenticationResponse authenticate(UserPassword userPassword);

    @RequestMapping(method = RequestMethod.POST, value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    UserPassword register(UserPassword userPassword);

    @RequestMapping(method = RequestMethod.GET, value = "/status")
    String status(@RequestHeader("Authorization") String token);

}
