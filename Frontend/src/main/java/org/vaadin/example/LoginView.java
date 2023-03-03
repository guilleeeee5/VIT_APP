package org.vaadin.example;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.radiobutton.RadioGroupVariant;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("login")
public class LoginView extends FormLayout {

    private TextField username;
    private PasswordField password;

    public LoginView() {
        // Crear campos de texto para usuario y contraseña

        username = new TextField("Usuario");
        password = new PasswordField("Contraseña");

        // Crear botón para iniciar sesión
        H1 title = new H1("Iniciar sesión");
        H2 subtitle = new H2("Por favor, ingrese sus credenciales para continuar");
        Button loginButton = new Button("Iniciar sesión");
        subtitle.getStyle().set("font-size", "14px");
        loginButton.addClickListener(event -> {
            // Verificar si el usuario y contraseña son correctos
            if (isValidLogin(username.getValue(), password.getValue())) {
                // Si son correctos, redirigir al usuario a la página de inicio
                getUI().ifPresent(ui -> ui.navigate("home"));
            } else {
                // Si no son correctos, mostrar un mensaje de error
                Notification.show("Usuario o contraseña incorrectos");
            }
        });
        RadioButtonGroup<String> radioGroup = new RadioButtonGroup<>();
        radioGroup.addThemeVariants(RadioGroupVariant.LUMO_VERTICAL);
        radioGroup.setLabel("Tipo de usuario");
        radioGroup.setItems("Invidente", "Jefe de Establecimiento", "Administrador");
        // Agregar los componentes al formulario
        add(title, subtitle, username, password, loginButton, radioGroup);
    }

    private boolean isValidLogin(String username, String password) {
        // Verificar si el usuario y contraseña son correctos en la base de datos
        // (esto dependerá de cómo esté implementada tu aplicación)
        return true; // Por ahora siempre retorna true para este ejemplo
    }
}
