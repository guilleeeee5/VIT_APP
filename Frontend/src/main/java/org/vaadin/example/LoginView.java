package org.vaadin.example;


import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.login.LoginI18n;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

@Route("login-basic")
@Theme(value = Lumo.class, variant = Lumo.DARK)
public class LoginView extends Div{

    public void LoginBasic() {
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        HorizontalLayout horizontalLayout1 = new HorizontalLayout();
        LoginI18n i18n = LoginI18n.createDefault();

        LoginI18n.Form i18nForm = i18n.getForm();
        i18nForm.setTitle("Inicio de Sesión");
        i18nForm.setUsername("Email");
        i18nForm.setPassword("Contraseña");
        i18nForm.setSubmit("Iniciar Sesión");
        i18nForm.setForgotPassword("Regístrate");
        i18n.setForm(i18nForm);

        RadioButtonGroup<String> radioGroup = new RadioButtonGroup<>();
        radioGroup.setLabel("Tipo de usuario");
        radioGroup.setItems("Invidente", "Jefe de Establecimiento", "Administrador");
        LoginI18n.ErrorMessage i18nErrorMessage = i18n.getErrorMessage();
        i18nErrorMessage.setTitle("Error");
        i18nErrorMessage.setMessage("Error!!.");
        i18n.setErrorMessage(i18nErrorMessage);

        LoginForm loginForm = new LoginForm();
        loginForm.setI18n(i18n);
        loginForm.getElement().setAttribute("no-autofocus", "");
        // Prevent the example from stealing focus when browsing the documentation


        // Agregar los componentes al formulario
        horizontalLayout.add(loginForm);
        horizontalLayout1.add(radioGroup);
        horizontalLayout.setAlignSelf(FlexComponent.Alignment.CENTER);
        horizontalLayout1.setAlignSelf(FlexComponent.Alignment.CENTER);
        add(horizontalLayout, horizontalLayout1);
    }

    private boolean isValidLogin(String username, String password) {
        // Verificar si el usuario y contraseña son correctos en la base de datos
        // (esto dependerá de cómo esté implementada tu aplicación)
        return true; // Por ahora siempre retorna true para este ejemplo
    }
}
