package hippodrome;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class IOtoFile {

    public void writeStringToFile(String outputData, String pathName) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File(pathName), true))) {
            bw.write(outputData.concat(System.lineSeparator()));
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error writing to file!");
        }
    }

    public List<String> readStringsFromFile(String pathName) {
        List<String> hasRead = new ArrayList<>();
        Path path = Paths.get(pathName);
        try {
            hasRead = Files.readAllLines(path, Charset.defaultCharset());
        } catch (NoSuchFileException e) {
            e.printStackTrace();
            System.err.println("File isn't found!");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error reading from a file!");
        }
        return hasRead;
    }

    public void clearFile(String pathName){
        File output = new File(pathName);
        try {
            if(output.exists()){
                output.delete();
                output.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}