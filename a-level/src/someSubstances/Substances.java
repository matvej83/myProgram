package someSubstances;

import java.util.*;

/***
 * This program is a part of home task.
 * Write program, that simulates different substances state of aggregation changing that dep[ends on temperature.
 *
 * Program scheme:
 *
 * Interface Substance:
 *  • method State heatUp(double t), that must change the temperature. It's realised by classes Water, Iron, Oxygen.
 *    This method returns substance state of aggregation.
 *  • method double getTemperature(), that returns the temperature.
 *  • enum State - contains all possible state of aggregation - liquid, solid or gas.
 *  User has choose one of the substances and after can to input values of the temperature changing. Every time, when
 *  he do it - print new substance temperature and state of aggregation at a given temperature.
 *  If user enter 0 - finish the program. Initial temperature for all the substances = 20 C.
 */
public class Substances {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Select substance from the list: 1-Water, 2-Iron, 3-Oxygen.");
        System.out.println(" To select input 1, 2 or 3 and press <Enter>:");
        int choice = sc.nextInt();
        double tempMagnitude = 1d;
        String isState = null;
        double currentTemperature = 0d;
        char continueOrNot = 0;
        switch (choice) {
            case 1:
                Water water = new Water(20d, State.liquid);
                System.out.println(water.getName());
                while (true) {
                    System.out.println("Input the magnitude of the temperature change:");
                    tempMagnitude = sc.nextInt();
                    if (tempMagnitude == 0) break;
                    isState = water.heatUp(tempMagnitude).toString();
                    currentTemperature = water.getTemperature();
                    displayResult(isState, currentTemperature);
                    continueOrNot = sc.next(".").charAt(0);
                    if (continueOrNot == 'y' || continueOrNot == 'Y') break;
                }
                break;
            case 2:
                Iron iron = new Iron(20d, State.solid);
                System.out.println(iron.getName());
                while (true) {
                    System.out.println("Input the magnitude of the temperature change:");
                    tempMagnitude = sc.nextInt();
                    if (tempMagnitude == 0) break;
                    isState = iron.heatUp(tempMagnitude).toString();
                    currentTemperature = iron.getTemperature();
                    displayResult(isState, currentTemperature);
                    continueOrNot = sc.next(".").charAt(0);
                    if (continueOrNot == 'y' || continueOrNot == 'Y') break;
                }
                break;
            case 3:
                Oxygen oxygen = new Oxygen(20d, State.gas);
                System.out.println(oxygen.getName());
                while (true) {
                    System.out.println("Input the magnitude of the temperature change:");
                    tempMagnitude = sc.nextInt();
                    if (tempMagnitude == 0) break;
                    isState = oxygen.heatUp(tempMagnitude).toString();
                    currentTemperature = oxygen.getTemperature();
                    displayResult(isState, currentTemperature);
                    continueOrNot = sc.next(".").charAt(0);
                    if (continueOrNot == 'y' || continueOrNot == 'Y') break;
                }
                break;
            default:
                System.out.println("Incorrect choice!");
                break;
        }

        sc.close();
    }

    public static void displayResult(String state, double temperature) {
        System.out.println("The state is " + state);
        System.out.println("Current temperature is " + temperature);
        System.out.println("Are you finished? Input 'y/Y' to exit or 'n/N' to continue");
    }
}
