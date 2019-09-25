package SomeSubstances;

import java.util.*;

public class Substances {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Select substance from list: 1-Water, 2-Iron, 3-Oxygen.");
        System.out.println(" To select input 1, 2 or 3 and press <Enter>:");
        int choice = sc.nextInt();
        double tempMagnitude = 1d;
        switch (choice) {
            case 1:
                Water water = new Water(20d, State.liquid);
                System.out.println(water.getName());
                char continueOrNot = 0;
                while (true) {
                    System.out.println("Input the magnitude of the temperature change:");
                    tempMagnitude = sc.nextInt();
                    if (tempMagnitude == 0) break;
                    System.out.println("The water is " + water.heatUp(tempMagnitude));
                    System.out.println("Current temperature is " + water.getTemperature());
                    System.out.println("Are you finished? Input 'y/Y' to exit or 'n/N' to continue");
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
                    System.out.println("The iron is " + iron.heatUp(tempMagnitude));
                    System.out.println("Current temperature is " + iron.getTemperature());
                    System.out.println("Are you finished? Input 'y/Y' to exit or 'n/N' to continue");
                    continueOrNot = sc.next(".").charAt(0);
                    if (continueOrNot == 'y' || continueOrNot == 'Y') break;
                }
                break;
            case 3:
                Oxygen oxygen = new Oxygen(20d, State.gas);
                System.out.println(oxygen.getName());
                while (tempMagnitude != 0) {
                    System.out.println("Input the magnitude of the temperature change:");
                    tempMagnitude = sc.nextInt();
                    if (tempMagnitude == 0) break;
                    System.out.println("The oxygen is " + oxygen.heatUp(tempMagnitude));
                    System.out.println("Current temperature is " + oxygen.getTemperature());
                    System.out.println("Are you finished? Input 'y/Y' to exit or 'n/N' to continue");
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
}
