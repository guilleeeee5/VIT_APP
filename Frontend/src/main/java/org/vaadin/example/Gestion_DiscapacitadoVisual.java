package org.vaadin.example;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

@Route("gestion_DiscapacitadoVisual")
@Theme(value = Lumo.class, variant = Lumo.LIGHT)
@CssImport("./styles/front.css")
public class Gestion_DiscapacitadoVisual extends VerticalLayout {

    public void gestion_DiscapacitadoView() {
        
    }
}
