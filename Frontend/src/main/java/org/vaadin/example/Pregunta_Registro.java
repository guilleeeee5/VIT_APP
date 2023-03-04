package org.vaadin.example;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.button.Button; // importar la clase Button de Vaadin


import javax.swing.*;
import java.awt.*;

@Route("respuesta")
public class Pregunta_Registro extends VerticalLayout {

    public int RespuestaView() {

        HorizontalLayout horizontalLayout = new HorizontalLayout();
        Image img = new Image("../../../../../images/logo.png","");
        img.setHeight("70px");
        img.setWidth("70px");
        // Configurar componentes
        H1 titulo = new H1("¿Va a utilizar VIT para desplazarse o va a Instalar VIT?");
        Button utilizarVit = new Button("Utilizar VIT para desplazarte");
        utilizarVit.setWidth("100px");
        Button descargarVit = new Button("Instalar VIT");
        /*ComboBox<String> opciones = new ComboBox<>("Seleccione una opción");
        opciones.setItems("Utilizar VIT para desplazarse", "Instalar VIT");
        opciones.setRequired(true);*/

        //enviar.addClickListener();


        // Agregar componentes al layout vertical
        horizontalLayout.add(utilizarVit,descargarVit);
        horizontalLayout.setAlignSelf(FlexComponent.Alignment.CENTER);
        add(img,titulo,horizontalLayout);
        // Configurar layout
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);

        return 0;
    }


}
