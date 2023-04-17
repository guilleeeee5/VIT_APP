package org.vaadin.example;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.ItemDoubleClickEvent;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.tabs.TabsVariant;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.button.Button; // importar la clase Button de Vaadin
import com.vaadin.flow.server.StreamResource;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;


import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

@Route("gestionJefe")
@Theme(value = Lumo.class, variant = Lumo.LIGHT)
@CssImport("./styles/front.css")
public class GestionJefe extends VerticalLayout {

    public void gestionJefeView(Jefe_Establecimiento jefe){
        HorizontalLayout horizontalLayout = new HorizontalLayout();

        H1 tit = new H1("Gestión de Jefe de Establecimiento");
        Label bienvenida = new Label("Bienvenido, " + jefe.getName() + "su establecimiento es: " + jefe.getNombre_establecimiento());
        horizontalLayout.add(tit, bienvenida);

        Tab inicio = new Tab("Inicio");
        Tab estadisticas = new Tab("Estadisticas");

        Tabs tabs = new Tabs(
                inicio, estadisticas
        );
        tabs.addThemeVariants(TabsVariant.LUMO_HIDE_SCROLL_BUTTONS);
        
        Label estado = new Label("Su establecimiento, " + jefe.getNombre_establecimiento() + "su establecimiento es: " + estado(jefe));
        

    }
    public String estado(Jefe_Establecimiento jefe) {
        String result = null;
        switch (jefe.getEstado()) { 
            case "0":
                result = "Estamos comprobando sus datos, gracias por su paciencia. ";//no ve nada
                break;
            case "1":
                result = "Ya están comprobados sus datos, suba el mapa de su establecimiento para poder diseñar el sistema VIT a su medida.";//upload map estadisticas no
                break;
            case "2":
                result = "Estamos analizando su mapa, gracias por su paciencia ";//ve el mapa
                break;
            case "3":
                result = "Los técnicos están de camino a su establecimineto.";//ve la imagen de un técnico
                break;
            case "4":
                result = "YA ERES VIT! Gracias por confiar en nosotros.";//ve mapa y estadísticas
                break;
        }
        return result;
    }
    }
}

