package ckjmvisual;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Project implements Serializable {

    private String name;
    private String directory;
    private ArrayList<JavaFile> javafiles;
    private File tempFolder;

    public Project(String name, String directory) throws IOException {
        this.name = name;
        this.directory = directory;
        this.javafiles = new ArrayList<>();

        tempFolder = new File(this.getDirectory() + "\\temp\\");
        tempFolder.mkdirs();
        getClassFiles(this.directory);
    }

    // Run ckjm
    public void analyze() {
        try {
            System.out.println(System.getProperty("user.dir"));
            Process proc = Runtime.getRuntime().exec("cmd /c start cd \"" + System.getProperty("user.dir") + "\" && "
                    + "java -jar ckjm-1.9.jar " + this.getDirectory() + "\\temp\\*.class"
                    + ">output.txt");

            //ToDo
            // output write doent work
            
            Thread.sleep(100);
            Parser parser = new Parser(new File(System.getProperty("user.dir") + "\\output.txt"));
            this.javafiles = parser.parseText();
        } catch (IOException ex) {
            Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getClassFiles(String directoryName) throws IOException {
        File directory = new File(directoryName);
        // Get all files from a directory.
        File[] fList = directory.listFiles();
        if (fList != null) {
            for (File file : fList) {
                if (file.isFile() && file.getName().contains(".") && file.getName().charAt(0) != '.') {
                    String[] str = file.getName().split("\\.");
                    if (str[str.length - 1].equalsIgnoreCase("class")) {
                        copyFile(file, new File(tempFolder.getAbsoluteFile() + "\\" + file.getName()));
                    }
                } else if (file.isDirectory()) {
                    getClassFiles(file.getAbsolutePath());
                }
            }
        }
    }

    // Copies file
    public void copyFile(File sourceLocation, File targetLocation) throws IOException {
        BufferedReader br;
        br = new BufferedReader(new FileReader(sourceLocation));
        BufferedWriter writer = new BufferedWriter(new FileWriter(targetLocation.getAbsoluteFile(), true));
        String line;
        while ((line = br.readLine()) != null) {
            writer.append(line);
        }
        writer.close();
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
