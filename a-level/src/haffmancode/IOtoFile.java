package haffmancode;

import java.io.*;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class IOtoFile {

    public void writeToBinary(String outputString, String pathName) {
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream(pathName))) {
            byte[] bytes = new BigInteger(outputString, 2).toByteArray();
            out.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error writing to file!");
        }
    }

    public List<String> inputStringsFromFile(String pathName) {
        List<String> hasRead = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(new File(pathName)))) {
            String tmp;
            while ((tmp = br.readLine()) != null) {
                hasRead.add(tmp);
            }
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