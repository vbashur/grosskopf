package com.vbashur.unibon.ui.auth;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vbashur.unibon.authentication.AccessControl;
import org.springframework.beans.factory.annotation.Autowired;

@Route("register")
@PageTitle("Registration")
@CssImport("./styles/shared-styles.css")
public class RegisterNewUserScreen extends FlexLayout {

    private AccessControl accessControl;

    @Autowired
    public RegisterNewUserScreen(AccessControl accessControl) {
        this.accessControl = accessControl;
        buildUI();
    }

    private void buildUI() {
        setSizeFull();
        setClassName("login-screen");

        RegistrationForm registrationForm = new RegistrationForm(accessControl::register);

        FlexLayout centeringLayout = new FlexLayout();
        centeringLayout.setSizeFull();
        centeringLayout.setJustifyContentMode(JustifyContentMode.CENTER);
        centeringLayout.setAlignItems(Alignment.CENTER);


        centeringLayout.add(registrationForm);

        add(centeringLayout);
    }
}
