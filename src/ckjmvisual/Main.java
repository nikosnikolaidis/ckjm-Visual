
package ckjmvisual;

import java.util.ArrayList;
import java.io.*;

public class Main {
    
    public static final int WMC= 10;
    public static final int DIT= 10;
    public static final int NOC= 10;
    public static final int CBO= 10;
    public static final int RFC= 100;
    public static final int LCOM= 20;
    public static final int Ca= 10;
    public static final int NPM= 3;
    
    public static ArrayList<Project> projects = new ArrayList<>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        getProjetsFromFile();
        HomeFrame homeFrame=new HomeFrame();
        homeFrame.setVisible(true);
     
        
    }
    
    // Get saved Projects from file
    public static void getProjetsFromFile() {
        FileInputStream fi;
        try {
            fi = new FileInputStream(new File("projects.ser"));
            ObjectInputStream oi = new ObjectInputStream(fi);

            projects = (ArrayList<Project>) oi.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("ckjmvisual.Main.getProjetsFromFile()");
        }
    }
}
