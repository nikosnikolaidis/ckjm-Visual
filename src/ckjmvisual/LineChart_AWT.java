package ckjmvisual;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.ui.ApplicationFrame;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Sakis
 */
public class LineChart_AWT extends ApplicationFrame {

    Project project;
    ChartPanel chartPanel;

    public LineChart_AWT(Project p, String applicationTitle, String chartTitle) {
        super(applicationTitle);
        this.project = p;
        JFreeChart lineChart = ChartFactory.createLineChart(
                chartTitle,
                "Rate", "Value",
                createDataset(),
                PlotOrientation.VERTICAL,
                true, true, false);

        chartPanel = new ChartPanel( lineChart );
        chartPanel.setPreferredSize( new java.awt.Dimension( 400, 600) );
        setContentPane( chartPanel );
    }

    private DefaultCategoryDataset createDataset() {
        ArrayList<Analysis> allAnal = project.getAllAnalysis();
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        Collections.reverse(allAnal);
        int version = 1;
        for (Analysis anal : allAnal) {
            double num= anal.caluclateRateAverage();
            dataset.setValue(num, "Rate", "Version " + version);
         
            version++;
        }

        return dataset;
    }

}
