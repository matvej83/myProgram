package arithmeticProgression;

import java.util.Scanner;

public abstract class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the index of arithmetical progression member:");
        int index = scanner.nextInt();
        try {
            ArithmeticProgression newProgression = new ArithmeticProgression(1, 5);
            System.out.println("The " + index + "-th member of progression is " + newProgression.calculate(index));
        } catch (ArithmeticProgression.ProgressionConfigurationException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
