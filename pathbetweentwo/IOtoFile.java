package pathbetweentwo;

import java.io.*;
import java.util.ArrayList;

public class IOtoFile {

    public ArrayList<String> inputFromFile(String pathName) {
        ArrayList<String> hasRead = new ArrayList<>();
        try {
            File file = new File(pathName);
            BufferedReader br = new BufferedReader(new FileReader(file));
            while (br.readLine() != null) {
                hasRead.add(br.readLine());
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.err.println("File isn't found!");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error reading from file!");
        }
        return hasRead;
    }

    public void outputToFile(Double outputData[], String pathName) {
        try {
            File file = new File(pathName);
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            for (int i = 0; i < outputData.length; i++) {
                bw.write(outputData[i].toString() + System.lineSeparator());
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error writing to file!");
        }
    }
}
