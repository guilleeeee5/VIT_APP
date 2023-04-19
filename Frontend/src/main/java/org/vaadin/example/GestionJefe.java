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
import java.awt.image.BufferedImage;

import javax.swing.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Base64;


@Route("gestionJefe")
@Theme(value = Lumo.class, variant = Lumo.LIGHT)
@CssImport("./styles/front.css")
public class GestionJefe extends VerticalLayout {

    public void gestionJefeView(Jefe_Establecimiento jefe){

        HorizontalLayout horizontalLayout = new HorizontalLayout();
        HorizontalLayout horizontalLayout1 = new HorizontalLayout();
        HorizontalLayout horizontalLayout2 = new HorizontalLayout();
        HorizontalLayout horizontalLayout3 = new HorizontalLayout();
        //Bienvenida
        H1 tit = new H1("Gestión de Jefe de Establecimiento");
        H2 bienvenida = new H2("Bienvenido, " + jefe.getName() + " su establecimiento es: " + jefe.getNombre_establecimiento());
        horizontalLayout.add(tit);
        horizontalLayout1.add(bienvenida);
        //Pestañas
        Tab inicio = new Tab("Inicio");
        inicio.setId("Inicio");
        Tab estadisticas = new Tab("Estadisticas");
        estadisticas.setId("Estadisticas");
        Tabs tabs = new Tabs(inicio,estadisticas);
        tabs.addThemeVariants(TabsVariant.LUMO_HIDE_SCROLL_BUTTONS);
        //Mostramos estado
        Label estado = new Label(estadoTexto(jefe));
        horizontalLayout2.add(estado);
        horizontalLayout2.setVisible(true);
        HorizontalLayout horizontalLayout4 = new HorizontalLayout();
        tabs.addSelectedChangeListener(new ComponentEventListener<Tabs.SelectedChangeEvent>() {
            @Override
            public void onComponentEvent(Tabs.SelectedChangeEvent event) {
                if(event.getSelectedTab().getId().toString().equals("Optional[Inicio]")){
                    horizontalLayout2.setVisible(true);
                    //tabla2.setVisible(false);
                }
                else{
                    horizontalLayout2.setVisible(false);
                    //tabla2.setVisible(true);
                }
            }
        });
        this.add(horizontalLayout,horizontalLayout1, tabs, horizontalLayout2);

        //Pestaña Estadisticas


        MultiFileMemoryBuffer buffer = new MultiFileMemoryBuffer();
        Upload upload = new Upload(buffer);

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
                        .setHeader("Content-Type", "image/png")
                        .PUT(HttpRequest.BodyPublishers.ofByteArray(imageBytes))
                        .build();
                HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

                // Hacer algo con la respuesta del back
                System.out.println(response.body());

            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        });

        horizontalLayout4.add(upload);
        tabs.addSelectedChangeListener(new ComponentEventListener<Tabs.SelectedChangeEvent>() {
            @Override
            public void onComponentEvent(Tabs.SelectedChangeEvent event) {
                if(event.getSelectedTab().getId().toString().equals("Optional[Inicio]")){
                    horizontalLayout2.setVisible(true);
                    horizontalLayout4.setVisible(true);
                }
                else{
                    // Crea una ventana JFrame y agrega el componente JLabel
                    horizontalLayout2.setVisible(false);
                    estadoImagen(jefe, horizontalLayout4);
                    horizontalLayout4.setVisible(false);
                }
            }
        });
        this.add(horizontalLayout,horizontalLayout1, tabs, horizontalLayout2, horizontalLayout4);
    }
    public String estadoTexto(Jefe_Establecimiento jefe) {
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
    public void estadoImagen(Jefe_Establecimiento jefe, HorizontalLayout horizontalLayout) {
        StreamResource imageResource = new StreamResource("Estadisticas.png",
                () -> getClass().getResourceAsStream("/images/Estadisticas.png"));

        Image img = new Image(imageResource, "");
        switch (jefe.getEstado()) {
            case "0":
                //todo a false
                horizontalLayout.setVisible(false);
                break;
            case "1":
                //upload map estadisticas no
                horizontalLayout.setVisible(true);
                break;
            case "2":
                ///ve el mapa
                horizontalLayout.setVisible(false);
                break;
            case "3":
                ///ve la imagen de un técnico
                horizontalLayout.setVisible(false);
                break;
            case "4":
                //Ve mapa y estadísticas
                horizontalLayout.setVisible(false);
                img.setVisible(true);
                break;
        }
    }
}

