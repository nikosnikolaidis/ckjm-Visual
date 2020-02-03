
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
<<<<<<< HEAD
                    +"java -jar ckjm-1.9.jar "+
                    "C:\\Users\\Nikos\\Desktop\\ptixiaki2\\bin\\ptixiaki\\*.class>"//this.getDirectory()
                    +">output.txt");
=======
                    +"java -jar ckjm-1.9.jar " + this.getDirectory());
>>>>>>> ac2b3bc3d72d9f4db8fcd0d8ac47201e45d05339
            BufferedReader reader=new BufferedReader(new InputStreamReader(proc.getInputStream()));
            
            String line;
            while((line = reader.readLine()) != null){
                System.out.println(line);
            }
            Parser parser= new Parser("output.txt");
            this.javafiles=parser.parseText();
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
