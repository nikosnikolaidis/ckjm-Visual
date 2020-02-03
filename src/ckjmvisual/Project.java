
package ckjmvisual;

import java.util.ArrayList;


public class Project {
    
    private String name;
    private String directory;
    private ArrayList<JavaFile> javafiles;
    
    public Project(String name, String directory){
        this.name = name;
        this.directory = directory;
        this.javafiles = new ArrayList<>();
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
