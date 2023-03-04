package org.vaadin.example;

import com.vaadin.flow.component.button.Button; // importar la clase Button de Vaadin
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("Register-Invidente-basic")
public class Register_Invidente extends VerticalLayout {

    public void build() {
        VerticalLayout Vertical = new VerticalLayout();
        HorizontalLayout Horizontal = new HorizontalLayout();
        HorizontalLayout Horizontal1 = new HorizontalLayout();
        HorizontalLayout HorizontalB = new HorizontalLayout();

        //Image image = new Image("images/logo.png", "My Alt Image");


        H1 title = new H1("Resgistrarse Invidente");
        TextField nombre = new TextField("Nombre");
        TextField apellido = new TextField("Apellido");
        PasswordField contrasena = new PasswordField("Contraseña");
        PasswordField confirmarContrasena = new PasswordField("Confirmar contraseña");
        EmailField correo = new EmailField("Correo Electrónico");
        Button registerButton = new Button("Registrarse"); // Usar com.vaadin.flow.component.button.Button
        Button atrasButton = new Button("Atras");



        //Añadimos un indicador que los campos sean obligatorios de rellenar
        nombre.setRequiredIndicatorVisible(true);
        apellido.setRequiredIndicatorVisible(true);
        contrasena.setRequiredIndicatorVisible(true);
        confirmarContrasena.setRequiredIndicatorVisible(true);
        correo.setRequiredIndicatorVisible(true);

        Horizontal.add(nombre, apellido);
        HorizontalB.add(registerButton, atrasButton);

        // Agregar componentes al layout vertical
        Vertical.add(title, Horizontal, contrasena, confirmarContrasena,correo,Horizontal1, HorizontalB);
        Vertical.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);

        add(Vertical);

        // Configurar acciones de los componentes
        registerButton.addClickListener(event -> register());
        atrasButton.addClickListener(event -> {
            LoginView LV = new LoginView();
            removeAll();
            LV.LoginBasic();
            add(LV);
        });

    }

    private void register() {
        // Lógica de registro
        Notification.show("Registro exitoso");
    }
    private void Atras() {
        // Lógica de registro
        Notification.show("Atras");
    }
}
