package arithmeticProgression;

import java.util.Scanner;

public abstract class Program implements TheMethodsForArithmeticProgression {
    public static void main(String[] args) throws ArithmeticProgression.ProgressionConfigurationException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the index of arithmetical progression member:");
        int index = scanner.nextInt();
        try{
        ArithmeticProgression newProgression = new ArithmeticProgression (0, 0);
        int theMember = newProgression.calculate(index);
            System.out.println("The " + index + "-th member of progression is " + theMember);
        }
            catch (ArithmeticProgression.ProgressionConfigurationException e){
                throw new ArithmeticProgression.ProgressionConfigurationException("");
            }
        scanner.close();
    }
}
