
package ckjmvisual;

import java.util.ArrayList;
import java.io.*;

public class Main {
    
    public static final int WMC= 100;
    public static final int DIT= 5;
    public static final int NOC= 10;
    public static final int CBO= 5;
    public static final int RFC= 100;
    public static final int LCOM= 20;
    public static final int Ca= 20;
    public static final int NPM= 40;
    public static HomeFrame homeFrame;
    public static ArrayList<Project> projects = new ArrayList<>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        getProjetsFromFile();
        homeFrame=new HomeFrame();
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
