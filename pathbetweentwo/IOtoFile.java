package pathbetweentwo;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class IOtoFile {

    public List<String> inputFromFile(String pathName) {
        List<String> hasRead = new ArrayList<>();
        Path path = Paths.get(pathName);
        try {
            hasRead = Files.readAllLines(path, Charset.defaultCharset());
        } catch (NoSuchFileException e) {
            e.printStackTrace();
            System.err.println("File isn't found!");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error reading from file!");
        }
        return hasRead;
    }

    public void outputToFile(int[] outputData, String pathName) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File(pathName)))) {
            for (int i = 0; i < outputData.length; i++) {
                bw.write(outputData[i] + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error writing to file!");
        }
    }
}