package ckjmvisual;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Parser {

    public File file;
    
    public Parser(File file) {
        this.file = file;
        System.out.println("ckjmvisual.Parser.<init>()");
    }

    /**
     * Parses the results of ckjm and creates the JavaFiles
     */
    public ArrayList<JavaFile> parseText() {
        ArrayList<JavaFile> javaFiles = new ArrayList<JavaFile>();
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                String[] line1 = line.split(" ");
                JavaFile javaFile = new JavaFile(line1[0],Integer.parseInt(line1[1]),Integer.parseInt(line1[2])
                        ,Integer.parseInt(line1[3]),Integer.parseInt(line1[4]),Integer.parseInt(line1[5])
                        ,Integer.parseInt(line1[6]),Integer.parseInt(line1[7]),Integer.parseInt(line1[8]));
                
                javaFiles.add(javaFile);
            }
            
            return javaFiles;
            
        } catch (IOException ex) {
            Logger.getLogger(Parser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }


}
