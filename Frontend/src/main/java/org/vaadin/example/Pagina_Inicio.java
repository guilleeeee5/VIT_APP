package org.vaadin.example;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.button.Button; // importar la clase Button de Vaadin
import com.vaadin.flow.server.StreamResource;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

import javax.swing.*;
import java.awt.*;
import java.io.InputStream;

@Route("inicio")
@Theme(value = Lumo.class, variant = Lumo.LIGHT)
@CssImport("./styles/front.css")
public class Pagina_Inicio extends VerticalLayout{

    public int ViewInicio() {
        Pregunta_Registro PR = new Pregunta_Registro();
        HorizontalLayout horizontalLayout = new HorizontalLayout();


        StreamResource imageResource = new StreamResource("logo.png",
                () -> getClass().getResourceAsStream("/images/logo.png"));

        Image img = new Image(imageResource, "");

        StreamResource imgInvidente = new StreamResource("logo.png",
                () -> getClass().getResourceAsStream("/images/guiaInvidente.png"));

        Image imgI = new Image(imgInvidente, "");

        StreamResource imgEmpresa = new StreamResource("logo.png",
                () -> getClass().getResourceAsStream("/images/guiaEmpresa.png"));

        Image imgE = new Image(imgEmpresa, "");

        H1 titulo = new H1("¿Va a utilizar VIT para desplazarse o va a Instalar VIT?");

        Button btnEmpezar = new Button("EMPIEZA YA");
        btnEmpezar.setWidth("250px");

        btnEmpezar.addClickListener(clickEvent -> {
            removeAll();
            PR.RespuestaView();
            add(PR);
        });

        return 0;
    }


}
