package org.vaadin.example;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.ItemDoubleClickEvent;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.button.Button; // importar la clase Button de Vaadin
import com.vaadin.flow.server.StreamResource;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;


import javax.management.Notification;
import javax.swing.*;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;

@Route("gestionAdmin")
@Theme(value = Lumo.class, variant = Lumo.LIGHT)
@CssImport("./styles/front.css")
public class Gestion_Admin extends VerticalLayout {

    public void gestionAdminView(){
        ArrayList<Jefe_Establecimiento> listaEstablecimientos = new ArrayList<>();
        Jefe_Establecimiento antiguojefeEstablecimiento = new Jefe_Establecimiento();


        Dialog dialog = new Dialog();
        dialog.setHeight("800");
        dialog.setWidth("300");
        dialog.getElement().setAttribute("aria-label", "Mostrar/editar Establecimientos");


        VerticalLayout vl1 = new VerticalLayout();
        VerticalLayout vl2 = new VerticalLayout();
        VerticalLayout vl3 = new VerticalLayout();
        HorizontalLayout hl1 = new HorizontalLayout();
        HorizontalLayout hl2 = new HorizontalLayout();
        VerticalLayout vlDialog = new VerticalLayout();

        Label etiqueta1 = new Label("Dirección");
        TextField texto1 = new TextField();
        Label etiqueta2 = new Label("Ciudad");
        TextField texto2 = new TextField();
        Label etiqueta3 = new Label("Codigo Postal");
        TextField texto3 = new TextField();
        Label etiqueta4 = new Label("CIF");
        TextField texto4 = new TextField();
        Label etiqueta5 = new Label("Nombre Establecimiento");
        TextField texto5 = new TextField();

        Button boton = new Button("Actualizar");
        Button boton2 = new Button("Cancelar");
        Button boton3 = new Button("Borrar");
        boton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        boton2.addThemeVariants(ButtonVariant.LUMO_CONTRAST);
        boton3.addThemeVariants(ButtonVariant.LUMO_ERROR);

        vl1.add(etiqueta1, texto1, etiqueta2, texto2);
        vl2.add(etiqueta3, texto3, etiqueta4, texto4);
        vl3.add(etiqueta5, texto5);
        hl1.add(vl1, vl2, vl3);
        hl1.setAlignItems(Alignment.CENTER);
        hl2.add(boton, boton2, boton3);
        hl2.setAlignItems(Alignment.CENTER);
        vlDialog.add(hl1, hl2);
        dialog.add(vlDialog);

        // Generar la tabla con los campos arriba puestos.
        Grid<Jefe_Establecimiento> grid = new Grid<>(Jefe_Establecimiento.class, false);
        grid.addColumn(Jefe_Establecimiento::getName).setHeader("Nombre");
        grid.addColumn(Jefe_Establecimiento::getApellido).setHeader("Apellido");
        grid.addColumn(Jefe_Establecimiento::getEmail).setHeader("Email");
        grid.addColumn(Jefe_Establecimiento::getCif).setHeader("CIF");
        grid.addColumn(Jefe_Establecimiento::getID).setHeader("ID_Establecimiento").setSortable(true);
        grid.addColumn(Jefe_Establecimiento::getNombre_establecimiento).setHeader("Nombre_Establecimiento");
        grid.addColumn(Jefe_Establecimiento::getCiudad).setHeader("Ciudad");
        grid.addColumn(Jefe_Establecimiento::getCodigo_Postal).setHeader("Código Postal");
        grid.addColumn(Jefe_Establecimiento::getDireccion).setHeader("Dirección");
        grid.addColumn(Jefe_Establecimiento::getEstado).setHeader("Estado");


        //Rellenno el arrayilst, con los datos recibidos
        try {
            listaEstablecimientos = DataService.obtenerListaEstablecimientos();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        grid.setItems(listaEstablecimientos);

        grid.addItemDoubleClickListener(new ComponentEventListener<ItemDoubleClickEvent<Jefe_Establecimiento>>() {
            @Override
            public void onComponentEvent(ItemDoubleClickEvent<Jefe_Establecimiento> event) {
                antiguojefeEstablecimiento.setDireccion(event.getItem().getDireccion());
                antiguojefeEstablecimiento.setCiudad(event.getItem().getCiudad());
                antiguojefeEstablecimiento.setCodigo_Postal(event.getItem().getCodigo_Postal());
                antiguojefeEstablecimiento.setCif(event.getItem().getCif());
                antiguojefeEstablecimiento.setNombre_establecimiento(event.getItem().getNombre_establecimiento());
            }
        });
        grid.addItemDoubleClickListener(event -> dialog.open());

        grid.addItemDoubleClickListener(new ComponentEventListener<ItemDoubleClickEvent<Jefe_Establecimiento>>() {
            @Override
            public void onComponentEvent(ItemDoubleClickEvent<Jefe_Establecimiento> jefeEstablecimientoItemDoubleClickEvent) {
                texto1.setValue(antiguojefeEstablecimiento.getDireccion());
                texto2.setValue(antiguojefeEstablecimiento.getCiudad());
                texto3.setValue(antiguojefeEstablecimiento.getCodigo_Postal());
                texto4.setValue(antiguojefeEstablecimiento.getCif());
                texto5.setValue(antiguojefeEstablecimiento.getNombre_establecimiento());
            }
        });

        boton.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
            @Override
            public void onComponentEvent(ClickEvent<Button> buttonClickEvent) {
                ArrayList<Jefe_Establecimiento> listaEstablecimientosaux = new ArrayList<>();
                ArrayList<Jefe_Establecimiento> listaEstablecimientosaux2 = new ArrayList<>();
                try {
                    listaEstablecimientosaux2 = DataService.obtenerListaEstablecimientos();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (URISyntaxException e) {
                    throw new RuntimeException(e);
                }
                String direccion = texto1.getValue();
                String ciudad = texto2.getValue();
                String cod_postal = texto3.getValue();
                String cif = texto4.getValue();
                String nom_establecimiento = texto5.getValue();
                Jefe_Establecimiento nuevo_establecimiento = new Jefe_Establecimiento();
                nuevo_establecimiento.setDireccion(direccion);
                nuevo_establecimiento.setCiudad(ciudad);
                nuevo_establecimiento.setCodigo_Postal(cod_postal);
                nuevo_establecimiento.setCif(cif);
                nuevo_establecimiento.setNombre_establecimiento(nom_establecimiento);

                if(antiguojefeEstablecimiento.toString().equals(nuevo_establecimiento.toString())){
                    System.out.printf("Es el mismo objeto");
                }
                else{
                    listaEstablecimientosaux.add(antiguojefeEstablecimiento);
                    listaEstablecimientosaux.add(nuevo_establecimiento);
                    try {
                        listaEstablecimientosaux2 = DataService.actualizarEstablecimiento(listaEstablecimientosaux);
                        grid.setItems(listaEstablecimientosaux2);
                        dialog.close();
                    } catch (URISyntaxException e) {
                        throw new RuntimeException(e);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    grid.setItems(listaEstablecimientosaux2);
                }

            }
        });


        boton3.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
            @Override
            public void onComponentEvent(ClickEvent<Button> buttonClickEvent) {
                ArrayList<Jefe_Establecimiento> listaEstablecimientosaux = new ArrayList<>();
                try {
                    listaEstablecimientosaux = DataService.eliminarJefeEstablecimiento(antiguojefeEstablecimiento.getCif());
                    grid.setItems(listaEstablecimientosaux);
                    dialog.close();
                } catch (URISyntaxException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });










        this.setAlignItems(Alignment.CENTER);
        this.setHeightFull();
        this.add(grid);


    }
}
