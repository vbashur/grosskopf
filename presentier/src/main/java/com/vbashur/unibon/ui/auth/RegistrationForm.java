package com.vbashur.unibon.ui.auth;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;

import java.util.function.BiFunction;

public class RegistrationForm extends VerticalLayout {

    private TextField username;

    private PasswordField passwordField;

    private PasswordField confirmPasswordField;

    private Button confirmButton;

    public RegistrationForm(BiFunction<String, String, Boolean> confirmRegistrationHandler) {
        super();

        setClassName("login-information");

        H3 registerHeader = new H3("Register new user");
        registerHeader.setWidth("100%");

        username = new TextField("user name");
        username.setRequired(true);
        username.setRequiredIndicatorVisible(true);
        username.setWidth("100%");
        username.addInputListener(input -> {
           if (username.isEmpty()) {
               username.setErrorMessage("user name must not be empty");
           } else {
               username.setErrorMessage("");
           }
        });

        passwordField = new PasswordField("password");
        passwordField.setRequired(true);
        passwordField.setRequiredIndicatorVisible(true);
        passwordField.setWidth("100%");
        passwordField.addInputListener(input -> {
            if (passwordField.isEmpty()) {
                passwordField.setErrorMessage("password must not be empty");
            } else {
                passwordField.setErrorMessage("");
            }
        });

        confirmPasswordField = new PasswordField("confirm password");
        confirmPasswordField.setRequired(true);
        confirmPasswordField.setRequiredIndicatorVisible(true);
        confirmPasswordField.setWidth("100%");
        confirmPasswordField.addInputListener(input -> {
            if (confirmPasswordField.isEmpty()) {
                confirmPasswordField.setErrorMessage("password must not be empty");
            } else {
                confirmPasswordField.setErrorMessage("");
            }
        });

        confirmButton = new Button("Register");
        confirmButton.addClickListener(buttonClickEvent -> registerNewUser(confirmRegistrationHandler));

        add(registerHeader);
        add(username);
        add(passwordField);
        add(confirmPasswordField);
        add(confirmButton);
    }

    public void registerNewUser(BiFunction<String, String, Boolean> confirmRegistrationHandler) {
        if (isAllowedCredentialsParameters()) {
            if (confirmRegistrationHandler.apply(this.username.getValue(), this.passwordField.getValue())) {
                Notification.show("successfully registered user");
            } else {
                Notification.show("unable to register the user");
            }

        }

    }

    private boolean isAllowedCredentialsParameters() {
        if (username.isEmpty() || passwordField.isEmpty() || confirmPasswordField.isEmpty()) {
            Notification.show("Please fill mandatory parameters");
            return false;
        }
        if (!passwordField.getValue().equals(confirmPasswordField.getValue())) {
            Notification.show("Passwords do not match");
            return false;
        }
        return true;
    }
}
