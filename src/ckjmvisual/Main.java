
package ckjmvisual;

import java.util.ArrayList;
import java.io.*;

public class Main {
    
    public static ArrayList<Project> project = new ArrayList<>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        HomeFrame homeFrame=new HomeFrame();
        homeFrame.setVisible(true);
        //Read dummy file from location - replace with Project.directory
//         File file = new File("C:\\Users\\Sakis\\Desktop\\doc.txt");
//         BufferedReader br = new BufferedReader(new FileReader(file));
        
//         String line;
//         while((line = br.readLine()) != null){
//             System.out.println(line);
//         }
    }
    
}
