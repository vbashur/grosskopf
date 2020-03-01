package com.vbashur.unibon.authentication;

import com.vbashur.unibon.external.AppGatewayClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccessControl {
    @Autowired
    AppGatewayClient client;

    public boolean signIn(String username, String password) {
        return true;
    }

    public boolean isUserSignedIn() {
        return false;
    }

    public String getTime() {
        return client.getTime();
    }
}
