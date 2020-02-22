package haffmancode;

import java.io.FileNotFoundException;

public class HaffmanApplication {
    //command line arguments:
    public static void main(String[] args) throws FileNotFoundException {
        String inputFile = args[0], outputFile = args[1];

        long startTime = System.currentTimeMillis();
        new HaffmanCode().compressData(inputFile, outputFile);
        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTime + " ms");
    }
}
