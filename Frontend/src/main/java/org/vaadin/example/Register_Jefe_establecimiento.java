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
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;


import java.io.File;
//import com.vaadin.flow.component.orderedlayout.VerticalLayout.add;

@Theme(value = Lumo.class, variant = Lumo.DARK)
@Route("Register-Jefe")
public class Register_Jefe_establecimiento extends Div
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

        TextField direccion = new TextField("Dirección de la calle");
        TextField provincia = new TextField("Provincia");
        TextField nombreEstablecimiento = new TextField("Nombre de Establecimiento");

        TextField CP = new TextField("Codigo Postal");
        NumberField telefono = new NumberField("Teléfono");
        TextField cif = new TextField("CIF");
        Button registerButton = new Button("Registrarse"); // Usar com.vaadin.flow.component.button.Button
        Button atrasButton = new Button("Atras");



        //Añadimos un indicador que los campos sean obligatorios de rellenar
        nombre.setRequiredIndicatorVisible(true);
        apellido.setRequiredIndicatorVisible(true);
        contrasena.setRequiredIndicatorVisible(true);
        confirmarContrasena.setRequiredIndicatorVisible(true);
        correo.setRequiredIndicatorVisible(true);

        direccion.setRequiredIndicatorVisible(true);
        CP.setRequiredIndicatorVisible(true);
        telefono.setRequiredIndicatorVisible(true);
        cif.setRequiredIndicatorVisible(true);

        Horizontal.add(nombre, apellido);
        Horizontal1.add(direccion, provincia);
        HorizontalB.add(registerButton, atrasButton);

        // Agregar componentes al layout vertical
        Vertical.add(title, Horizontal, contrasena, confirmarContrasena,correo,Horizontal1,CP,telefono,cif, HorizontalB);
        Vertical.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);

        add(Vertical);
        //layout.addComponent(Vertical);
        // Configurar acciones de los componentes
        registerButton.addClickListener(event -> {
            if(contrasena.getValue().equals(confirmarContrasena.getValue()) && correo.isInvalid() == false){
                register(nombre.getValue(), apellido.getValue(), contrasena.getValue(), correo.getValue(), direccion.getValue(), CP.getValue(), telefono.getValue(), cif.getValue(), provincia.getValue(), nombreEstablecimiento.getValue());
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

    private void register(String nombre, String apellido, String contrasena, String correo, String direccion, String CP, double telefono, String cif, String provincia, String nombreEstablecimiento) {
        // Lógica de registro
        DataService data = new DataService();
        Jefe_Establecimiento jefeEstablecimiento = new Jefe_Establecimiento();

        jefeEstablecimiento.setName(nombre);
        jefeEstablecimiento.setApellido(apellido);
        jefeEstablecimiento.setPassword(contrasena);
        jefeEstablecimiento.setEmail(correo);
        jefeEstablecimiento.setCalle(direccion);
        jefeEstablecimiento.setCiudad(provincia);
        jefeEstablecimiento.setCodigo_Postal(CP);
        jefeEstablecimiento.setNumero(Double.toString(telefono));
        jefeEstablecimiento.setNombre_establecimiento(nombreEstablecimiento);
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
