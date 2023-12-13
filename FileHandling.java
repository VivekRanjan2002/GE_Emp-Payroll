package org.bridgeLabz;
import java.io.*;
public class FileHandling {
    public static void main(String[] args) {
        // check if file InputFile.txt exist or not
        File file = new File("src/main/java/org/bridgeLabz/InputFile.txt");
        System.out.println(file.exists() && !file.isDirectory()); // true as file exist and not directory
        // Deleting file InputFile.txt
        System.out.println(file.delete()); // true as file is deleted
        // again checking the existence of InputFile.txt
        System.out.println(file.exists() && !file.isDirectory()); // false as not exist

        // creating Directory
        File dir = new File("src/main/java/org/bridgeLabz/javaFileIO/IOFile");
        if (!dir.exists()) {
            dir.mkdir();
            System.out.println("Directory IOFile created Successfully");
        } else {
            System.out.println("IOFile Directory already exists");
        }
        // creating Empty File named InputFile.txt
        if (!file.exists()) {
            file.canWrite();
            System.out.println("Directory IOFile created Successfully");
        } else {
            System.out.println("IOFile Directory already exists");
        }
        // List Files, Directories as well as Files with Extension in java
        String directoryPath = "src/main/java/org/bridgeLabz";
        File directory = new File(directoryPath);
        if (directory.exists() && directory.isDirectory()) {
            String[] filesAndDirs = directory.list();
            System.out.println("Printing all the files and directories inside: ");
            for (String E : filesAndDirs) {
                System.out.println(E);
            }
            // list files ending with  .txt file only
            File[] txtFile = directory.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.toLowerCase().endsWith(".txt");
                }
            });
            if (txtFile != null) {
                System.out.println("Printing all the files ending with .txt extension");
                for (File currfile : txtFile) {
                    System.out.println(currfile.getName());
                }
            } else {
                System.out.println("No such txt file exist in current directory");
            }
        } else {
            System.out.println("No such directory exist");

        }
    }
}
