package org.vaadin.example;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.StreamResource;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

import java.io.IOException;
import java.net.URISyntaxException;

@Route("gestion_DiscapacitadoVisual")
@Theme(value = Lumo.class, variant = Lumo.LIGHT)
@CssImport("./styles/front.css")
public class Gestion_DiscapacitadoVisual extends VerticalLayout {

    public void gestion_DiscapacitadoView() {
        //Creación de Layouts
        HorizontalLayout horizontalbtnAtras = new HorizontalLayout();
        Button atrasButton = new Button("Atras");
        atrasButton.addClassName("btn_atras");
        horizontalbtnAtras.add(atrasButton);
        horizontalbtnAtras.setAlignItems(FlexComponent.Alignment.END);
        //Imagen del icono App
        StreamResource imageResource = new StreamResource("logo.png",
                () -> getClass().getResourceAsStream("/images/icono_VITAPP.png"));

        Image img = new Image(imageResource, "");
        img.setWidth("200px");

        //Título de la página
        H1 tit = new H1("Establecimientos visitados");
        tit.addClassName("tit_admin");

        // Generar la tabla con los campos arriba puestos.
        Grid<Discapacitado_VIsual> grid = new Grid<>(Discapacitado_VIsual.class, false);
        grid.addColumn(Discapacitado_VIsual::getName).setHeader("Nombre");
        grid.addColumn(Discapacitado_VIsual::getApellido).setHeader("Apellido");
        grid.addColumn(Discapacitado_VIsual::getEmail).setHeader("Email");
        grid.addColumn(Discapacitado_VIsual::getEdificios).setHeader("Edificios");
        grid.addColumn(Discapacitado_VIsual::getMapa).setHeader("Mapas");

        //Rellenno el arrayilst, con los datos recibidos
        /*try {
            listaEstablecimientos = DataService.obtenerListaEstablecimientos();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        grid.setItems(listaEstablecimientos);*/

        add(horizontalbtnAtras,img,tit,grid);

    }
}
