/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ckjmvisual;

import java.awt.Component;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author Nikos
 */
public class PanelJavaFileList extends javax.swing.JPanel implements ListCellRenderer<JavaFile>{

    /**
     * Creates new form PanelJavaFileList
     */
    public PanelJavaFileList() {
        initComponents();
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
        jLabelJavaFileName = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabelWMC = new javax.swing.JLabel();
        jLabelDIT = new javax.swing.JLabel();
        jLabelNOC = new javax.swing.JLabel();
        jLabelCBO = new javax.swing.JLabel();
        jLabelRFC = new javax.swing.JLabel();
        jLabelLCOM = new javax.swing.JLabel();
        jLabelCa = new javax.swing.JLabel();
        jLabelNPM = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabelJavaFileName.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabelJavaFileName.setText("jLabel1");

        jPanel2.setLayout(new java.awt.GridLayout(2, 8, 3, 2));

        jLabel1.setText("WMC");
        jPanel2.add(jLabel1);

        jLabel2.setText("DIT");
        jPanel2.add(jLabel2);

        jLabel3.setText("NOC");
        jPanel2.add(jLabel3);

        jLabel4.setText("CBO");
        jPanel2.add(jLabel4);

        jLabel5.setText("RFC");
        jPanel2.add(jLabel5);

        jLabel6.setText("LCOM");
        jPanel2.add(jLabel6);

        jLabel7.setText("Ca");
        jPanel2.add(jLabel7);

        jLabel8.setText("NPM");
        jPanel2.add(jLabel8);

        jLabelWMC.setText("jLabel");
        jPanel2.add(jLabelWMC);

        jLabelDIT.setText("jLabel");
        jPanel2.add(jLabelDIT);

        jLabelNOC.setText("jLabel");
        jPanel2.add(jLabelNOC);

        jLabelCBO.setText("jLabel");
        jPanel2.add(jLabelCBO);

        jLabelRFC.setText("jLabel");
        jPanel2.add(jLabelRFC);

        jLabelLCOM.setText("jLabel");
        jPanel2.add(jLabelLCOM);

        jLabelCa.setText("jLabel");
        jPanel2.add(jLabelCa);

        jLabelNPM.setText("jLabel");
        jPanel2.add(jLabelNPM);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabelJavaFileName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabelJavaFileName)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelCBO;
    private javax.swing.JLabel jLabelCa;
    private javax.swing.JLabel jLabelDIT;
    private javax.swing.JLabel jLabelJavaFileName;
    private javax.swing.JLabel jLabelLCOM;
    private javax.swing.JLabel jLabelNOC;
    private javax.swing.JLabel jLabelNPM;
    private javax.swing.JLabel jLabelRFC;
    private javax.swing.JLabel jLabelWMC;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables

    @Override
    public Component getListCellRendererComponent(JList<? extends JavaFile> list, JavaFile value, int index, boolean isSelected, boolean cellHasFocus) {
        this.jLabelJavaFileName.setText(value.getFileName());
        this.jLabelCBO.setText(value.getCBO()+"");
        this.jLabelCa.setText(value.getCa()+"");
        this.jLabelDIT.setText(value.getDIT()+"");
        this.jLabelLCOM.setText(value.getLCOM()+"");
        this.jLabelNOC.setText(value.getNOC()+"");
        this.jLabelNPM.setText(value.getNPM()+"");
        this.jLabelRFC.setText(value.getRFC()+"");
        this.jLabelWMC.setText(value.getWMC()+"");
        
        return this;
    }
}