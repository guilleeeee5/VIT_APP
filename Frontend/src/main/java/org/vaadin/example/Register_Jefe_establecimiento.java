package org.vaadin.example;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.login.LoginI18n;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.StreamResource;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;


import java.io.File;
//import com.vaadin.flow.component.orderedlayout.VerticalLayout.add;

@Theme(value = Lumo.class, variant = Lumo.DARK)
@Route("Register-Jefe")
public class Register_Jefe_establecimiento extends VerticalLayout
{
    public void build()
    {
        // Configurar componentes
        VerticalLayout Vertical = new VerticalLayout();
        HorizontalLayout Horizontal = new HorizontalLayout();
        HorizontalLayout Horizontal1 = new HorizontalLayout();
        HorizontalLayout HorizontalB = new HorizontalLayout();

        //Image image = new Image("images/logo.png", "My Alt Image");


        H1 title = new H1("Resgistrarse Jefe de establecimiento");
        TextField nombre = new TextField("Nombre");
        TextField apellido = new TextField("Apellido");
        PasswordField contrasena = new PasswordField("Contraseña");
        PasswordField confirmarContrasena = new PasswordField("Confirmar contraseña");
        EmailField correo = new EmailField("Correo Electrónico");

        TextField direccion = new TextField("Dirección");
        TextField ciudad = new TextField("Ciudad");
        TextField nombreEstablecimiento = new TextField("Nombre de Establecimiento");

        TextField CP = new TextField("Codigo Postal");
        CP.setMaxLength(5);
        CP.setErrorMessage("El CP solo puede tener una longitud de 5 caracteres");
        TextField cif = new TextField("CIF");
        cif.setMaxLength(9);
        cif.setErrorMessage("El CIF solo puede tener una longitud de 9 caracteres");
        Button registerButton = new Button("Registrarse"); // Usar com.vaadin.flow.component.button.Button
        registerButton.addClassName("btn_registro");
        Button atrasButton = new Button("Atras");
        atrasButton.addClassName("btn_atras");

        StreamResource imageResource = new StreamResource("logo.png",
                () -> getClass().getResourceAsStream("/images/icono_VITAPP.png"));

        Image img = new Image(imageResource, "");
        img.setWidth("200px");
        add(img);



        //Añadimos un indicador que los campos sean obligatorios de rellenar
        nombre.setRequiredIndicatorVisible(true);
        apellido.setRequiredIndicatorVisible(true);
        contrasena.setRequiredIndicatorVisible(true);
        confirmarContrasena.setRequiredIndicatorVisible(true);
        correo.setRequiredIndicatorVisible(true);

        direccion.setRequiredIndicatorVisible(true);
        CP.setRequiredIndicatorVisible(true);
        ciudad.setRequiredIndicatorVisible(true);
        cif.setRequiredIndicatorVisible(true);

        Horizontal.add(nombre, apellido);
        Horizontal1.add(direccion, ciudad);
        HorizontalB.add(registerButton, atrasButton);

        // Agregar componentes al layout vertical
        add(title, Horizontal, contrasena, confirmarContrasena,correo, nombreEstablecimiento ,Horizontal1,CP,cif, HorizontalB);
        setAlignItems(FlexComponent.Alignment.CENTER);
        setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);


        // Configurar acciones de los componentes
        registerButton.addClickListener(event -> {
            if(contrasena.getValue().equals(confirmarContrasena.getValue()) && correo.isInvalid() == false){
                register(nombre.getValue(), apellido.getValue(), contrasena.getValue(), correo.getValue(), direccion.getValue(),ciudad.getValue(), CP.getValue(), cif.getValue(), nombreEstablecimiento.getValue());
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
            Pregunta_Registro PR = new Pregunta_Registro();
            removeAll();
            PR.RespuestaView();
            add(PR);
        });

    }

    private void register(String nombre, String apellido, String contrasena, String correo, String direccion, String ciudad,  String CP,  String cif, String nombreEstablecimiento) {
        // Lógica de registro
        DataService data = new DataService();
        Jefe_Establecimiento jefeEstablecimiento = new Jefe_Establecimiento(nombre, apellido, contrasena, correo, direccion, ciudad, CP, cif, nombreEstablecimiento, "0");
        if(data.anhadirJefe(jefeEstablecimiento)){
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
