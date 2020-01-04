package readstrings;

import java.io.*;
import java.nio.file.NoSuchFileException;

public class IOtoFile {

    public void outputStringToFile(String outputData, String pathName) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File(pathName)))) {
            bw.write(outputData);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error writing to file!");
        }
    }

    public String inputStringFromFile(String pathName) {
        String hasRead = "";
        try (BufferedReader br = new BufferedReader(new FileReader(new File(pathName)))) {
            hasRead = br.readLine();
        } catch (NoSuchFileException e) {
            e.printStackTrace();
            System.err.println("File isn't found!");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error reading from file!");
        }
        return hasRead;
    }
}