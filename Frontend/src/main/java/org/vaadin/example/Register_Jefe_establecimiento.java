package org.vaadin.example;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
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
        VerticalLayout Vertical = new VerticalLayout();
        HorizontalLayout Horizontal = new HorizontalLayout();
        HorizontalLayout Horizontal1 = new HorizontalLayout();

        H1 title = new H1("Resgistrarse Jefe de establecimiento");
        TextField nombre = new TextField("Nombre");
        TextField apellido = new TextField("Apellido");
        PasswordField contrasena = new PasswordField("Contraseña");
        PasswordField confirmarContrasena = new PasswordField("Confirmar contraseña");
        EmailField correo = new EmailField("Correo Electrónico");

        TextField direccion = new TextField("Dirección de la calle");
        TextField Provincia = new TextField("Provincia");

        TextField CP = new TextField("Codigo Postal");
        NumberField telefono = new NumberField("Teléfono");
        TextField cif = new TextField("CIF");
        Button registerButton = new Button("Registrarse"); // Usar com.vaadin.flow.component.button.Button

        Horizontal.add(nombre, apellido);
        Horizontal1.add(direccion, Provincia);

        // Agregar componentes al layout vertical
        Vertical.add(title, Horizontal, contrasena, confirmarContrasena,correo,Horizontal1,CP,telefono,cif, registerButton);
        Vertical.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);

        add(Vertical);
        //layout.addComponent(Vertical);
        // Configurar acciones de los componentes
        registerButton.addClickListener(event -> register());
    }

    private void register() {
        // Lógica de registro
        Notification.show("Registro exitoso");
    }
}
