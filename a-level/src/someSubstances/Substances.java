package someSubstances;

import java.util.*;

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
