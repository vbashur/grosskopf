package com.vbashur.unibon.authentication;

import com.vbashur.unibon.external.GuardianClient;
import com.vbashur.unibon.external.WorldClockClient;
import com.vbashur.unibon.model.AuthenticationResponse;
import com.vbashur.unibon.model.ImmutableUserPassword;
import com.vbashur.unibon.model.UserPassword;
import feign.FeignException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccessControl {
    @Autowired
    private WorldClockClient client;

    @Autowired
    private GuardianClient guardianClient;

    private String authToken;

    public boolean signIn(String username, String password) {
        authToken = null;
        UserPassword userPassword = ImmutableUserPassword.builder()
                .username(username)
                .password(password)
                .build();
        System.out.println("authenticate username = " + username + ", password = " + password);
        try {
            AuthenticationResponse authenticationResponse = this.guardianClient.authenticate(userPassword);
            System.out.println("Successfully authorized with the token  = " + authenticationResponse.token());
            authToken = authenticationResponse.token();
            return true;
        } catch (FeignException fe) {
            System.out.println("Failed to authorize with the following credentials: username = " + username + ", password = " + password);
        }
        return false;
    }

    public boolean register(String username, String password) {
        authToken = null;
        UserPassword userPassword = ImmutableUserPassword.builder()
                .username(username)
                .password(password)
                .build();
        System.out.println("register username = " + username + ", password = " + password);
        try {
            UserPassword registeredUser = this.guardianClient.register(userPassword);
            System.out.println("Successfully registered user  = " + registeredUser);
            return true;
        } catch (FeignException fe) {
            System.out.println("Failed to register with the following credentials: username = " + username + ", password = " + password);
            fe.printStackTrace();
        }
        return false;
    }


    public boolean isUserSignedIn() {
        return StringUtils.isNotEmpty(authToken);
    }

    public String getToken() {
        return "Bearer " + authToken;
    }

    public String getTime() {
        return client.getTime();
    }
}
