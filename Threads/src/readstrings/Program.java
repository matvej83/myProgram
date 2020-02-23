package readstrings;

import java.util.Objects;
import java.util.Scanner;

/**
 * This program was created as a part of home task, that's given below.
 * Task:
 * User is entering lines in console. Entering text is accumulated in the variable "input". Parallel thread reads value
 * of the variable "input", and, if it has changed - writes data to the file with the  * name "output.txt" (value
 * overwrites every time). If the user enters "quit" - entering process stops, "input" value writes to the file
 * "output.txt" and program terminates. Line "quit" doesn't writes to the file.
 */

public class Program {

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        StringAnalyzer stringAnalyzer = new StringAnalyzer();
        String fileName = args[0];
        stringAnalyzer.setFileName(fileName);
        stringAnalyzer.start();

        while (true) {
            System.out.println("Enter the string:");
            String input = sc.next();
            stringAnalyzer.setNewString(input);
            if (Objects.equals(input, "quit")) {
                stringAnalyzer.stopThread();
                break;
            }
            Thread.sleep(100); //this command is stopping main() thread until parallel thread is running
        }
        sc.close();
    }
}
