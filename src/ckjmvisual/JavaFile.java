
package ckjmvisual;


public class JavaFile {
    
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
