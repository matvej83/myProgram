package arithmeticprogression;

import java.util.Scanner;

/***
 * This program is a part of home task:
 *
 * Write the program, that calculates a value of an arithmetic progression element with given step.
 * Architecture:
 *
 * ArithmeticProgression class;
 * Fields:
 * private final int initial;
 * private final int step;
 *
 * initial - the first progression element
 * step - the step of progression
 *
 * constructors:
 * ArithmeticProgression(int initial, int step) throws ProgressionConfigurationException;
 *
 * methods:
 * int calculate(int n) throws ProgressionConfigurationException;
 *
 * n - element progression number
 *
 * ProgressionConfigurationException - checked Exception (создайте его сами). Он должен выбрасываться в двух случаях:
 * 1: n <= 0
 * 2: step == 0
 *
 * Exception must print appropriate message in both cases. Method calling and exception treatment realize in the main method.
 */
public abstract class Program implements TheMethodsForArithmeticProgression {
    public static void main(String[] args) throws ArithmeticProgression.ProgressionConfigurationException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the index of arithmetical progression member:");
        int index = scanner.nextInt();
        try {
            ArithmeticProgression newProgression = new ArithmeticProgression(0, 0);
            int theMember = newProgression.calculate(index);
            System.out.println("The " + index + "-th member of progression is " + theMember);
        } catch (ArithmeticProgression.ProgressionConfigurationException e) {
            throw new ArithmeticProgression.ProgressionConfigurationException("");
        }
        scanner.close();
    }
}
