/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ckjmvisual;

import java.awt.Color;
import java.util.ArrayList;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Sakis
 */
public class Chart {
    Project p;
    ArrayList<Analysis> allAnal;
    
    public Chart(Project p){
        
        
        allAnal = p.getAllAnalysis();
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for(Analysis anal: allAnal){
            ArrayList<JavaFile> jFile = anal.getJavaFiles();
            for(JavaFile jf: jFile){
                dataset.setValue(jf.getRFC(),"RFC","Value");
                dataset.setValue(jf.getLCOM(),"LCOM","Value");
                System.out.println(dataset);
            }
        }        
        
        System.out.println(dataset);
        JFreeChart chart = ChartFactory.createLineChart("TestChart", "Metric Name", "Metric Value", 
                dataset,PlotOrientation.VERTICAL, true , true, false);
        
        chart.setBackgroundPaint(Color.WHITE);
        CategoryPlot pl = chart.getCategoryPlot();
        pl.setRangeGridlinePaint(Color.BLUE);
        ChartFrame frame = new ChartFrame("Test", chart);
        frame.setVisible(true);
        frame.setSize(800, 400);
    }
   
   
}
