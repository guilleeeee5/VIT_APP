package org.vaadin.example;


import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.login.LoginI18n;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

import java.io.IOException;


@Route("login-basic")
@Theme(value = Lumo.class, variant = Lumo.LIGHT)
public class LoginView extends VerticalLayout{

    public void LoginBasic() {

        HorizontalLayout horizontalLayout = new HorizontalLayout();
        HorizontalLayout horizontalLayout1 = new HorizontalLayout();
        VerticalLayout VL = new VerticalLayout();
        VL.setWidthFull();
        VL.setAlignItems(FlexComponent.Alignment.CENTER);
        VL.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        add(VL);
        Pregunta_Registro PR = new Pregunta_Registro();

        LoginI18n i18n = LoginI18n.createDefault();

        LoginI18n.Form i18nForm = i18n.getForm();
        i18nForm.setTitle("Inicio de Sesión");
        i18nForm.setUsername("Email");
        i18nForm.setPassword("Contraseña");
        i18nForm.setSubmit("Iniciar Sesión");
        i18nForm.setForgotPassword("Regístrate");

        i18n.setForm(i18nForm);

        RadioButtonGroup<String> radioGroup = new RadioButtonGroup<>();
        radioGroup.setLabel("Seleccione el tipo de usuario");
        radioGroup.setItems("Discapacitado Visual", "Jefe de Establecimiento", "Administrador");
        LoginI18n.ErrorMessage i18nErrorMessage = i18n.getErrorMessage();
        i18nErrorMessage.setTitle("Error!");
        i18nErrorMessage.setMessage("Email o contraseña incorrectos.");
        i18n.setErrorMessage(i18nErrorMessage);

        LoginForm loginForm = new LoginForm();
        loginForm.setI18n(i18n);

        loginForm.addForgotPasswordListener(forgotPasswordEvent ->
        {
            removeAll();
            PR.RespuestaView();
            add(PR);
        });

        loginForm.getElement().setAttribute("no-autofocus", "");

        // Prevent the example from stealing focus when browsing the documentation

        loginForm.addLoginListener(event -> {
            String email = event.getUsername();
            String password = event.getPassword();
            String userType = radioGroup.getValue();

            try {
                boolean isValid = isValidLogin(email, password, userType);
                if (isValid == false) {
                    Notification.show("El email o la contraseña son incorrectos.");
                    loginForm.setError(true);
                    i18nForm.setUsername("");
                    i18nForm.setPassword("");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        // Agregar los componentes al formulario
        horizontalLayout.add(loginForm);
        horizontalLayout1.add(radioGroup);
        horizontalLayout.setAlignSelf(FlexComponent.Alignment.CENTER);
        horizontalLayout1.setAlignSelf(FlexComponent.Alignment.CENTER);

        VL.add(horizontalLayout, horizontalLayout1);
        radioGroup.addValueChangeListener(event -> {
            // Obtener el valor seleccionado
            String selectedValue = event.getValue();
            // Hacer algo con el valor seleccionado
            try {
                if(selectedValue != null){
                    isValidLogin(i18nForm.getUsername(), i18nForm.getPassword(), selectedValue);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

    }

    private boolean isValidLogin(String mail, String password, String tipo) throws IOException {
        boolean result = false;
        DataService data = new DataService();

        switch (tipo){
            case "Jefe de Establecimiento":
                Jefe_Establecimiento jefe = new Jefe_Establecimiento();
                jefe.setPassword(password);
                jefe.setEmail(mail);
                //Peticiones a la BBDD
                 if (data.comprobarJefeInicio(mail, password).getName() == null){
                     result = false;
                 }else {
                     result = true;
                 }
                break;
            case "Discapacitado Visual":
                Discapacitado_VIsual discapacitadoVIsual = new Discapacitado_VIsual();
                discapacitadoVIsual.setPassword(password);
                discapacitadoVIsual.setEmail(mail);
                //Peticiones a la BBDD
                if (data.comprobarDiscInicio(mail, password).getName() == null){
                    result = false;
                }else {
                    result = true;
                }
                break;

            case "Administrador":
                Admin admin = new Admin();
                admin.setPassword(password);
                admin.setEmail(mail);
                //Peticiones a la BBDD
                if (data.comprobarAdminInicio(mail, password).getName() == null){
                    result = false;
                }else {
                    result = true;
                }
                break;
        }
        return result;
    }
}
