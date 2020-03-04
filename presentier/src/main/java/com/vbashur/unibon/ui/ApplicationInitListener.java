package com.vbashur.unibon.ui;

import com.vaadin.flow.server.ServiceInitEvent;
import com.vaadin.flow.server.VaadinServiceInitListener;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vbashur.unibon.authentication.AccessControl;
import com.vbashur.unibon.ui.auth.LoginScreen;
import com.vbashur.unibon.ui.auth.RegisterNewUserScreen;
import org.springframework.beans.factory.annotation.Autowired;

@SpringComponent
public class ApplicationInitListener implements VaadinServiceInitListener {

    @Autowired
    private AccessControl accessControl;

    @Override
    public void serviceInit(ServiceInitEvent initEvent) {

        initEvent.getSource().addUIInitListener(uiInitEvent -> {
            uiInitEvent.getUI().addBeforeEnterListener(enterEvent -> {
                if (accessControl != null && !accessControl.isUserSignedIn()
                        && isProtectedNavigationTarget(enterEvent.getNavigationTarget()))
                    enterEvent.rerouteTo(LoginScreen.class);
            });
        });

    }


    private boolean isProtectedNavigationTarget(Class<?> navigationTarget) {
        return !(navigationTarget.equals(LoginScreen.class)
                || navigationTarget.equals(RegisterNewUserScreen.class));
    }
}
