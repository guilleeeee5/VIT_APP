package org.vaadin.example;

import com.vaadin.flow.component.button.Button; // importar la clase Button de Vaadin
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;

public class Register_Invidente extends VerticalLayout {

    public Register_Invidente() {
        build();
    }

    private void build() {
        // Configurar componentes
        H1 title = new H1("Registrarse");
        TextField usernameField = new TextField("Username");
        TextField emailField = new TextField("Email");
        PasswordField passwordField = new PasswordField("Password");
        PasswordField confirmPasswordField = new PasswordField("Confirmar password");
        Button registerButton = new Button("Registrarse"); // Usar com.vaadin.flow.component.button.Button

        // Agregar componentes al layout vertical
        add(title, usernameField, emailField, passwordField, confirmPasswordField, registerButton);
 
        // Configurar layout
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);

        // Configurar acciones de los componentes
        registerButton.addClickListener(event -> register());
    }

    private void register() {
        // Lógica de registro
        Notification.show("Registro exitoso");
    }
}
