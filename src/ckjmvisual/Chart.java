/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ckjmvisual;

import java.util.ArrayList;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Sakis
 */
public class Chart {
    ArrayList<JavaFile> js;
    
    public Chart(Project p){
                
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        dataset.setValue( p.getAllAnalysis().size() ,"hello" ,"dribe");
        dataset.setValue( p.getAllAnalysis().size() ,"hello" ,"dribe");
        dataset.setValue( p.getAllAnalysis().size() ,"hello" ,"dribe");        
        
        JFreeChart chart = ChartFactory.createLineChart("TestChart", "Metric Name", "Metric Value", dataset);
        
        ChartFrame frame = new ChartFrame("Test", chart);
        frame.setVisible(true);
        frame.setSize(400, 400);
    }
   
   
}
