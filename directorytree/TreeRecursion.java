package directorytree;

import java.io.File;
import java.util.Objects;

public class TreeRecursion {
    private static String counter = "+---";

    public static void printAllFilesFromDirectory(File dir) {
        try {
            for (File file : Objects.requireNonNull(dir.listFiles())) {
                System.out.println(counter + " " + file.getName());
                if (file.isDirectory()) {
                    counter = "+   ".concat(counter);
                    printAllFilesFromDirectory(file);
                }
            }
            counter = counter.substring(4);
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.err.println("The path shouldn't be empty!");
        }
    }
}
