package iotest;

import java.io.File;
import java.io.IOException;

public class Programm {
    public static void main(String args[]) throws IOException {
        String thePath = args[0];
        File rootDir = new File(thePath);
        if (thePath.equals(null)) {
            System.err.println("Path doesn't exist!");
        } else if (!rootDir.isDirectory()) {
            System.err.println("Given path isn't a directory!");
        } else {
            System.out.println("Root directory: " + thePath);
            printAllFilesFromDirectory(rootDir);
        }
    }

    static void printAllFilesFromDirectory(File dir) {
        String counter = "+";
        for (File file : dir.listFiles()) {
            System.out.println(counter + " " + file.getName());
            if (file.isDirectory()) {
                counter += "\t+-";
                printAllFilesFromDirectory(file);
            } else counter += "\t+-";
        }
        counter = counter.substring(0, counter.length() - 1);
    }
}
