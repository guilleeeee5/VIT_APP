import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

@CssImport(value="./styles/chart-panel.css")
public class ChartView extends VerticalLayout {

    public ChartView() {
        // Crea un dataset con algunos datos
        CategoryDataset dataset = createDataset();

        // Crea el gráfico
        JFreeChart chart = createChart(dataset);

        // Crea un wrapper para el gráfico que se puede agregar a un layout de Vaadin
        ChartPanelWrapper chartPanel = new ChartPanelWrapper(chart);
        chartPanel.setBackgroundColor(Color.WHITE);

        // Crea un layout horizontal y agrega el wrapper del gráfico
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.add((Component) chartPanel);

        // Agrega el layout horizontal al layout vertical de la vista
        add(horizontalLayout);
    }

    private CategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(10, "Series 1", "Category 1");
        dataset.addValue(20, "Series 1", "Category 2");
        dataset.addValue(30, "Series 1", "Category 3");
        dataset.addValue(40, "Series 1", "Category 4");
        return dataset;
    }

    private JFreeChart createChart(CategoryDataset dataset) {
        JFreeChart chart = ChartFactory.createBarChart(
                "Example Chart",
                "Category",
                "Value",
                dataset,
                PlotOrientation.VERTICAL,
                false,
                true,
                false);
        return chart;
    }

}
