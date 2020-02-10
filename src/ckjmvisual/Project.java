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
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Project implements Serializable {

    private String name;
    private String directory;
    private ArrayList<JavaFile> javaFiles;
    private File tempFolder;

    public Project(String name, String directory) throws IOException {
        this.name = name;
        this.directory = directory;
        this.javaFiles = new ArrayList<>();

        tempFolder = new File(this.getDirectory() + "\\temp_ckjm\\");
        if (tempFolder.exists()) {
            deleteFolder(tempFolder);
        }
        tempFolder.mkdirs();
        getClassFiles(this.directory);
    }

    /**
     * Run ckjm and get results from cmd
     */
    public void analyze() {
        try {
            Process proc = Runtime.getRuntime().exec("cmd /c \"cd " + System.getProperty("user.dir") + " && "
                    + "java -jar ckjm-1.9.jar " + this.getDirectory() + "\\temp_ckjm\\*.class\"");
            BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                String[] line1 = line.split(" ");
                JavaFile javaFile = new JavaFile(line1[0],Integer.parseInt(line1[1]),Integer.parseInt(line1[2])
                        ,Integer.parseInt(line1[3]),Integer.parseInt(line1[4]),Integer.parseInt(line1[5])
                        ,Integer.parseInt(line1[6]),Integer.parseInt(line1[7]),Integer.parseInt(line1[8]));
                
                javaFiles.add(javaFile);
            }
            deleteFolder(tempFolder);
        } catch (IOException ex) {
            Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Gets .class files from a directory
     *
     * @param directoryName the path
     */
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

    /**
     * Copy file from a directory to another one
     *
     * @param sourceLocation the location of the file
     * @param targetLocation the destination
     */
    public void copyFile(File sourceLocation, File targetLocation) throws IOException {
        Files.copy(sourceLocation.toPath(), targetLocation.toPath());
    }

    /**
     * Deletes directory
     *
     * @param folder the folder to delete
     */
    public static void deleteFolder(File folder) {
        File[] files = folder.listFiles();
        if (files != null) { //some JVMs return null for empty dirs
            for (File f : files) {
                if (f.isDirectory()) {
                    deleteFolder(f);
                } else {
                    f.delete();
                }
            }
        }
        folder.delete();
    }

    // Getters //
    public String getName() {
        return name;
    }

    public String getDirectory() {
        return directory;
    }

    public ArrayList<JavaFile> getJavafiles() {
        return javaFiles;
    }
}
