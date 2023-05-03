package org.vaadin.example;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
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
import java.io.IOException;
import java.io.InputStream;

@Route("inicio")
@Theme(value = Lumo.class, variant = Lumo.LIGHT)
@CssImport("./styles/front.css")
public class Pagina_Inicio extends VerticalLayout{

    public void ViewInicio() {
        //Creacion del objeto al que se va a navegar después de pulsar el boton y el layout horizontal
        LoginView LV = new LoginView();
        HorizontalLayout horizontalLayout = new HorizontalLayout();

        //Creamos los objetos de las imagenes
        StreamResource imageResource = new StreamResource("logo.png",
                () -> getClass().getResourceAsStream("/images/icono_VITAPP.png"));

        Image img = new Image(imageResource, "");
        img.setWidth("200px");

        StreamResource imgInvidente = new StreamResource("logo.png",
                () -> getClass().getResourceAsStream("/images/guiaInvidente.png"));

        Image imgI = new Image(imgInvidente, "");
        imgI.setWidth("500px");

        StreamResource imgEmpresa = new StreamResource("logo.png",
                () -> getClass().getResourceAsStream("/images/guiaEmpresa.png"));

        Image imgE = new Image(imgEmpresa, "");
        imgE.setWidth("500px");


        H1 titulo = new H1("Guías de uso");

        H2 tit = new H2("INVIDENTE - ESTABLECIMIENTO");

        //Creamos el boton y su evento
        Button btnEmpezar = new Button("EMPIEZA YA");
        btnEmpezar.setWidth("250px");
        btnEmpezar.addClassName("btn_EmpezarInicio");

        btnEmpezar.addClickListener(clickEvent -> {
            removeAll();
            LV.LoginBasic();
            add(LV);
        });



        // Agregar componentes al layout vertical
        horizontalLayout.add(imgI,imgE);
        horizontalLayout.setAlignSelf(FlexComponent.Alignment.CENTER);
        add(img,titulo,tit,horizontalLayout,btnEmpezar);
        // Configurar layout
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);

    }


}
