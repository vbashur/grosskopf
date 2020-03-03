package com.vbashur.unibon.ui;

import com.vaadin.flow.server.ServiceInitEvent;
import com.vaadin.flow.server.VaadinServiceInitListener;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vbashur.unibon.authentication.AccessControl;
import com.vbashur.unibon.ui.login.LoginScreen;
import org.springframework.beans.factory.annotation.Autowired;

@SpringComponent
public class ApplicationInitListener implements VaadinServiceInitListener {


    @Autowired
    private AccessControl accessControl;// = new AccessControl();


    @Override
    public void serviceInit(ServiceInitEvent initEvent) {

        initEvent.getSource().addUIInitListener(uiInitEvent -> {
            uiInitEvent.getUI().addBeforeEnterListener(enterEvent -> {
                if (accessControl != null && !accessControl.isUserSignedIn() && !LoginScreen.class
                        .equals(enterEvent.getNavigationTarget()))
//                    System.out.println("access control =>>>>>>>>>> " + accessControl.getTime());
                    enterEvent.rerouteTo(LoginScreen.class);
            });
        });

    }
}
