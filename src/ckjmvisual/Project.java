
package ckjmvisual;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Project  implements Serializable{
    
    private String name;
    private String directory;
    private ArrayList<JavaFile> javafiles;
    
    public Project(String name, String directory){
        this.name = name;
        this.directory = directory;
        this.javafiles = new ArrayList<>();
    }
    
    // Run ckjm
    public void analyze(){
        try {
            System.out.println(System.getProperty("user.dir"));
            Process proc=Runtime.getRuntime().exec("cmd /c start cd \""+System.getProperty("user.dir")+"\" && "
                    +"java -jar ckjm-1.9.jar " + this.getDirectory());
            BufferedReader reader=new BufferedReader(new InputStreamReader(proc.getInputStream()));
            
            String line;
            System.out.println("Sonar Scanner in project folder");
            while((line = reader.readLine()) != null){
                System.out.println(line);
            }
        } catch (IOException ex) {
            Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    // Getters //
    public String getName() {
        return name;
    }
    public String getDirectory() {
        return directory;
    }
    public ArrayList<JavaFile> getJavafiles() {
        return javafiles;
    }
}
