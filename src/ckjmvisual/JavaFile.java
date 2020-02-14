
package ckjmvisual;

import java.io.Serializable;


public class JavaFile implements Serializable, Comparable<JavaFile>{
    
    private String fileName;
    private int WMC;
    private int DIT;
    private int NOC;
    private int CBO;
    private int RFC;
    private int LCOM;
    private int Ca;
    private int NPM;

    public JavaFile(String fileName, int WMC, int DIT, int NOC, int CBO, int RFC, int LCOM, int Ca, int NPM) {
        this.fileName = fileName;
        this.WMC = WMC;
        this.DIT = DIT;
        this.NOC = NOC;
        this.CBO = CBO;
        this.RFC = RFC;
        this.LCOM = LCOM;
        this.Ca = Ca;
        this.NPM = NPM;
    }
    
    /**
     * Compares this and the other JavaFiles based on the metrics ratio
     * @param o the other javaFile
     */
    @Override
    public int compareTo(JavaFile o) {
        double thisTotal= getRatio(WMC, Main.WMC)+ getRatio(DIT, Main.DIT)+ getRatio(NOC, Main.NOC)+
                getRatio(CBO, Main.CBO)+ getRatio(RFC, Main.RFC)+ getRatio(LCOM, Main.LCOM)+
                getRatio(Ca, Main.Ca)+ getRatio(NPM, Main.NPM);
        double otherTotal= getRatio(o.getWMC(), Main.WMC)+ getRatio(o.getDIT(), Main.DIT)+ getRatio(o.getNOC(), Main.NOC)+
                getRatio(o.getCBO(), Main.CBO)+ getRatio(o.getRFC(), Main.RFC)+ getRatio(o.getLCOM(), Main.LCOM)+
                getRatio(o.getCa(), Main.Ca)+ getRatio(o.getNPM(), Main.NPM);
        
        if(thisTotal > otherTotal)
            return -1;
        else if (thisTotal < otherTotal)
            return 1;
        else
            return 0;
    }
    
    /**
     * Returns a ratio for a metric
     * @param metric the calculated metric
     * @param threshold the threshold for the metric
     */
    private double getRatio(int metric, int threshold){
        return metric/threshold;
    }
    
    // Getters //
    public String getFileName() {
        return fileName;
    }
    public int getWMC() {
        return WMC;
    }
    public int getDIT() {
        return DIT;
    }
    public int getNOC() {
        return NOC;
    }
    public int getCBO() {
        return CBO;
    }
    public int getRFC() {
        return RFC;
    }
    public int getLCOM() {
        return LCOM;
    }
    public int getCa() {
        return Ca;
    }
    public int getNPM() {
        return NPM;
    }

}
