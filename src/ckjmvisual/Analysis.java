
package ckjmvisual;
import static ckjmvisual.Project.deleteFolder;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Analysis implements Serializable{
    private Date date;
    private Project project;
    private ArrayList<JavaFile> javaFiles;
    private File tempFolder;
    
    public Analysis(Project project) throws IOException{
        
        this.date = new Date();
        this.javaFiles = new ArrayList<>();
        this.project = project;
        
        
        tempFolder = new File(project.getDirectory() + "\\temp_ckjm\\");
        if (tempFolder.exists()) {
            deleteFolder(tempFolder);
        }
        tempFolder.mkdirs();
        project.getClassFiles(project.getDirectory(), this);
    }
    
    public Date getDate(){
        return this.date;
    }
    
    public ArrayList<JavaFile> getAnalysisJavaFiles(){
        return this.javaFiles;
    }

    void startAnalyzing() {
        try {
            Process proc = Runtime.getRuntime().exec("cmd /c \"cd " + System.getProperty("user.dir") + " && "
                    + "java -jar ckjm-1.9.jar " + project.getDirectory() + "\\temp_ckjm\\*.class\"");
            BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                String[] line1 = line.split(" ");
                JavaFile javaFile = new JavaFile(line1[0],Integer.parseInt(line1[1]),Integer.parseInt(line1[2])
                        ,Integer.parseInt(line1[3]),Integer.parseInt(line1[4]),Integer.parseInt(line1[5])
                        ,Integer.parseInt(line1[6]),Integer.parseInt(line1[7]),Integer.parseInt(line1[8]));
                
                javaFiles.add(javaFile);
            }
            
            Collections.sort(javaFiles);
            project.deleteFolder(tempFolder);
        } catch (IOException ex) {
            Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    //Calulate Average for all the rates of the files
    public double caluclateRateAverage(){
        double total=0;
        for(JavaFile jf: javaFiles){
            total +=jf.getTotalRate();
        }
        return total/javaFiles.size();
    }
    
    //Getters
    public Project getProject() {
        return project;
    }

    public ArrayList<JavaFile> getJavaFiles() {
        return javaFiles;
    }

    public File getTempFolder() {
        return tempFolder;
    }
    
    
}
