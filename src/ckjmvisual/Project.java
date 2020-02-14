package ckjmvisual;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.ArrayList;

public class Project implements Serializable {

    private String name;
    private String directory;
    private ArrayList<Analysis> allAnalysis;

    public Project(String name, String directory) throws IOException {
        this.name = name;
        this.directory = directory;
        this.allAnalysis = new ArrayList<>();
    }

    /**
     * Run ckjm and get results from cmd
     */
    public void analyze() throws IOException {
        
        Analysis anal= new Analysis(this);
        anal.startAnalyzing();
        allAnalysis.add(anal);
    }

    /**
     * Gets .class files from a directory
     *
     * @param directoryName the path
     */
    public void getClassFiles(String directoryName, Analysis analysis) throws IOException {
        File directory = new File(directoryName);
        // Get all files from a directory.
        File[] fList = directory.listFiles();
        if (fList != null) {
            for (File file : fList) {
                if (file.isFile() && file.getName().contains(".") && file.getName().charAt(0) != '.') {
                    String[] str = file.getName().split("\\.");
                    if (str[str.length - 1].equalsIgnoreCase("class")) {
                        copyFile(file, new File(analysis.getTempFolder().getAbsoluteFile() + "\\" + file.getName()));
                    }
                } else if (file.isDirectory()) {
                    getClassFiles(file.getAbsolutePath(), analysis);
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

    public ArrayList<Analysis> getAllAnalysis() {
        return allAnalysis;
    }
}
