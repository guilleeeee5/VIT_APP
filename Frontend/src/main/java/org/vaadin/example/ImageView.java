package org.vaadin.example;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("imagen")
public class ImageView extends VerticalLayout {

    public Component ImageView() {
        // Crea un componente de imagen y establece la URL de la imagen
        Image image = new Image("https://example.com/image.jpg", "Imagen de chart de ejemplo");

        // Agrega el componente de imagen al diseño vertical
        add(image);

        return image;
    }
}

