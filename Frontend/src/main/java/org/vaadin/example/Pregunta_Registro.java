package org.vaadin.example;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.button.Button; // importar la clase Button de Vaadin


import java.awt.*;

@Route("respuesta")
public class Pregunta_Registro extends VerticalLayout {

    public int RespuestaView() {
        // Configurar componentes
        H1 titulo = new H1("¿Va a utilizar VIT para desplazarse o va a Instalar VIT?");
        ComboBox<String> opciones = new ComboBox<>("Seleccione una opción");
        opciones.setItems("Utilizar VIT para desplazarse", "Instalar VIT");
        opciones.setRequired(true);
        Button enviar = new Button("Enviar");
        enviar.addClickListener(e -> enviarRespuesta(opciones.getValue()));

        // Agregar componentes al layout vertical
        add(titulo, opciones, enviar);

        // Configurar layout
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);

        return 0;
    }

    private void enviarRespuesta(String respuesta) {
        // Lógica para enviar la respuesta a la base de datos, enviar un correo electrónico, etc.
        System.out.println("La respuesta es: " + respuesta);
    }
}
