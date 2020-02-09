
package ckjmvisual;
import java.util.ArrayList;
import java.util.Date;

public class Analysis {
    private Date date;
    private ArrayList<JavaFile> javaFiles;
    
    public Analysis(ArrayList javaFiles){
        
        this.date = new Date();
        this.javaFiles = javaFiles;
        
    }
    
    public Date getDate(){
        return this.date;
    }
    
    public ArrayList<JavaFile> getAnalysisJavaFiles(){
        return this.javaFiles;
    }
}
