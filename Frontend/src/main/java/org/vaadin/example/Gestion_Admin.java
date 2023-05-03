package org.vaadin.example;
import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.FocusNotifier;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.ItemDoubleClickEvent;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.button.Button; // importar la clase Button de Vaadin
import com.vaadin.flow.server.StreamResource;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;


import javax.imageio.ImageIO;
import javax.management.Notification;
import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;

@Route("gestionAdmin")
@Theme(value = Lumo.class, variant = Lumo.LIGHT)
@CssImport("./styles/front.css")
public class Gestion_Admin extends VerticalLayout {
    private Anchor botonDescarga;
    public void gestionAdminView(Admin administrador){
        HorizontalLayout horizontalbtnAtras = new HorizontalLayout();
        Button atrasButton = new Button("Atras");
        atrasButton.addClassName("btn_atras");
        Button reloadButton = new Button("Refrescar");
        reloadButton.addClassName("btn_reload");
        horizontalbtnAtras.add(reloadButton,atrasButton);
        horizontalbtnAtras.setAlignItems(Alignment.END);
        ArrayList<Jefe_Establecimiento> listaEstablecimientos = new ArrayList<>();
        Jefe_Establecimiento antiguojefeEstablecimiento = new Jefe_Establecimiento();


        Dialog dialog = new Dialog();
        dialog.setHeight("800");
        dialog.setWidth("300");
        dialog.getElement().setAttribute("aria-label", "Mostrar/editar Establecimientos");

        H1 tit = new H1("Gestión de Establecimientos");
        tit.addClassName("tit_admin");
        H3 listaEstados = new H3("LISTA DE ESTADOS");

        //Creamos la lista donde se detallan los distintos tipos de estado
        VerticalLayout vLEstados = new VerticalLayout();
        Label estado0 = new Label("0 -> Se están comprobando los datos del registro de Jefe Establecimiento.");
        Label estado1 = new Label("\n"+"1 -> Ya están comprobados sus datos, se pide al Jefe que suba el mapa de su establecimiento para poder diseñar el sistema VIT a su medida.");
        Label estado2 = new Label("\n"+"2 -> Se está analizando el mapa del Jefe.");
        Label estado3 = new Label("\n"+"3 -> Los técnicos están de camino al establecimiento.");
        Label estado4 = new Label("\n"+ "4 -> YA ERES VIT! Gracias por confiar en nosotros.");
        vLEstados.add(estado0, estado1, estado2, estado3, estado4);
        vLEstados.setClassName("lista_estados");
        vLEstados.setAlignItems(Alignment.CENTER);//Alineamos los elementos al centro

        H3 tituloGrid = new H3("Lista de establecimientos");
        StreamResource imageResource = new StreamResource("logo.png",
                () -> getClass().getResourceAsStream("/images/icono_VITAPP.png"));

        Image img = new Image(imageResource, "");
        img.setWidth("200px");

        VerticalLayout vl1 = new VerticalLayout();
        VerticalLayout vl2 = new VerticalLayout();
        VerticalLayout vl3 = new VerticalLayout();
        VerticalLayout vl4 = new VerticalLayout();
        HorizontalLayout hl1 = new HorizontalLayout();
        HorizontalLayout hl2 = new HorizontalLayout();
        HorizontalLayout hl3 = new HorizontalLayout();
        VerticalLayout vlDialog = new VerticalLayout();


        Label etiqueta1 = new Label("Dirección");
        TextField texto1 = new TextField();
        Label etiqueta2 = new Label("Ciudad");
        TextField texto2 = new TextField();
        Label etiqueta3 = new Label("Codigo Postal");
        TextField texto3 = new TextField();
        Label etiqueta4 = new Label("CIF");
        TextField texto4 = new TextField();
        texto4.setEnabled(false);
        Label etiqueta5 = new Label("Nombre Establecimiento");
        TextField texto5 = new TextField();
        Label etiqueta6 = new Label("Nombre");
        TextField texto6 = new TextField();
        Label etiqueta7 = new Label("Apellido");
        TextField texto7 = new TextField();
        ComboBox<String> comboEstado = new ComboBox<>("Estado");
        comboEstado.setItems("0","1","2","3","4");
        Label etiqueta9 = new Label("Email");
        TextField texto9 = new TextField();
        Button boton = new Button("Actualizar");
        Button boton2 = new Button("Cancelar");
        Button boton3 = new Button("Borrar");

        botonDescarga = new Anchor();
        botonDescarga.getElement().setAttribute("download", true);
        botonDescarga.getElement().getStyle().set("padding", "10px");

        boton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        boton2.addThemeVariants(ButtonVariant.LUMO_CONTRAST);
        boton3.addThemeVariants(ButtonVariant.LUMO_ERROR);

        vl1.add(etiqueta1, texto1, etiqueta2, texto2);
        vl2.add(etiqueta3, texto3, etiqueta4, texto4);
        vl3.add(etiqueta5, texto5, etiqueta6, texto6);
        vl4.add(etiqueta7, texto7, etiqueta9, texto9);

        hl1.add(vl1, vl2, vl3, vl4);
        hl1.setAlignItems(Alignment.CENTER);
        hl2.add(comboEstado);
        hl2.setPadding(true);
        hl2.setAlignItems(Alignment.CENTER);
        hl3.add(boton, boton2, boton3, botonDescarga);
        hl3.setAlignItems(Alignment.CENTER);
        vlDialog.add(hl1, hl2, hl3);
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
                ArrayList <Jefe_Establecimiento> listaaux = new ArrayList<>();
                try {
                    listaaux = DataService.obtenerListaEstablecimientos();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (URISyntaxException e) {
                    throw new RuntimeException(e);
                }

                antiguojefeEstablecimiento.setDireccion(event.getItem().getDireccion());
                antiguojefeEstablecimiento.setCiudad(event.getItem().getCiudad());
                antiguojefeEstablecimiento.setCodigo_Postal(event.getItem().getCodigo_Postal());
                antiguojefeEstablecimiento.setCif(event.getItem().getCif());
                antiguojefeEstablecimiento.setNombre_establecimiento(event.getItem().getNombre_establecimiento());
                antiguojefeEstablecimiento.setName(event.getItem().getName());
                antiguojefeEstablecimiento.setApellido(event.getItem().getApellido());
                antiguojefeEstablecimiento.setEmail(event.getItem().getEmail());
                antiguojefeEstablecimiento.setEstado(event.getItem().getEstado());

                for (Jefe_Establecimiento jefe: listaaux
                     ) {
                    System.out.println(jefe.toString());
                    if (antiguojefeEstablecimiento.getCif().equals(jefe.getCif())){
                        antiguojefeEstablecimiento.setPassword(jefe.getPassword());
                        System.out.println("Contraseña cambiada");
                    }
                }

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
                texto6.setValue(antiguojefeEstablecimiento.getName());
                texto7.setValue(antiguojefeEstablecimiento.getApellido());
                comboEstado.setValue(antiguojefeEstablecimiento.getEstado());
                texto9.setValue(antiguojefeEstablecimiento.getEmail());
            }
        });

        grid.addItemDoubleClickListener(new ComponentEventListener<ItemDoubleClickEvent<Jefe_Establecimiento>>() {
            @Override
            public void onComponentEvent(ItemDoubleClickEvent<Jefe_Establecimiento> event) {
                BufferedImage imagen = null;
                try {
                    imagen = DataService.obtenerImagen(event.getItem().getCif());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (URISyntaxException e) {
                    throw new RuntimeException(e);
                }


// Crear un objeto StreamResource que contiene los datos de la imagen
                BufferedImage finalImagen = imagen;
                StreamResource resource = new StreamResource("mapa"+ antiguojefeEstablecimiento.getCif()+".jpg", () -> {
                    ByteArrayOutputStream bos = new ByteArrayOutputStream();
                    try {
                        ImageIO.write(finalImagen, "jpg", bos);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return new ByteArrayInputStream(bos.toByteArray());
                });

                botonDescarga.setHref(resource);
                botonDescarga.setText("Descargar imagen");


            }
        });


        boton.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
            @Override
            public void onComponentEvent(ClickEvent<Button> buttonClickEvent) {
                ArrayList<Jefe_Establecimiento> listaEstablecimientosaux = new ArrayList<>();
                ArrayList<Jefe_Establecimiento> listaEstablecimientosaux2 = new ArrayList<>();
                String direccion = texto1.getValue();
                String ciudad = texto2.getValue();
                String cod_postal = texto3.getValue();
                String cif = texto4.getValue();
                String nom_establecimiento = texto5.getValue();
                String name = texto6.getValue();
                String apellido = texto7.getValue();
                String estado = comboEstado.getValue();
                String email = texto9.getValue();
                Jefe_Establecimiento nuevo_establecimiento = new Jefe_Establecimiento();
                nuevo_establecimiento.setDireccion(direccion);
                nuevo_establecimiento.setCiudad(ciudad);
                nuevo_establecimiento.setCodigo_Postal(cod_postal);
                nuevo_establecimiento.setCif(cif);
                nuevo_establecimiento.setName(name);
                nuevo_establecimiento.setApellido(apellido);
                nuevo_establecimiento.setEstado(estado);
                nuevo_establecimiento.setEmail(email);
                nuevo_establecimiento.setPassword(antiguojefeEstablecimiento.getPassword());
                nuevo_establecimiento.setNombre_establecimiento(nom_establecimiento);
                System.out.println(nuevo_establecimiento);
                System.out.println(antiguojefeEstablecimiento);
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


        boton2.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
            @Override
            public void onComponentEvent(ClickEvent<Button> buttonClickEvent) {
                dialog.close();
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









        DataService data = new DataService();
        this.setAlignItems(Alignment.CENTER);
        this.setHeightFull();
        this.add(horizontalbtnAtras,img,tit, listaEstados, vLEstados, tituloGrid,grid);

        atrasButton.addClickListener(event -> {
            LoginView LV = new LoginView();
            removeAll();
            LV.LoginBasic();
            add(LV);
        });
        reloadButton.addClickListener(e -> {
            Gestion_Admin gA = new Gestion_Admin();
            Admin adminNew = new Admin();
            try {
                adminNew = data.comprobarAdminInicio(administrador.getEmail(), administrador.getPassword());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            removeAll();

            gA.gestionAdminView(adminNew);

            add(gA);

        });
    }
}
