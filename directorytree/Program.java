package directorytree;

import java.io.File;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        System.out.println("Enter the directory path:");
        Scanner s = new Scanner(System.in);
        String path = s.nextLine();
        File dir = new File(path);
        if (!dir.exists()) {
            System.err.println("Directory: " + path + " does'nt exist!");
        } else if (!dir.isDirectory()) {
            System.err.println("Given object isn't a directory!");
        } else {
            System.out.println(dir.getName());
            TreeRecursion.printAllFilesFromDirectory(dir);
        }
    }
}
