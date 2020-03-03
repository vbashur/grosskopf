package com.vbashur.unibon.ui.form;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vbashur.unibon.authentication.AccessControl;
import com.vbashur.unibon.external.GuardianClient;
import org.springframework.beans.factory.annotation.Autowired;

@Route("button")
@PageTitle("Button")
@CssImport("./styles/shared-styles.css")
public class SimpleButtonForm extends VerticalLayout {

    private AccessControl accessControl;

    private GuardianClient guardianClient;

    @Autowired
    public SimpleButtonForm(AccessControl accessControl, GuardianClient guardianClient) {
        this.accessControl = accessControl;
        this.guardianClient = guardianClient;
        buildUI();
    }

    private void buildUI() {

        // Use TextField for standard text input
        TextField textField = new TextField("Your name");

        // Button click listeners can be defined as lambda expressions
        Button button = new Button("When you signed - you see actual time",
                e -> Notification.show(guardianClient.status(accessControl.getToken())));

        // Theme variants give you predefined extra styles for components.
        // Example: Primary button is more prominent look.
        button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        // You can specify keyboard shortcuts for buttons.
        // Example: Pressing enter in this view clicks the Button.
        button.addClickShortcut(Key.ENTER);

        // Use custom CSS classes to apply styling. This is defined in shared-styles.css.
        addClassName("centered-content");

        add(textField, button);
    }
}
