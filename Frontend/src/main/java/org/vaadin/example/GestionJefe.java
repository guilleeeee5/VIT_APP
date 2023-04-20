package org.vaadin.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nimbusds.jose.shaded.json.JSONObject;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.charts.Chart;
import com.vaadin.flow.component.charts.model.DataSeries;
import com.vaadin.flow.component.charts.model.PlotOptionsColumn;
import com.vaadin.flow.component.charts.model.XAxis;
import com.vaadin.flow.component.charts.model.YAxis;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.tabs.TabsVariant;
import com.vaadin.flow.component.upload.Receiver;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MultiFileMemoryBuffer;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.StreamResource;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Base64;


@Route("gestionJefe")
@Theme(value = Lumo.class, variant = Lumo.LIGHT)
@CssImport("./styles/front.css")
public class GestionJefe extends VerticalLayout {

    public void gestionJefeView(Jefe_Establecimiento jefe) throws IOException, URISyntaxException, InterruptedException {
        //Creación de Layouts
        HorizontalLayout horizontalTitulo = new HorizontalLayout();
        HorizontalLayout horizontalBienvenida = new HorizontalLayout();
        HorizontalLayout horizontalEstado = new HorizontalLayout();
        HorizontalLayout horizontalLayoutUpload = new HorizontalLayout();
        HorizontalLayout horizontalEstadisticas = new HorizontalLayout();
        HorizontalLayout horizontalTecnico = new HorizontalLayout();
        HorizontalLayout horizontalConfeti = new HorizontalLayout();
        HorizontalLayout layoutMapa = new HorizontalLayout();

        //Bienvenida
        //Imagen VitApp
        StreamResource iconoVitApp = new StreamResource("VitApp.png",
                () -> getClass().getResourceAsStream("/images/icono_VITAPP.png"));
        Image imagenVitApp = new Image(iconoVitApp, "");
        imagenVitApp.setWidth("200px");
        //Titulos principales
        H1 tit = new H1("Gestión de Jefe de Establecimiento");
        H2 bienvenida = new H2("Bienvenido, " + jefe.getName().toUpperCase() + " su establecimiento es: " + jefe.getNombre_establecimiento().toUpperCase());

        //Añadimos los titulos
        horizontalTitulo.add(tit);
        horizontalBienvenida.add(bienvenida);
        //Pestañas
        Tab inicio = new Tab("Inicio");
        inicio.setId("Inicio");
        Tab estadisticas = new Tab("Estadisticas");
        estadisticas.setId("Estadisticas");
        Tabs tabs = new Tabs(inicio,estadisticas);
        /*
        Tabs tabs = new Tabs(
                inicio, estadisticas
        );*/
        tabs.addThemeVariants(TabsVariant.LUMO_HIDE_SCROLL_BUTTONS);

        //Mostramos estado
        Label estado = new Label(estadoTexto(jefe));
        horizontalEstado.add(estado);
        horizontalEstado.setVisible(true);

        //Configuracion del botón Upload imagen
        MultiFileMemoryBuffer buffer = new MultiFileMemoryBuffer();
        Upload upload = new Upload(buffer);
        upload.setAcceptedFileTypes("application/jpg", ".jpg");
        int maxFileSizeInBytes = 10 * 1024 * 1024; // 10MB
        upload.setMaxFileSize(maxFileSizeInBytes);
        upload.setMaxFiles(1);
        upload.addSucceededListener(event -> {
            try {
                String fileName = event.getFileName();
                InputStream inputStream = buffer.getInputStream(fileName);

                // Convertir la imagen a bytes
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                BufferedImage img = ImageIO.read(inputStream);
                ImageIO.write(img, "jpg", baos);
                byte[] imageBytes = baos.toByteArray();

                // Obtener el cif del jefe de establecimiento
                String cif = jefe.getCif();

                // Hacer la petición PUT al back
                HttpClient httpClient = HttpClient.newHttpClient();
                String url = "http://localhost:8081/Imagen/" + cif;
                HttpRequest httpRequest = HttpRequest.newBuilder()
                        .uri(URI.create(url))
                        .setHeader("Content-Type", "image/jpg")
                        .PUT(HttpRequest.BodyPublishers.ofByteArray(imageBytes))
                        .build();
                HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

                // Hacer algo con la respuesta del back
                System.out.println(response.body());
                DataService data2 = new DataService();
                //Jefe_Establecimiento jefeAux = data2.comprobarJefeInicio(jefe.getEmail(), jefe.getPassword());
                //gestionJefeView(jefeAux);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        });

        //Añadimos el objeto para subir la imagen
        horizontalLayoutUpload.add(upload);
        horizontalLayoutUpload.setVisible(false);

        //Imagen de estadistica
        StreamResource imageResource = new StreamResource("Estadisticas.png",
                () -> getClass().getResourceAsStream("/images/Estadisticas.png"));

        Image imgEstadisticas = new Image(imageResource, "");
        imgEstadisticas.setWidth("256px");
        horizontalEstadisticas.add(imgEstadisticas);

        //Imagen de icono Mecánico
        StreamResource imageResource1 = new StreamResource("mecanico.png",
                () -> getClass().getResourceAsStream("/images/mecanico.png"));

        Image imgTecnico = new Image(imageResource1, "");
        imgTecnico.setWidth("256px");
        horizontalTecnico.add(imgTecnico);

        //Imagen de icono Confeti
        StreamResource imageConfeti1 = new StreamResource("confeti.png",
                () -> getClass().getResourceAsStream("/images/confeti.png"));

        Image imageConfeti = new Image(imageConfeti1, "");
        imageConfeti.setWidth("256px");

        horizontalConfeti.add(imageConfeti);
        horizontalEstado.setVisible(true);//estado
        horizontalEstadisticas.setVisible(false);
        //imagen
        DataService data = new DataService();

        if(jefe.getEstado().equals("2")){
            // Obtener la imagen de la base de datos
            BufferedImage imagen = data.obtenerImagen(jefe.getCif());
            // Convertir la imagen en un objeto StreamResource
            StreamResource resource = new StreamResource("image.jpg", () -> {
                try {
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    ImageIO.write(imagen, "jpg", baos);
                    return new ByteArrayInputStream(baos.toByteArray());
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            });
            // Crear un objeto Image de Vaadin a partir del objeto StreamResource
            Image image = new Image(resource, "Imagen");
            layoutMapa.add(image);
        }
        // Agregar el HorizontalLayout a algún contenedor de diseño de la interfaz de usuario
        add(layoutMapa);

        switch (jefe.getEstado()) {
            case "0": //Se están revisando los datos del establecimiento
                //todo a false
                horizontalLayoutUpload.setVisible(false);
                horizontalTecnico.setVisible(false);
                horizontalConfeti.setVisible(false);
                layoutMapa.setVisible(false);
                break;
            case "1": //Ya se han confirmado los datos y permitimos subir el mapa
                //upload map estadisticas no
                horizontalConfeti.setVisible(false);
                horizontalLayoutUpload.setVisible(true);
                horizontalTecnico.setVisible(false);
                layoutMapa.setVisible(false);
                break;
            case "2": //Se está verificando el mapa
                horizontalConfeti.setVisible(false);
                ///ve el mapa
                horizontalLayoutUpload.setVisible(false);
                horizontalTecnico.setVisible(false);
                layoutMapa.setVisible(true);
                break;
            case "3": //Los técnicos están yendo al establecimiento
                horizontalConfeti.setVisible(false);
                ///ve la imagen de un técnico
                horizontalLayoutUpload.setVisible(false);
                horizontalTecnico.setVisible(true);
                layoutMapa.setVisible(false);
                break;
            case "4": //Se confirma que eres miembro de VIT y ves las estadísticas
                //Ve mapa y estadísticas
                horizontalLayoutUpload.setVisible(false);
                horizontalTecnico.setVisible(false);
                horizontalConfeti.setVisible(true);
                layoutMapa.setVisible(false);
                break;
        }

        //Se ejecuta cada vez que seleccionas una sección diferente
        tabs.addSelectedChangeListener(new ComponentEventListener<Tabs.SelectedChangeEvent>() {
            //SI ESTÁS EN LA PESTAÑA DE INICIO
            @Override
            public void onComponentEvent(Tabs.SelectedChangeEvent event) {

                if(event.getSelectedTab().getId().toString().equals("Optional[Inicio]")){
                    horizontalEstado.setVisible(true);//estado
                    horizontalEstadisticas.setVisible(false);

                    switch (jefe.getEstado()) {
                        case "0": //Se están revisando los datos del establecimiento
                            //todo a false
                            horizontalLayoutUpload.setVisible(false);
                            horizontalTecnico.setVisible(false);
                            horizontalConfeti.setVisible(false);
                            layoutMapa.setVisible(false);
                            break;
                        case "1": //Ya se han confirmado los datos y permitimos subir el mapa
                            //upload map estadisticas no
                            horizontalConfeti.setVisible(false);
                            horizontalLayoutUpload.setVisible(true);
                            horizontalTecnico.setVisible(false);
                            break;
                        case "2": //Se está verificando el mapa
                            horizontalConfeti.setVisible(false);
                            ///ve el mapa
                            horizontalLayoutUpload.setVisible(false);
                            horizontalTecnico.setVisible(false);
                            layoutMapa.setVisible(true);
                            layoutMapa.setVisible(true);
                            break;
                        case "3": //Los técnicos están yendo al establecimiento
                            horizontalConfeti.setVisible(false);
                            ///ve la imagen de un técnico
                            horizontalLayoutUpload.setVisible(false);
                            horizontalTecnico.setVisible(true);
                            layoutMapa.setVisible(false);
                            break;
                        case "4": //Se confirma que eres miembro de VIT y ves las estadísticas
                            //Ve mapa y estadísticas
                            horizontalLayoutUpload.setVisible(false);
                            horizontalTecnico.setVisible(false);
                            horizontalConfeti.setVisible(true);
                            layoutMapa.setVisible(false);
                            break;
                    }

                }
                else{ //SI ESTÁS EN LA PESTAÑA DE ESTADÍSTICAS, SOLO VES LAS ESTADÍSTICAS CUANDO ERES MIEMBRO VIT
                    horizontalEstado.setVisible(false);//estado
                    horizontalLayoutUpload.setVisible(false);//upload
                    horizontalTecnico.setVisible(false);
                    horizontalConfeti.setVisible(false);
                    layoutMapa.setVisible(false);
                    switch (jefe.getEstado()) {
                        case "0":
                            //todo a false
                            horizontalEstadisticas.setVisible(false);
                            break;
                        case "1":
                            //upload map estadisticas no
                            horizontalEstadisticas.setVisible(false);
                            break;
                        case "2":
                            horizontalEstadisticas.setVisible(false);
                            break;
                        case "3":
                            horizontalEstadisticas.setVisible(false);
                            break;
                        case "4":
                            //Ve mapa y estadísticas
                            horizontalEstadisticas.setVisible(true);
                            break;
                    }


                }
            }
        });

        this.add(imagenVitApp,horizontalTitulo,horizontalBienvenida, tabs, horizontalEstado, horizontalLayoutUpload, horizontalTecnico, horizontalEstadisticas, horizontalConfeti, layoutMapa);
        // Configurar layout
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
    }
    //MÉTODO QUE VA CAMBIANDO EL TEXTO DE "ESTADO"
    public String estadoTexto(Jefe_Establecimiento jefe) {
        String result = null;
        switch (jefe.getEstado()) {
            case "0":
                result = "Estamos comprobando sus datos, gracias por su paciencia. ";//no ve nada
                break;
            case "1":
                result = "Ya están comprobados sus datos, suba el mapa de su establecimiento para poder diseñar el sistema VIT a su medida. ";//upload map estadisticas no

                break;
            case "2":
                result = "Estamos analizando su mapa, gracias por su paciencia, si tienes algún problema o duda con el mapa que ves en pantalla no dudes en contactarnos vía correo. ";//ve el mapa
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

