package ckjmvisual;


import java.util.ArrayList;
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
public class LineChart_AWT extends ApplicationFrame{
    
    Project project;
    
    public LineChart_AWT(Project p, String applicationTitle , String chartTitle ) {
      super(applicationTitle);
      this.project = p;
      JFreeChart lineChart = ChartFactory.createLineChart(
         chartTitle,
         "Metric","Value",
         createDataset(),
         PlotOrientation.VERTICAL,
         true,true,false);
         
      ChartPanel chartPanel = new ChartPanel( lineChart );
      chartPanel.setPreferredSize( new java.awt.Dimension( 900 , 700 ) );
      setContentPane( chartPanel );
   }
   
   private DefaultCategoryDataset createDataset(){
        ArrayList<Analysis> allAnal = project.getAllAnalysis();
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        
        
        for(Analysis anal: allAnal){
            ArrayList<JavaFile> jFile = anal.getJavaFiles();
            int num;
            for(int i = 0; i<jFile.size(); i++){

                num = jFile.get(i).getRFC();
                
                dataset.setValue(num, "Metric " + (i+1), "Values " + (i+1)); 
                
            }
        }        
        System.out.println(dataset.getValue(0, 0));

        return dataset;
   }
}
