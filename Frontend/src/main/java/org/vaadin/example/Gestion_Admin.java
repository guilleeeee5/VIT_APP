package org.vaadin.example;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
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
import java.net.URISyntaxException;
import java.util.ArrayList;

@Route("gestionAdmin")
@Theme(value = Lumo.class, variant = Lumo.LIGHT)
@CssImport("./styles/front.css")
public class Gestion_Admin extends VerticalLayout {

    public void gestionAdminView(){
        ArrayList<Jefe_Establecimiento> listaEstablecimientos = new ArrayList<Jefe_Establecimiento>();

        // Generar la tabla con los campos arriba puestos.
        Grid<Jefe_Establecimiento> grid = new Grid<>(Jefe_Establecimiento.class, false);
        grid.addColumn(Jefe_Establecimiento::getID).setHeader("ID_Establecimiento").setSortable(true);
        grid.addColumn(Jefe_Establecimiento::getNombre_establecimiento).setHeader("Nombre_Establecimiento");
        grid.addColumn(Jefe_Establecimiento::getCiudad).setHeader("Ciudad");
        grid.addColumn(Jefe_Establecimiento::getCodigo_Postal).setHeader("Código Postal");
        grid.addColumn(Jefe_Establecimiento::getDireccion).setHeader("Dirección");

        /* Rellenno el arrayilst, con los datos recibidos
        try {
            //listaEstablecimientos = DataService.;
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }*/

        grid.setItems(listaEstablecimientos);

        this.setAlignItems(Alignment.CENTER);
        this.setHeightFull();
        this.add(grid);


    }
}
