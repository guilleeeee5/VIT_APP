package org.vaadin.example;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;
//import com.vaadin.flow.component.orderedlayout.VerticalLayout.add;


@Route("Register-Jefe")
@Theme(value = Lumo.class, variant = Lumo.DARK)
public class Register_Jefe_establecimiento extends Div
{
    public void build()
    {
        // Configurar componentes
        VerticalLayout V = new VerticalLayout();
        H1 title = new H1("Resgistrarse Jefe de establecimiento");
        TextField nombre = new TextField("Nombre");
        TextField apellido = new TextField("Apellido");
        PasswordField contrasena = new PasswordField("Contraseña");
        PasswordField confirmarContrasena = new PasswordField("Confirmar contraseña");
        TextField correo = new TextField("Correo Electrónico");
        TextField direccion = new TextField("Dirección de la calle");
        TextField CP = new TextField("Codigo Postal");
        TextField telefono = new TextField("Teléfono");
        TextField cif = new TextField("CIF");
        Button registerButton = new Button("Registrarse"); // Usar com.vaadin.flow.component.button.Button

        // Agregar componentes al layout vertical
        V.setAlignItems(FlexComponent.Alignment.CENTER);
        V.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        add(title, nombre, apellido, contrasena, confirmarContrasena,correo,direccion,CP,telefono,cif, registerButton);


        // Configurar layout

        // Configurar acciones de los componentes
        registerButton.addClickListener(event -> register());
    }

    private void register() {
        // Lógica de registro
        Notification.show("Registro exitoso");
    }
}
