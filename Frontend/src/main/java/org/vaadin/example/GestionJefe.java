package org.vaadin.example;

import com.vaadin.flow.component.Component;
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
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;


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
        //Pestaña Estadisticas
        PaginaEstadisticas paginaEstadisticas = new PaginaEstadisticas();
        HorizontalLayout horizontalLayout5 = new HorizontalLayout();
        //paginaEstadisticas.estadisticasView();
        tabs.addSelectedChangeListener(new ComponentEventListener<Tabs.SelectedChangeEvent>() {
            @Override
            public void onComponentEvent(Tabs.SelectedChangeEvent event) {
                if(event.getSelectedTab().getId().toString().equals("Optional[Inicio]")){
                    horizontalLayout2.setVisible(true);
                    horizontalLayout4.setVisible(true);
                    horizontalLayout5.setVisible(false);
                }
                else{
                    horizontalLayout2.setVisible(false);
                    horizontalLayout4.setVisible(false);
                    horizontalLayout5.setVisible(true);
                }
            }
        });
        this.add(horizontalLayout,horizontalLayout1, tabs, horizontalLayout2, horizontalLayout5);

        MultiFileMemoryBuffer buffer = new MultiFileMemoryBuffer();
        Upload upload = new Upload(buffer);

        upload.addSucceededListener(event -> {
            String fileName = event.getFileName();
            InputStream inputStream = buffer.getInputStream(fileName);

            // Do something with the file data
            // processFile(inputStream, fileName);
        });
        this.add(horizontalLayout4);
        horizontalLayout4.add(upload);
        estadoImagen(jefe, horizontalLayout4);
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
                break;
        }

    }
}

