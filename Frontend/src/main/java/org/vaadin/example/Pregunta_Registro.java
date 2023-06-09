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

@Route("respuesta")
@Theme(value = Lumo.class, variant = Lumo.LIGHT)
@CssImport("./styles/front.css")
public class Pregunta_Registro extends VerticalLayout {

    public int RespuestaView() {
        Register_Invidente RI = new Register_Invidente();
        Register_Jefe_establecimiento RJE = new Register_Jefe_establecimiento();
        HorizontalLayout horizontalLayout = new HorizontalLayout();

        StreamResource imageResource = new StreamResource("logo.png",
                () -> getClass().getResourceAsStream("/images/icono_VITAPP.png"));

        Image img = new Image(imageResource, "");
        img.setWidth("200px");


        // Configurar componentes
        H1 titulo = new H1("¿Va a utilizar VIT para desplazarse o va a Instalar VIT?");
        Button utilizarVit = new Button("Instalar VIT");
        utilizarVit.setWidth("250px");
        utilizarVit.addClassName("btn_registro");

        Button descargarVit = new Button("Utilizar VIT para desplazarte");
        descargarVit.setWidth("250px");
        descargarVit.addClassName("btn_registro");

        Button atrasButton = new Button("Atras");
        atrasButton.addClassName("btn_atras");
        /*ComboBox<String> opciones = new ComboBox<>("Seleccione una opción");
        opciones.setItems("Utilizar VIT para desplazarse", "Instalar VIT");
        opciones.setRequired(true);*/

        //enviar.addClickListener();

        utilizarVit.addClickListener(clickEvent -> {
            removeAll();
            RJE.build();
            add(RJE);
        });

        descargarVit.addClickListener(clickEvent -> {
            removeAll();
            RI.build();
            add(RI);
        });
        atrasButton.addClickListener(event -> {
            LoginView LV = new LoginView();
            removeAll();
            LV.LoginBasic();
            add(LV);
        });
        
        // Agregar componentes al layout vertical
        horizontalLayout.add(utilizarVit,descargarVit);
        horizontalLayout.setAlignSelf(FlexComponent.Alignment.CENTER);
        add(img,titulo,horizontalLayout,atrasButton);
        // Configurar layout
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);

        return 0;
    }


}
