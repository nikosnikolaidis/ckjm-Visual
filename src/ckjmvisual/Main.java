
package ckjmvisual;

import java.util.ArrayList;
import java.io.*;

public class Main {
    
    public static ArrayList<Project> project = new ArrayList<>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        HomeFrame homeFrame=new HomeFrame();
        homeFrame.setVisible(true);
        Project p=new Project("as", "C:\\Users\\Nikos\\Desktop\\ptixiaki2");
        p.analyze();
    }
    

}
