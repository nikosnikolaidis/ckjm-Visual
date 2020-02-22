package ckjmvisual;

import java.io.IOException;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.layout.Pane;
import javax.swing.DefaultListModel;

public class ProjectFrame extends javax.swing.JFrame {

    Project project;
    LineChart_AWT chart;

    /**
     * Creates new form ProjectFrame
     */
    public ProjectFrame() {
        initComponents();
    }
    public ProjectFrame(Project p) {
        this.project = p;

        initComponents();
        populateIssueList();
        this.jLabelProjectName.setText(project.getName());
        getAverageMetrics();

        //create chart
        addChart();
    }
    
    //create and add Chart in resizable panel
    private void addChart(){
        LineChart_AWT chart = new LineChart_AWT(project, "Rate Chart", "Metrics Rate per Version");
        chart.pack( );
        //jPanelChart.add(chart.chartPanel);
        
        javax.swing.GroupLayout jPanelChartLayout = new javax.swing.GroupLayout(jPanelChart);
        jPanelChart.setLayout(jPanelChartLayout);
        jPanelChartLayout.setHorizontalGroup(
            jPanelChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelChartLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(chart.chartPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanelChartLayout.setVerticalGroup(
            jPanelChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelChartLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(chart.chartPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }

    //Populate List with JavaFiles
    private void populateIssueList() {
        if (!Main.projects.isEmpty()) {
            DefaultListModel<JavaFile> defaultListModel = new DefaultListModel<>();
            //Collections.sort(project.getprojectReport().getIssuesList());
            for (JavaFile jf : project.getAllAnalysis().get(0).getJavaFiles()) {
                defaultListModel.addElement(jf);
            }
            jListJavaFile.setModel(defaultListModel);
            jListJavaFile.setCellRenderer(new PanelJavaFileList());
        }
    }

    // Calculate average metrics and populate jLabels
    private void getAverageMetrics() {
        double avCBO = 0;
        double avCa = 0;
        double avWMC= 0;
        double avDIT= 0;
        double avNOC= 0;
        double avRFC= 0;
        double avLCOM= 0;
        double avNPM= 0;
        for(JavaFile jf: project.getAllAnalysis().get(0).getJavaFiles()){
            avCBO += jf.getCBO();
            avCa += jf.getCa();
            avDIT += jf.getDIT();
            avLCOM += jf.getLCOM();
            avNOC += jf.getNOC();
            avNPM += jf.getNPM();
            avRFC += jf.getRFC();
            avWMC += jf.getWMC();
        }

        jLabelCBO.setText (avCBO/project.getAllAnalysis().get(0).getJavaFiles().size()+"");
        jLabelCa.setText (avCa/project.getAllAnalysis().get(0).getJavaFiles().size()+"");
        jLabelDIT.setText (avDIT/project.getAllAnalysis().get(0).getJavaFiles().size()+"");
        jLabelLCOM.setText (avLCOM/project.getAllAnalysis().get(0).getJavaFiles().size()+"");
        jLabelNOC.setText (avNOC/project.getAllAnalysis().get(0).getJavaFiles().size()+"");
        jLabelNPM.setText (avNPM/project.getAllAnalysis().get(0).getJavaFiles().size()+"");
        jLabelRFC.setText (avRFC/project.getAllAnalysis().get(0).getJavaFiles().size()+"");
        jLabelWMC.setText (avWMC/project.getAllAnalysis().get(0).getJavaFiles().size()+"");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabelProjectName = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabelWMC = new javax.swing.JLabel();
        jLabelDIT = new javax.swing.JLabel();
        jLabelNOC = new javax.swing.JLabel();
        jLabelCBO = new javax.swing.JLabel();
        jLabelRFC = new javax.swing.JLabel();
        jLabelLCOM = new javax.swing.JLabel();
        jLabelCa = new javax.swing.JLabel();
        jLabelNPM = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jListJavaFile = new javax.swing.JList<>();
        jPanelChart = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButton2.setText("New Analysis");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel1.setText("CJKM-Visual");

        jLabelProjectName.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabelProjectName.setText("jLabel2");

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel5.setLayout(new java.awt.GridLayout(2, 0));

        jLabel2.setText("WMC");
        jPanel5.add(jLabel2);

        jLabel3.setText("DIT");
        jPanel5.add(jLabel3);

        jLabel4.setText("NOC");
        jPanel5.add(jLabel4);

        jLabel5.setText("CBO");
        jPanel5.add(jLabel5);

        jLabel6.setText("RFC");
        jPanel5.add(jLabel6);

        jLabel7.setText("LCOM");
        jPanel5.add(jLabel7);

        jLabel8.setText("Ca");
        jPanel5.add(jLabel8);

        jLabel9.setText("NPM");
        jPanel5.add(jLabel9);

        jLabelWMC.setText("jLabel");
        jPanel5.add(jLabelWMC);

        jLabelDIT.setText("jLabel");
        jPanel5.add(jLabelDIT);

        jLabelNOC.setText("jLabel");
        jPanel5.add(jLabelNOC);

        jLabelCBO.setText("jLabel");
        jPanel5.add(jLabelCBO);

        jLabelRFC.setText("jLabel");
        jPanel5.add(jLabelRFC);

        jLabelLCOM.setText("jLabel");
        jPanel5.add(jLabelLCOM);

        jLabelCa.setText("jLabel");
        jPanel5.add(jLabelCa);

        jLabelNPM.setText("jLabel");
        jPanel5.add(jLabelNPM);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabelProjectName)
                                .addGap(28, 28, 28)
                                .addComponent(jButton2)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jLabelProjectName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel4.setLayout(new java.awt.GridLayout());

        jScrollPane3.setViewportView(jListJavaFile);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 559, Short.MAX_VALUE)
                .addGap(2, 2, 2))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        jPanel4.add(jPanel3);

        javax.swing.GroupLayout jPanelChartLayout = new javax.swing.GroupLayout(jPanelChart);
        jPanelChart.setLayout(jPanelChartLayout);
        jPanelChartLayout.setHorizontalGroup(
            jPanelChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 561, Short.MAX_VALUE)
        );
        jPanelChartLayout.setVerticalGroup(
            jPanelChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel4.add(jPanelChart);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            project.analyze();
            project.saveToFile();
            ProjectFrame projectF= new ProjectFrame(project);
            projectF.setVisible(true);
            this.dispose();
        } catch (IOException ex) {
            Logger.getLogger(ProjectFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ProjectFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProjectFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProjectFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProjectFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProjectFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelCBO;
    private javax.swing.JLabel jLabelCa;
    private javax.swing.JLabel jLabelDIT;
    private javax.swing.JLabel jLabelLCOM;
    private javax.swing.JLabel jLabelNOC;
    private javax.swing.JLabel jLabelNPM;
    private javax.swing.JLabel jLabelProjectName;
    private javax.swing.JLabel jLabelRFC;
    private javax.swing.JLabel jLabelWMC;
    private javax.swing.JList<JavaFile> jListJavaFile;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanelChart;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
