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
        registerButton.addClickListener(event -> {
            if(contrasena.getValue().equals(confirmarContrasena.getValue()) && correo.isInvalid() == false){
                register(nombre.getValue(), apellido.getValue(), contrasena.getValue(), correo.getValue());
                correo.setInvalid(false);
            }
            else if(contrasena.getValue().equals(confirmarContrasena.getValue()) == false){
                Notification.show("Las contraseñas no coinciden. ");
            }else{
                // Se muestra una notificación y se marca el campo de correo como inválido
                Notification.show("Complete correctamente los campos requeridos");
                correo.setInvalid(true);
            }
        });


        atrasButton.addClickListener(event -> {
            LoginView LV = new LoginView();
            removeAll();
            LV.LoginBasic();
            add(LV);
        });

    }

    private void register(String nombre, String apellido, String contrasena, String correo) {
        // Lógica de registro
        DataService data = new DataService();
        Discapacitado_VIsual discapacitadoVIsual = new Discapacitado_VIsual();

        discapacitadoVIsual.setName(nombre);
        discapacitadoVIsual.setApellido(apellido);
        discapacitadoVIsual.setPassword(contrasena);
        discapacitadoVIsual.setEmail(correo);
        if(data.anhadirDiscapacitado(discapacitadoVIsual)){
            removeAll();
            LoginView login = new LoginView();
            login.LoginBasic();
            add(login);
            Notification.show("Registro exitoso");
        }else {
            Notification.show("Error. Usuario con ese Email ya existente");
        }
    }

}
