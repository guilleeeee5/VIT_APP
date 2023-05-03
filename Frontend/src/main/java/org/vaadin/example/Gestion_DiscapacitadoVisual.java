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
import java.util.ArrayList;
import java.util.List;

@Route("gestion_DiscapacitadoVisual")
@Theme(value = Lumo.class, variant = Lumo.LIGHT)
@CssImport("./styles/front.css")
public class Gestion_DiscapacitadoVisual extends VerticalLayout {

    public void gestion_DiscapacitadoView(Discapacitado_VIsual discapacitado) {

        ArrayList<Discapacitado_VIsual> listaDiscapacitado = new ArrayList<>();

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
        H1 tit = new H1("Establecimientos visitados por: "+ discapacitado.getName());
        tit.addClassName("tit_admin");

        HorizontalLayout horizontalgrid = new HorizontalLayout();
        // Generar la tabla con los campos arriba puestos.
        Grid<Discapacitado_VIsual> grid2 = new Grid<>(Discapacitado_VIsual.class, false);
        grid2.isVerticalScrollingEnabled();
        grid2.addColumn(Discapacitado_VIsual::getEdificios).setHeader("Edificios");
        grid2.addColumn(Discapacitado_VIsual::getCalle).setHeader("Calle");
        grid2.addColumn(Discapacitado_VIsual::getFechaentrada).setHeader("Fecha entrada");
        grid2.addColumn(Discapacitado_VIsual::getFechasalida).setHeader("Fecha salida");


        //Rellenno el arrayilst, con los datos recibidos
        // create some Discapacitado_Visual objects
        Discapacitado_VIsual d1 = new Discapacitado_VIsual("Lidl", "Calle Nunki", "2023-04-30 09:30:24", "2023-04-30 11:00:10");
        Discapacitado_VIsual d2 = new Discapacitado_VIsual("Mercadona", "Calle Jazmin", "2023-04-30 11:30:24", "2023-04-30 13:00:10");
        Discapacitado_VIsual d3 = new Discapacitado_VIsual("Manolo", "Calle Zenobia", "2023-05-02 09:20:15", "2023-05-02 11:59:37");
        Discapacitado_VIsual d4 = new Discapacitado_VIsual("Lidl", "Calle Nunki", "2023-05-03 12:17:00", "2023-05-03 12:45:13");
        Discapacitado_VIsual d5 = new Discapacitado_VIsual("Mercadona", "Calle Jazmin", "2023-05-03 13:17:05", "2023-05-03 17:10:15");
        listaDiscapacitado.addAll(List.of(d5, d4, d3, d2, d1));
        grid2.setItems(listaDiscapacitado);


        this.add(horizontalbtnAtras,img,tit,grid2);
        // Configurar layout
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
        atrasButton.addClickListener(event -> {
            LoginView LV = new LoginView();
            removeAll();
            LV.LoginBasic();
            add(LV);
        });
    }
}
